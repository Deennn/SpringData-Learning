package com.deenn.springdatajpa.repository;

import com.deenn.springdatajpa.entity.Guardian;
import com.deenn.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .email("deenn@gmail.com")
                .firstName("Lawal")
                .lastName("Deenn")

//                .guardianName("Aba")
//                .guardianEmail("aba@gmail.com")
//                .guardianMobile("9999999")
                .build();


        studentRepository.save(student);
    }
    @Test
    public void getAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }
    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Aba")
                .email("aba@gmail.com")
                .mobile("9999999")

                .build();

        Student student = Student.builder()
                .email("deen@gmail.com")
                .firstName("Lawal")
                .lastName("Deenn")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void getStudentByFirstName() {
       List<Student > student = studentRepository.findByFirstName("lawal");
        System.out.println(student);

    }

    @Test
    public void getStudentByFirstNameContaining() {
        List<Student > student = studentRepository.findByFirstNameContaining("la");
        System.out.println(student);

    }
    @Test
    public void  getStudentByEmail() {
        System.out.println(studentRepository.getStudentByEmail("deenn@gmail.com"));
    }
    @Test
   public void getStudentFirstNameByEmail() {
       System.out.println(studentRepository.getStudentFirstNameByEmail("deenn@gmail.com"));
   }

   @Test
    public void getStudentFirstNameByEmailNative() {
       System.out.println(studentRepository.getStudentFirstNameByEmailNative("deenn@gmail.com"));
   }

   @Test
    public void getStudentFirstNameByEmailNatives() {
       System.out.println(studentRepository.getStudentFirstNameByEmailNatives("deen@gmail.com"));
   }

   @Test
    public void updateStudent() {
        studentRepository.updateStudent("kkk", "deenn@gmail.com");
   }

}