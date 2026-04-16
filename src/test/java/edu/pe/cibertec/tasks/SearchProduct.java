package edu.pe.cibertec.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import edu.pe.cibertec.ui.SearchPages;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SearchProduct implements Task {

    private final String producto;

    public SearchProduct(String producto) {
        this.producto = producto;
    }

    public static SearchProduct conNombre(String producto) {
        return instrumented(SearchProduct.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SearchPages.BUSCARPRESIONO, isVisible()).forNoMoreThan(3).seconds(),
                Enter.theValue(producto).into(SearchPages.BUSCARPRESIONO),
                Click.on(SearchPages.SEARCH_BUTTON)
        );
    }
}