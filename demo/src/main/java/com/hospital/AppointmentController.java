package com.hospital;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return Database.getAppointments();
    }

    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        Database.addAppointment(appointment);
        return appointment;
    }
}
