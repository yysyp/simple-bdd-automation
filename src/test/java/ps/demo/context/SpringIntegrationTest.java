package ps.demo.context;

import cn.hutool.Hutool;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ps.demo.dto.Student;

@CucumberContextConfiguration
@SpringBootTest
public class SpringIntegrationTest {

    @Autowired
    private Student student;

    protected HttpResponse response;
    public void executeGet(String url) {
        response = HttpUtil.createGet(url).execute();
        System.out.println("-->student="+student);

    }

}
