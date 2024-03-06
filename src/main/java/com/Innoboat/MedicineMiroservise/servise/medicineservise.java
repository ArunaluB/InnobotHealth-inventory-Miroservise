package com.Innoboat.MedicineMiroservise.servise;

import com.Innoboat.MedicineMiroservise.dto.MedicineDto;
import com.Innoboat.MedicineMiroservise.entity.MedicineEntity;

import java.util.List;

public interface medicineservise {
    void addmedicineservise(MedicineDto dto);
    List<MedicineDto> AllmedicineShow();
    MedicineEntity getMedicineName(String medicineName);
    MedicineEntity getMedicineId(Long id);

    MedicineEntity updateMedicine(MedicineDto dto);

    String deleteExpireMedicine(Long id);
}
