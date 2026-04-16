package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonPages {

    public static final Target PAGE_MESSAGE =
            Target.the("Page message")
                    .located(By.cssSelector("#content h1, .alert-danger, .alert-success, #content p"));
}