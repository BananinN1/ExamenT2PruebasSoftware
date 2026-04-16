package edu.pe.cibertec.stepdefinitions;

import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import edu.pe.cibertec.ui.CommonPages;

import java.util.List;

public class CommonStepDefinitionsIncreible {

    @Then("the user should see the message {string}")
    public void theUserShouldSeeTheMessage(String expectedMessage) {
        Actor actor = OnStage.theActorInTheSpotlight();

        if (expectedMessage.toLowerCase().contains("there is no product")) {
            WebDriver driver = ThucydidesWebDriverSupport.getDriver();
            List<WebElement> paragraphs = driver.findElements(By.cssSelector("#content p"));

            boolean found = paragraphs.stream()
                    .anyMatch(p -> p.getText().trim().contains(expectedMessage));

            if (!found) {
                throw new AssertionError(
                        "Expected to find paragraph containing: [" + expectedMessage + "]\n" +
                                "Paragraphs found: " + paragraphs.stream()
                                .map(p -> "[" + p.getText().trim() + "]")
                                .reduce("", (a, b) -> a + "\n  " + b)
                );
            }
        } else {
            actor.attemptsTo(
                    Ensure.that(CommonPages.PAGE_MESSAGE)
                            .text()
                            .containsIgnoringCase(expectedMessage)
            );
        }
    }
}