package com.ltp.gradesubmission.exception;

public class StudentNotEnrolledException extends RuntimeException {
  
  public StudentNotEnrolledException(Long studentId, Long courseId) {
    super("The grade with student id: '" + studentId + "' and course id: '" + courseId + "' is not enrolled.");
}

}
