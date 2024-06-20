package ps.demo.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import ps.demo.context.SpringIntegrationTest;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

public class VersionStep extends SpringIntegrationTest {

    @Autowired
    private DataSource dataSource;

    @When("^the client calls /version with (\\d+)$")
    public void the_client_issues_GET_version(Integer num) throws Throwable{
        executeGet("http://localhost:8086/version?num="+num);
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
