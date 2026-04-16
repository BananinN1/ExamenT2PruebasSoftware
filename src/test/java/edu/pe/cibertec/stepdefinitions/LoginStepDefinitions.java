package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import edu.pe.cibertec.tasks.LoginSessions;
import edu.pe.cibertec.ui.LoginPages;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginStepDefinitions {

    private Actor actor;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Daniel");
    }

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        actor.attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/login")
        );
    }

    @When("the user enters email {string} and password {string}")
    public void theUserEntersEmailAndPassword(String email, String password) {
        actor.attemptsTo(
                LoginSessions.conCredenciales(email, password)
        );
    }

    @And("clicks on the login button")
    public void clicksOnTheLoginButton() {
        actor.attemptsTo(
                Click.on(LoginPages.LOGIN_BUTTON)
        );
    }

    @Then("the user should see the name {string} in the page header")
    public void theUserShouldSeeNameInHeader(String expectedName) {
        actor.attemptsTo(
                WaitUntil.the(LoginPages.ACCOUNT_LINK, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(LoginPages.ACCOUNT_LINK).isDisplayed()
        );
    }

}