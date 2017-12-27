package cz.IBA.servlet.entity;

import lombok.Data;

@Data  //POJO objekt
public class Student {
    private String name;
    private String surname;
    private String birthday;
    private String sex;
}
