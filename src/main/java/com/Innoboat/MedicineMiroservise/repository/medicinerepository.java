package com.Innoboat.MedicineMiroservise.repository;

import com.Innoboat.MedicineMiroservise.entity.MedicineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface medicinerepository extends MongoRepository<MedicineEntity,Long> {
    MedicineEntity findByMedicineName(String medicineName);
}
