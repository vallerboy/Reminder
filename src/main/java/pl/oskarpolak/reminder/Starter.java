package pl.oskarpolak.reminder;

import pl.oskarpolak.reminder.controllers.AuthController;

public class Starter {
    public static void main(String[] args) {
        new AuthController().start();
    }
}
