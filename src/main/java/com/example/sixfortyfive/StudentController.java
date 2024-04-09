package com.example.sixfortyfive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/survey")
    @CrossOrigin
    public ResponseEntity<Student> addSurveyDataToDatabase(@RequestBody Student student) {
        Student save = studentRepository.save(student);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/survey")
    @CrossOrigin
    public ResponseEntity<Iterable<Student>> getAllStudentData() {
        Iterable<Student> all = studentRepository.findAll();
        return ResponseEntity.ok(all);
    }

    @DeleteMapping("/survey")
    @CrossOrigin
    public ResponseEntity<String> deleteStudentSurveyData(@RequestParam Long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/survey")
    @CrossOrigin
    public ResponseEntity<Student> updateStudentSurveyData(@RequestParam Long id, @RequestBody Student student) {
        student.setId(id);
        studentRepository.save(student);
        return ResponseEntity.ok(student);
    }
}
