package cz.IBA.servlet.entity;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * data formuláře (POJO objekt)
 *
 * atribut datum narození: @DateTimeFormat - formátování tvaru Date dle patternu
 * atribut pohlaví: ve formuláři lze vybrat pouze ze dvou hodnot
 *
 * @author Jana Čižiková
 */

@Data  //POJO objekt
public class Student {


    @Size(min = 1, max = 60, message = "Musíte zadat 1 až 60 znaků.")
    private String name;

    @Size(min = 1, max = 60, message = "Musíte zadat 1 až 60 znaků.")
    private String surname;

    @NotNull(message = "Musíte vyplnit pole.")
//    todo: napsat vlastní message
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Past(message = "Nemůžete se narodit v budoucnosti.")
    private Date birthday;

    private Sex sex;
}
