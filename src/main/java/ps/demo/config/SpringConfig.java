package ps.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ps.demo.dto.Student;

@Configuration
public class SpringConfig {

    @Bean
    public Student studentBean() {
        Student student = new Student();
        student.setName("xiaoming");
        student.setAge(11);
        return student;
    }

}

