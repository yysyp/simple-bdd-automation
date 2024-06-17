package ps.demo.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;
import ps.demo.context.SpringIntegrationTest;

import static org.assertj.core.api.Assertions.assertThat;

public class VersionStep extends SpringIntegrationTest {

    @When("^the client calls /version with (\\d+)$")
    public void the_client_issues_GET_version(Integer num) throws Throwable{
        executeGet("http://localhost:8080/version?num="+num);
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
