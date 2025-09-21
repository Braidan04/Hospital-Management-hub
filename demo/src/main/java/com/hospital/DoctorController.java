package com.hospital;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return Database.getDoctors();
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        Database.addDoctor(doctor);
        return doctor;
    }
}
