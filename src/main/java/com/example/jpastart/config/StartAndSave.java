package com.example.jpastart.config;

import com.example.jpastart.model.Student;
import com.example.jpastart.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StartAndSave implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) {
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setName("Anne");
        studentRepository.save(std1);
        Student std2 = new Student();
        std2.setBorn(LocalDate.now().plusDays(1000));
        std2.setName("Viggo");
        studentRepository.save(std2);
    }
}
