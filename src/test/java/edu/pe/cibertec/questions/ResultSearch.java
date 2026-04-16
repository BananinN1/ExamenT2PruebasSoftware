package edu.pe.cibertec.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import edu.pe.cibertec.ui.SearchPages;

import java.util.List;

public class ResultSearch implements Question<List<String>> {

    public static ResultSearch mostrados() {
        return new ResultSearch();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return (List<String>) Text.ofEach(SearchPages.PRODUCT_NAMES).answeredBy(actor);
    }
}
