package cz.IBA.servlet.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import cz.IBA.servlet.entity.Student;

public class StudentServiceListImp implements StudentService {

    //    todo dodělat komentáře

    /**
     * seznam všech studentů přidaných na webu /student
     */
    public static List<Student> studentList = new ArrayList<>();


    @Override
    public void create(Student newStudent) {
        studentList.add(newStudent);
    }

    @Override
    public List<Student> readAll() {
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
    public void update(int indexStudent, Student updatedStudent) {
        studentList.set(indexStudent, updatedStudent);
    }

    @Override
    public void delete(int indexStudent) {
        studentList.remove(indexStudent);
    }

    /**
     * formátuje tvar Date (př. Tue Oct 10 00:00:00 CEST 2017) na tvar vyžadovaný formulářem (př. 10.10.2017)
     */
    public static String formatDate(Date birthday){
        Format formatter = new SimpleDateFormat("MM/dd/yyyy");
        String formattedBirthday = null;
        try {
            formattedBirthday = formatter.format(birthday);
        } catch (IllegalArgumentException ex) {
            System.out.println("Birthday is empty.");
        }
        return formattedBirthday;
    }

}
