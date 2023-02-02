package com.ltp.gradesubmission;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {

    @GetMapping("/grades")
    public ResponseEntity<String> getGrades() {
        String response = "These are your grades: A | A | A | A";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}