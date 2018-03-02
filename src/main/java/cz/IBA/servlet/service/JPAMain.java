package cz.IBA.servlet.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import cz.IBA.servlet.entity.Sex;
import cz.IBA.servlet.entity.Student;
import lombok.SneakyThrows;

public class JPAMain {

//zjednodušená testovací třída


/* POSTUP

https://www.tutorialspoint.com/hibernate/hibernate_annotations.htm

přidala jsem si dependency
v resources přidán konfigurační soubor hibernate.cfg.xml
v entity Student přidány anotace (pro bean entitu a id)
vytvořeno session pro práci s tabulkou
 */

    private static SessionFactory factory;
    @SneakyThrows
    public static void main(String[] args) {

        try {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        JPAMain main = new JPAMain();
      /* přidání studenta, testovací */
        main.createStudent("Marek", "nový", "1999-10-22", Sex.MALE);
        List<Student> studentLst = main.readAll();
        System.out.println(studentLst);
    }
//    přidání studenta, testovací
    @SneakyThrows
    public void createStudent(String name, String surname, String birthday, Sex sex){
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateObject = sdf.parse(birthday);
            Student newStudent = new Student();
            newStudent.setName(name);
            newStudent.setSurname(surname);
            newStudent.setBirthday(dateObject);
            newStudent.setSex(sex);
            session.save(newStudent);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
//    čtení všech studentů, testovací
    public List<Student> readAll( ){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Student> studentLst= null;
        try {
            tx = session.beginTransaction();
//          vrátí mi array of Object
            studentLst = session.createQuery("SELECT name, surname, birthday, sex, id FROM Student").getResultList();
            System.out.println(studentLst);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return studentLst;
    }
}

