package edu.pe.cibertec.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarPages extends PageObject {

    public static final Target CART_TOTAL = Target.the("Contador del carrito")
            .located(By.cssSelector("#cart-total"));

    public static Target addToCartButton(String productName) {
        String xpath = String.format(
                "//div[contains(@class,'product-layout')]//h4/a[text()='%s']/ancestor::div[contains(@class,'product-thumb')]//button[contains(@onclick,'cart.add')]",
                productName
        );
        return Target.the("Botón Add to Cart de " + productName)
                .located(By.xpath(xpath));
    }

    public static final Target SHOPPING_CART_LINK = Target.the("Enlace Shopping Cart")
            .located(By.cssSelector("a[title='Shopping Cart']"));

    public static final Target CART_PRODUCT_NAMES = Target.the("Nombres de productos en el carrito")
            .located(By.cssSelector("#content form .table-responsive table tbody tr td.text-left a"));
}