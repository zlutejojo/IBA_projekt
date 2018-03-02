package cz.IBA.servlet.service

import cz.IBA.servlet.entity.Sex
import cz.IBA.servlet.entity.Student
import org.junit.Before
import org.junit.Test
import java.text.DateFormat
import java.text.SimpleDateFormat
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;


class StudentServiceListImpTest extends groovy.util.GroovyTestCase {

    StudentServiceListImp studentService;

    @Before
    public void setUp() throws Exception {
        studentService = new StudentServiceListImp();
    }

    @Test
    void testCreatedStudentShouldBeInList() throws Exception {
        Student student = new Student();
        studentService.create(student);
        assertThat("Přidaný student není v seznamu.", studentService.readAll(), hasItem(student));
    }

    @Test
    void testCreatedStudentIsNotNull() throws Exception {
        Student student = new Student();
        studentService.create(student);
        assertThat("Objekt je null.",student, is(not(null)));
    }

    @Test
    void testCreatedStudentHasNotNullAttributes() throws Exception {
        Student student = new Student();
        student.setName("Jan")
        student.setSurname("Nový");

        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = "10/22/1999";
        Date dateObject = sdf.parse(dateString);
        student.setBirthday(dateObject);
        student.setSex(Sex.MALE);

        studentService.create(student);
        assertThat("Jméno je null.", student.getName(), is(not(null)));
        assertThat("Příjmení je null.", student.getSurname(), is(not(null)));
        assertThat("Datum narození je null.", student.getBirthday(), is(not(null)));
        assertThat("Pohlaví je null.", student.getSex(), is(not(null)));
    }

// todo

}
