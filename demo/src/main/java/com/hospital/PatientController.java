package com.hospital;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @GetMapping
    public List<Patient> getAllPatients() {
        return Database.getPatients();  // Make sure Database.getPatients() returns List<Patient>
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        Database.addPatient(patient);   // Make sure Database.addPatient(Patient) exists
        return patient;
    }
}
