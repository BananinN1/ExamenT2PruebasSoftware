package edu.pe.cibertec.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import edu.pe.cibertec.ui.CarPages;

public class CountCar implements Question<String> {

    public static CountCar actual() {
        return new CountCar();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CarPages.CART_TOTAL).answeredBy(actor);
    }
}