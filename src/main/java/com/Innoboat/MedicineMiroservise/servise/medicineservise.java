package com.Innoboat.MedicineMiroservise.servise;

import com.Innoboat.MedicineMiroservise.dto.MedicineDto;
import com.Innoboat.MedicineMiroservise.dto.MedicineDtoSU;
import com.Innoboat.MedicineMiroservise.entity.MedicineEntity;

import java.util.List;
import java.util.Optional;

public interface medicineservise {
    void addmedicineservise(MedicineDto dto);
    List<MedicineDtoSU> AllmedicineShow();
    MedicineDtoSU getMedicineName(String medicineName);
    MedicineDto getMedicineId(Long id);

    Optional<MedicineEntity> updateMedicine(MedicineDtoSU dto);

    String deleteExpireMedicine(String medicineName);

    List<MedicineDtoSU> ExpireMedicineShow();
}
