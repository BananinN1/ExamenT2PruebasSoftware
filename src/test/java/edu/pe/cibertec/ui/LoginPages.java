package edu.pe.cibertec.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPages {

    public static final Target EMAIL_FIELD =
            Target.the("Email field")
                    .located(By.id("input-email"));

    public static final Target CONTRA =
            Target.the("Password field")
                    .located(By.id("input-password"));

    public static final Target LOGIN_BUTTON =
            Target.the("Login button")
                    .located(By.cssSelector("input[value='Login']"));

    public static final Target ACCOUNT_LINK = Target.the("My Account link in header")
            .located(By.cssSelector("a[title='My Account']"));

    public static final Target WARNING_MESSAGE =
            Target.the("Warning message")
                    .located(By.cssSelector(".alert.alert-danger"));
}