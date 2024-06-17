package ps.demo.context;

import cn.hutool.Hutool;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import io.cucumber.spring.CucumberContextConfiguration;
import org.apache.commons.lang3.RandomUtils;
import org.awaitility.Awaitility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ps.demo.dto.Student;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@CucumberContextConfiguration
@SpringBootTest
public class SpringIntegrationTest {

    @Autowired
    private Student student;

    protected HttpResponse response;
    public void executeGet(String url) {
        response = HttpUtil.createGet(url).execute();
        System.out.println("-->student="+student);
        Awaitility.await()
                .timeout(5, TimeUnit.MINUTES)
                .pollDelay(1, TimeUnit.MINUTES)
                .pollInterval(Duration.ofSeconds(5))
                .until(() -> {
                    return RandomUtils.nextBoolean();
                });

    }

}
