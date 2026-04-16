package edu.pe.cibertec.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import edu.pe.cibertec.ui.CarPages;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddCar implements Task {

    private final String producto;

    public AddCar(String producto) {
        this.producto = producto;
    }

    public static AddCar elProducto(String producto) {
        return instrumented(AddCar.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CarPages.addToCartButton(producto), isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CarPages.addToCartButton(producto))
        );
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}