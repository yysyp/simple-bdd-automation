package ps.demo.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {

    private String name;

    private int age;

    private Date registerDate;

}
