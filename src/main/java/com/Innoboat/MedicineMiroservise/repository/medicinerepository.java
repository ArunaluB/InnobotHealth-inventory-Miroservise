package com.Innoboat.MedicineMiroservise.repository;

import com.Innoboat.MedicineMiroservise.entity.MedicineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface medicinerepository extends MongoRepository<MedicineEntity,Long> {

    @Query("{medicineName: ?0 }")
    MedicineEntity findByMedicineName(String medicineName);
}
