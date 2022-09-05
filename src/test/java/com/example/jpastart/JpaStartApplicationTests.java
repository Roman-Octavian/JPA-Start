package com.example.jpastart;

import com.example.jpastart.model.Student;
import com.example.jpastart.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class JpaStartApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testStudent() {
        Student std1 = new Student();
        std1.setBorn(LocalDate.now());
        std1.setName("Anne");
        studentRepository.save(std1);
        List<Student> lst = studentRepository.findAll();
        assertEquals(1, lst.size());

        studentRepository.delete(std1);
        lst = studentRepository.findAll();
        assertEquals(0, lst.size());

        Optional<Student> opt3 = studentRepository.findByName("Viggo");
        if (opt3.isPresent()) {
            Student std3 = opt3.get();
            assertEquals(std3.getName(), "Viggo");
        }
    }
}
