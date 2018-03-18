package cz.IBA.servlet.service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import cz.IBA.servlet.entity.Sex;
import cz.IBA.servlet.entity.StudentDto;

@Service
public class StudentServiceDbImpl implements StudentService{


    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * vloží záznam nového studenta do databáze
     */
    @Override
    public void create(StudentDto newStudent) {
        jdbcTemplate.update("INSERT INTO student (name, surname, birthday, sex) VALUES(?, ?, ?, ?)",
                newStudent.getName(),
                newStudent.getSurname(),
                formatDate(newStudent.getBirthday()),
                newStudent.getSex().toString()
                );
    }

    /**
     * vrátí všechny studenty z databáze
     */
    @Override
    public List<StudentDto> readAll() {
        return jdbcTemplate.query(
                "SELECT name, surname, birthday, sex, id FROM student",
                (rs,i) -> StudentDto.builder()
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .birthday(rs.getDate("birthday"))
                        .id(rs.getInt("id"))
                        .sex(Sex.valueOf(rs.getString("sex")))
                        .build()
        );
    }


    /**
     * nastaví vybranému studentovi (podle id) nové údaje z vloženého studenta
     */

//    netestováno
    @Override
    public void update(int idStudent, StudentDto updatedStudent) {
        int numberChangedRow = jdbcTemplate.update("UPDATE student SET name = ?, surname = ?, birthday = ?, sex = ? WHERE id = ?",
                updatedStudent.getName(),
                updatedStudent.getSurname(),
                formatDate(updatedStudent.getBirthday()),
                updatedStudent.getSex().toString(),
                idStudent);
        if (numberChangedRow < 1) {
            throw new OptimisticLockingFailureException("Záznam byl souběžně změněn jiným uživatelem. Vaše změny nelze uložit.");
        }


    }


    @Override
    public void delete(int indexStudent) {
        throw new UnsupportedOperationException();
    }


    public void createTable(String create) {
        jdbcTemplate.execute(create);
    }



    /**
     * formátuje tvar Date (př. Tue Oct 09 00:00:00 CEST 2017) na tvar vyžadovaný databází (př. 2017-10-09)
     */
    public String formatDate(Date birthday){
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedBirthday = null;
        try {
            formattedBirthday = formatter.format(birthday);
        } catch (IllegalArgumentException ex) {
            System.out.println("Birthday is empty.");
        }
        return formattedBirthday;
    }

}
