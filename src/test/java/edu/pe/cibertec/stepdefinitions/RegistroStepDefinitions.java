package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.java.Before;
import edu.pe.cibertec.tasks.RegisterSessions;
import edu.pe.cibertec.ui.RegisterPages;

public class RegistroStepDefinitions {

    private Actor actor;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Daniel");
    }

    @Given("the user navigates to the register page")
    public void theUserNavigatesToTheRegisterPage() {
        actor.attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/register")
        );
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void theUserFillsTheForm(String firstName, String lastName,
                                    String email, String phone,
                                    String password) {
        actor.attemptsTo(
                RegisterSessions.conDatos(firstName, lastName, email, phone, password)
        );
    }

    @And("accepts the privacy policy")
    public void acceptsThePrivacyPolicy() {
        actor.attemptsTo(
                Click.on(RegisterPages.PRIVACIDAD)
        );
    }

    @And("clicks on continue")
    public void clicksOnContinue() {
        actor.attemptsTo(
                Click.on(RegisterPages.CONTINUAMOS)
        );
    }


}