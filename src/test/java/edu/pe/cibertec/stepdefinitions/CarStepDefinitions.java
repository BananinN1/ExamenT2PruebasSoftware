package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.WebDriver;
import edu.pe.cibertec.questions.CountCar;
import edu.pe.cibertec.tasks.AddCar;
import edu.pe.cibertec.ui.CarPages;

import java.util.List;

public class CarStepDefinitions {

    @Managed(driver = "chrome")
    WebDriver driver;

    private Actor actor;

    @Before
    public void setTheStage() {
        actor = Actor.named("Estudiante");
        actor.can(BrowseTheWeb.with(driver));
    }

    @When("the user adds the product {string} to the cart")
    public void theUserAddsTheProductToTheCart(String productName) {
        actor.attemptsTo(AddCar.elProducto(productName));
    }

    @Then("the cart should show {string}")
    public void theCartShouldShow(String expectedText) {
        String cartTotal = actor.asksFor(CountCar.actual());
        actor.attemptsTo(Ensure.that(cartTotal).contains(expectedText));
    }

    @And("navigates to the cart")
    public void navigatesToTheCart() {
        actor.attemptsTo(Click.on(CarPages.SHOPPING_CART_LINK));
    }

    @Then("the user should see the product {string} in the cart list")
    public void theUserShouldSeeTheProductInTheCartList(String expectedProduct) {
        List<String> productNames = (List<String>) Text.ofEach(CarPages.CART_PRODUCT_NAMES).answeredBy(actor);
        actor.attemptsTo(Ensure.that(productNames).anyMatch(
                "El producto " + expectedProduct + " no aparece en el carrito",
                name -> name.trim().equalsIgnoreCase(expectedProduct)
        ));
    }
}