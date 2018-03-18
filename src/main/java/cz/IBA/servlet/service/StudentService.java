package cz.IBA.servlet.service;

import java.util.List;
import cz.IBA.servlet.entity.StudentDto;

public interface StudentService {

//    todo dodelat komentare

    void create(StudentDto newStudent);
    List<StudentDto> readAll();
//    Student read(int indexStudent);
    void update(int indexStudent, StudentDto updatedStudent);
    void delete(int indexStudent);
}
