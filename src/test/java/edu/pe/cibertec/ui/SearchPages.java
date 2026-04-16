package edu.pe.cibertec.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchPages extends PageObject {

    public static final Target BUSCARPRESIONO = Target.the("Campo de búsqueda")
            .located(By.name("search"));

    public static final Target SEARCH_BUTTON = Target.the("Botón de búsqueda")
            .located(By.cssSelector("button.btn.btn-default.btn-lg"));

    public static final Target PRODUCT_NAMES = Target.the("Nombres de productos")
            .located(By.cssSelector(".product-layout .caption h4 a"));

    public static final Target NO_RESULTS_MESSAGE = Target.the("Mensaje 'sin resultados'")
            .located(By.cssSelector("#content h2 + p"));

    public static final Target NO_RESULTS_PARAGRAPH = Target.the("Párrafo de sin resultados")
            .located(By.xpath("//div[@id='content']//p[contains(text(),'There is no product')]"));
}
