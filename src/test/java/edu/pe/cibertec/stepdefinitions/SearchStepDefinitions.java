package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;
import edu.pe.cibertec.questions.ResultSearch;
import edu.pe.cibertec.tasks.SearchProduct;

import java.util.List;

public class SearchStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    private Actor actor;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        actor = Actor.named("Estudiante");
        actor.can(BrowseTheWeb.with(driver));
    }

    @Given("the user is on the OpenCart home page")
    public void theUserIsOnTheOpenCartHomePage() {
        actor.attemptsTo(Open.url("https://naveenautomationlabs.com/opencart/"));
    }

    @When("the user searches for the product {string}")
    public void theUserSearchesForTheProduct(String product) {
        actor.attemptsTo(SearchProduct.conNombre(product));
    }

    @Then("the user should see at least one result with the name {string}")
    public void theUserShouldSeeAtLeastOneResultWithTheName(String expectedName) {
        List<String> results = actor.asksFor(ResultSearch.mostrados());
        actor.attemptsTo(
                Ensure.that(results).isNotEmpty(),
                Ensure.that(results).anyMatch("El nombre esperado no aparece",
                        name -> name.toLowerCase().contains(expectedName.toLowerCase()))
        );
    }

}