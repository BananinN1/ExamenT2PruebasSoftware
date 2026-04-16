package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class RegisterPages {

    public static final Target PRIMERNOMBRE =
            Target.the("First Name field")
                    .located(By.id("input-firstname"));

    public static final Target SEGUNDONOMBRE =
            Target.the("Last Name field")
                    .located(By.id("input-lastname"));

    public static final Target EMAIL =
            Target.the("Email field")
                    .located(By.id("input-email"));

    public static final Target FONO =
            Target.the("Telephone field")
                    .located(By.id("input-telephone"));

    public static final Target CONTRA =
            Target.the("Password field")
                    .located(By.id("input-password"));

    public static final Target CONFIRMAPAA =
            Target.the("Confirm Password field")
                    .located(By.id("input-confirm"));

    public static final Target PRIVACIDAD =
            Target.the("Privacy Policy checkbox")
                    .located(By.cssSelector("input[name='agree']"));

    public static final Target CONTINUAMOS =
            Target.the("Continue button")
                    .located(By.cssSelector("input[value='Continue']"));

    public static final Target SUCCESS_MESSAGE =
            Target.the("Success message")
                    .located(By.cssSelector("#content h1"));
}