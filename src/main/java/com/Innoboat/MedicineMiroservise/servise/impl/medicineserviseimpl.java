package com.Innoboat.MedicineMiroservise.servise.impl;

import com.Innoboat.MedicineMiroservise.dto.MedicineDto;
import com.Innoboat.MedicineMiroservise.dto.MedicineDtoSU;
import com.Innoboat.MedicineMiroservise.entity.MedicineEntity;
import com.Innoboat.MedicineMiroservise.repository.medicinerepository;
import com.Innoboat.MedicineMiroservise.servise.medicineservise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class medicineserviseimpl implements medicineservise {

    private final medicinerepository Mrepository;
    private final ModelMapper mapper;
    private final SequenceService sequenceService;


    @Override
    public void addmedicineservise(MedicineDto dto) {
        log.info("Received Serviseclassimpl to add medicine: {}", dto);
        MedicineEntity mappEntity = mapper.map(dto,MedicineEntity.class);
        // Generate the next sequence value
        mappEntity.setStockid(sequenceService.getNextSequence("stockid"));
        log.info("Convert model mapper Entity class: {}", dto);
        Mrepository.save(mappEntity);
    }

    @Override
    public List<MedicineDtoSU> AllmedicineShow() {
        List<MedicineEntity> medicineEntities = Mrepository.findAll();
        // Convert each MedicineEntity to MedicineDto
        return medicineEntities.stream()
                .map(entity -> mapper.map(entity, MedicineDtoSU.class))
                .collect(Collectors.toList());
    }

    @Override
    public MedicineDtoSU getMedicineName(String medicineName) {
        MedicineEntity medicineEntity = Mrepository.findByMedicineName(medicineName);
        return mapper.map(medicineEntity, MedicineDtoSU.class);
    }


    @Override
    public MedicineDto getMedicineId(Long id) {
        MedicineEntity DEntity = Mrepository.findById(id).get();
        return mapper.map(DEntity, MedicineDto.class);
    }

    @Override
    public Optional<MedicineEntity> updateMedicine(MedicineDtoSU dto) {
        log.info("Received details to update: {}", dto);
        // Find the medicine entity by its name
        Optional<MedicineEntity> optionalEntity = Optional.ofNullable(Mrepository.findByMedicineName(dto.getMedicineName()));
        if (optionalEntity.isPresent()) {
            // If the entity exists, update its details
            MedicineEntity entityToUpdate = optionalEntity.get();
            entityToUpdate.setMedicineName(dto.getMedicineName());
            entityToUpdate.setQuantity(dto.getQuantity());
            entityToUpdate.setUnitPrice(dto.getUnitPrice());

            // Save the updated entity
            MedicineEntity updatedEntity = Mrepository.save(entityToUpdate);
            log.info("Updated entity: {}", updatedEntity);
            return Optional.of(updatedEntity);
        } else {
            log.info("No medicine found with name: {}", dto.getMedicineName());
            return Optional.empty();
        }
    }


    @Override
    public String deleteExpireMedicine(Long id) {
        Mrepository.deleteById(id);
        return "medicine Deleted ";
    }


}
