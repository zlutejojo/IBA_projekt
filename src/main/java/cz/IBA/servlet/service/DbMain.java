package cz.IBA.servlet.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import com.zaxxer.hikari.HikariDataSource;
import cz.IBA.servlet.entity.Sex;
import cz.IBA.servlet.entity.Student;
import lombok.SneakyThrows;

@Configuration
@ComponentScan
public class DbMain {

    @Value("jdbc:hsqldb:mem:student")
    private String databaseUrl;

    @Value("ja")
    private String databaseUsername;

    @Value("tajne")
    private String databasePassword;


    @Bean
    public DataSource dataSource() {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(databaseUrl);
        hikariDataSource.setUsername(databaseUsername);
        hikariDataSource.setPassword(databasePassword);

        return hikariDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate;
        jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @SneakyThrows
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(DbMain.class);

        String createTableStudent = "CREATE TABLE student (id INTEGER IDENTITY PRIMARY KEY, name VARCHAR(60), surname VARCHAR(60), birthday DATE, sex VARCHAR(6))";

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "1999-02-11";
        Date dateObject = sdf.parse(dateString);

        Student studentKalina = Student.builder()
                .name("Marek")
                .surname("Kalina")
                .birthday(dateObject)
                .sex(Sex.MALE)
                .build();

        
        StudentServiceDbImpl studentServiceDb = applicationContext.getBean(StudentServiceDbImpl.class);
        studentServiceDb.createTable(createTableStudent);
        studentServiceDb.create(studentKalina);
        studentServiceDb.readAll().forEach(System.out::println);
        

    }


}
