package cz.IBA.servlet.service;

import java.util.List;
import cz.IBA.servlet.entity.Student;

public interface StudentService {

//    todo dodelat komentare

    void create(Student newStudent);
    List<Student> readAll();
//    Student read(int indexStudent);
    void update(int indexStudent, Student updatedStudent);
    void delete(int indexStudent);
}
