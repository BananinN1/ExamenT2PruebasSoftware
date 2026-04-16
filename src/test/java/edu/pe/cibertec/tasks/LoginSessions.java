package edu.pe.cibertec.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import edu.pe.cibertec.ui.LoginPages;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginSessions implements Task {

    private final String email;
    private final String password;

    public LoginSessions(String email, String password) {
        this.email    = email;
        this.password = password;
    }

    public static LoginSessions conCredenciales(String email, String password) {
        return instrumented(LoginSessions.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(LoginPages.EMAIL_FIELD),
                Enter.theValue(password).into(LoginPages.CONTRA)
        );
    }
}