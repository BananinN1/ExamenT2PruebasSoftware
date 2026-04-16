package edu.pe.cibertec.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import edu.pe.cibertec.ui.RegisterPages;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterSessions implements Task {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final String password;

    public RegisterSessions(String firstName, String lastName,
                           String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
        this.phone     = phone;
        this.password  = password;
    }

    public static RegisterSessions conDatos(String firstName, String lastName,
                                           String email, String phone,
                                           String password) {
        return instrumented(RegisterSessions.class,
                firstName, lastName, email, phone, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(RegisterPages.PRIMERNOMBRE),
                Enter.theValue(lastName).into(RegisterPages.SEGUNDONOMBRE),
                Enter.theValue(email).into(RegisterPages.EMAIL),
                Enter.theValue(phone).into(RegisterPages.FONO),
                Enter.theValue(password).into(RegisterPages.CONTRA),
                Enter.theValue(password).into(RegisterPages.CONFIRMAPAA)
        );
    }
}