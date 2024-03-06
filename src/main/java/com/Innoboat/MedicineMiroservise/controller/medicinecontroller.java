package com.Innoboat.MedicineMiroservise.controller;

import com.Innoboat.MedicineMiroservise.dto.MedicineDto;
import com.Innoboat.MedicineMiroservise.servise.medicineservise;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public void addmedicine(@RequestBody MedicineDto dto){
        log.info("Received request to add medicine: {}", dto);
        MedicineServise.addmedicineservise(dto);
    }

    @GetMapping("/all")
    public List<MedicineDto> getAllMedicine(){
        return MedicineServise.AllmedicineShow();
    }

}
