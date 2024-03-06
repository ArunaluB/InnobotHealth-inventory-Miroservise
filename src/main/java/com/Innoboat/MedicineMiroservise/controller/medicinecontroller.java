package com.Innoboat.MedicineMiroservise.controller;

import com.Innoboat.MedicineMiroservise.dto.MedicineDto;
import com.Innoboat.MedicineMiroservise.dto.MedicineDtoSU;
import com.Innoboat.MedicineMiroservise.servise.medicineservise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/medicine")
@RequiredArgsConstructor
public class medicinecontroller {

    private final medicineservise MedicineServise;


    @PostMapping("/saveMedi")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addmedicine(@RequestBody MedicineDto dto) {
        log.info("Received request to add medicine: {}", dto);
        try {
            MedicineServise.addmedicineservise(dto);
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            log.error("Failed to save medicine: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save medicine: " + e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<MedicineDto> getAllMedicine() {
        return MedicineServise.AllmedicineShow();
    }

    @GetMapping("/{id}")
    public MedicineDto getMedicineId(@PathVariable Long id){
        return MedicineServise.getMedicineId(id);
    }

    @GetMapping("/name/{medicineName}")
    public ResponseEntity<MedicineDtoSU> getMedicineByName(@PathVariable String medicineName) {
        MedicineDtoSU medicineDto = MedicineServise.getMedicineName(medicineName);
        if (medicineDto != null) {
            return new ResponseEntity<>(medicineDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

   // public








}
