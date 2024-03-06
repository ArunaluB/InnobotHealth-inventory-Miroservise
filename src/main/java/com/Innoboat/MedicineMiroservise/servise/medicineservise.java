package com.Innoboat.MedicineMiroservise.servise;

import com.Innoboat.MedicineMiroservise.dto.MedicineDto;
import com.Innoboat.MedicineMiroservise.dto.MedicineDtoSU;
import com.Innoboat.MedicineMiroservise.entity.MedicineEntity;

import java.util.List;

public interface medicineservise {
    void addmedicineservise(MedicineDto dto);
    List<MedicineDto> AllmedicineShow();
    MedicineDtoSU getMedicineName(String medicineName);
    MedicineDto getMedicineId(Long id);

    MedicineEntity updateMedicine(MedicineDto dto);

    String deleteExpireMedicine(Long id);
}
