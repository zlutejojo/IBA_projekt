package cz.IBA.servlet.entity;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    
    private String name;
    private String surname;
    private Date birthday;
    private Sex sex;
    private long id;

}
