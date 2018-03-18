package cz.IBA.servlet.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import cz.IBA.servlet.entity.StudentDto;

@Service
public class StudentServiceListImp implements StudentService {

    //    todo dodělat komentáře

    /**
     * seznam všech studentů přidaných na webu /student
     */
    private List<StudentDto> studentList = new ArrayList<>();


    @Override
    public void create(StudentDto newStudent) {
        studentList.add(newStudent);
    }

    @Override
    public List<StudentDto> readAll() {
        return Collections.unmodifiableList(studentList);
    }


//    todo dodělat, aby se vracel neměnitelný objekt, lépe
//    @Override
//    public Student read(int indexStudent) {
//        Student readStudent = new Student();
//        Student paramStudent = studentList.get(indexStudent);
//        readStudent.setName(paramStudent.getName());
//        readStudent.setSurname(paramStudent.getSurname());
//        readStudent.setBirthday(paramStudent.getBirthday());
//        readStudent.setSex(paramStudent.getSex());
//
//        return readStudent;
//    }

    @Override
    public void update(int indexStudent, StudentDto updatedStudent) {
        studentList.set(indexStudent, updatedStudent);
    }

    @Override
    public void delete(int indexStudent) {
        studentList.remove(indexStudent);
    }

    /**
     * formátuje tvar Date (př. Tue Oct 10 00:00:00 CEST 2017) na tvar vyžadovaný formulářem (př. 10.10.2017)
     */
    public String formatDate(Date birthday){
        Format formatter = new SimpleDateFormat("dd.MM.yyyy");
        String formattedBirthday = null;
        try {
            formattedBirthday = formatter.format(birthday);
        } catch (IllegalArgumentException ex) {
            System.out.println("Birthday is empty.");
        }
        return formattedBirthday;
    }

}
