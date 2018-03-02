package cz.IBA.servlet.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import cz.IBA.servlet.service.StudentServiceListImp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * data formuláře (POJO objekt)
 *
 * atribut datum narození: @DateTimeFormat - formátování tvaru Date dle patternu
 * atribut pohlaví: ve formuláři lze vybrat pouze ze dvou hodnot
 *
 * @author Jana Čižiková
 */

//@Builder

@Data  //POJO objekt  - getter, setter, requiredAllArgCon, eqaul+hashCode, toString
@Entity   //entity bean
//@Table(name="Student")
public class Student {
//    @Column(name="myname")  // můžu zadat na jaký sloupec chci mapovat
    @Size(min = 1, max = 60, message = "Musíte zadat 1 až 60 znaků.")
    private String name;

    @Size(min = 1, max = 60, message = "Musíte zadat 1 až 60 znaků.")
    private String surname;

    @NotNull(message = "Musíte vyplnit pole.")
//    todo: napsat vlastní message
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @Past(message = "Nemůžete se narodit v budoucnosti.")
    private Date birthday;

    private Sex sex;

    @Id
    @GeneratedValue
    private int id;


    public String toString() {

        String date = StudentServiceListImp.formatDate(birthday);

        return name + " " + surname + " " + date + " " + sex;
    }


}
