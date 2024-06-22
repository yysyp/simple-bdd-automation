package ps.demo.stepdefs;

import cn.hutool.http.HttpResponse;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import ps.demo.common.RetryUntil;
import ps.demo.common.ScenarioContext;
import ps.demo.context.SpringIntegrationTest;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

public class VersionStep extends SpringIntegrationTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ScenarioContext scenarioContext;

    @After
    public void cleanUp() {
        System.out.println("This only run once one cucumber scenario is completed.");
        scenarioContext.clear();
    }

    @When("^the client calls /version with (\\d+)$")
    public void the_client_issues_GET_version(Integer num) throws Throwable{
        executeGet("http://localhost:8086/version?num="+num);
    }

    @When("Get random value equals 9")
    public void getRandomEquals9() {
        Object data = new RetryUntil(() -> {
            HttpResponse response1 = executeGet("http://localhost:8086/randomNum");
            System.out.println("the server return randomNum = " + response1);
            boolean until = response1.getStatus() == 200 && response1.body().equals("9");
            return RetryUntil.Result.builder()
                    .until(until)
                    .data(response1).build();
        }).call();

        System.out.println("----->>>data="+data);

    }


    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        assertThat(response.getStatus()).isEqualTo(statusCode);
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(response.body()).isEqualTo(version);
    }



}
