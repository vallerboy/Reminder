package pl.oskarpolak.reminder;

import pl.oskarpolak.reminder.controllers.LoginController;
import pl.oskarpolak.reminder.views.LoginView;

public class Starter {
    public static void main(String[] args) {
        new LoginController().start();
    }
}
