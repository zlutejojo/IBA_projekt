package cz.IBA.servlet.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import cz.IBA.servlet.entity.Sex;
import cz.IBA.servlet.entity.Student;
import lombok.SneakyThrows;

public class StudentServiceDbImpl implements StudentService {

//    todo napsat pro hibernate

    @Override
    public void create(Student newStudent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Student> readAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(int indexStudent, Student updatedStudent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int indexStudent) {
        throw new UnsupportedOperationException();
    }
}
