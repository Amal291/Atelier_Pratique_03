package com.example.atelier_pratique_03;

import com.example.atelier_pratique_03.entities.Patient;
import com.example.atelier_pratique_03.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class AtelierPratique03Application {

    public static void main(String[] args) {
        SpringApplication.run(AtelierPratique03Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Hassan", new Date(), false, 12));
            patientRepository.save(new Patient(null, "Mohammed", new Date(), true, 12));
            patientRepository.save(new Patient(null, "Yasmine", new Date(), true, 12));
            patientRepository.save(new Patient(null, "Hanae", new Date(), false, 12));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
}
