package com.Innoboat.MedicineMiroservise.servise.impl;

import com.Innoboat.MedicineMiroservise.dto.MedicineDto;
import com.Innoboat.MedicineMiroservise.entity.MedicineEntity;
import com.Innoboat.MedicineMiroservise.repository.medicinerepository;
import com.Innoboat.MedicineMiroservise.servise.medicineservise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class medicineserviseimpl implements medicineservise {

    private final medicinerepository Mrepository;
    private final ModelMapper mapper;

    @Override
    public void addmedicineservise(MedicineDto dto) {
        log.info("Received Serviseclassimpl to add medicine: {}", dto);
        MedicineEntity mappEntity = mapper.map(dto,MedicineEntity.class);
        log.info("Convert model mapper Entity class: {}", dto);
        Mrepository.save(mappEntity);
    }

    @Override
    public List<MedicineDto> AllmedicineShow() {
        List<MedicineEntity> medicineEntities = Mrepository.findAll();
        // Convert each MedicineEntity to MedicineDto
        return medicineEntities.stream()
                .map(entity -> mapper.map(entity, MedicineDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public MedicineEntity getMedicineName(String medicineName) {
        return Mrepository.findByMedicineName(medicineName);
    }

    @Override
    public MedicineEntity getMedicineId(Long id) {
        return Mrepository.findById(id).get();
    }

    @Override
    public MedicineEntity updateMedicine(MedicineDto dto) {
        //get the existing document db
        MedicineEntity existingMedicine = Mrepository.findByMedicineName(dto.getMedicineName());
        existingMedicine = mapper.map(dto,MedicineEntity.class);
        return Mrepository.save(existingMedicine);
    }

    @Override
    public String deleteExpireMedicine(Long id) {
        Mrepository.deleteById(id);
        return "medicine Deleted ";
    }


}
