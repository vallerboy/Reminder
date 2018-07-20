package pl.oskarpolak.reminder.views;

import pl.oskarpolak.reminder.models.ConfigModel;

public class MainView {
    public void showMenu() {
        System.out.println("1. Dodaj nowe zadanie");
        System.out.println("2. Oznacz zadanie jako wykonane");
        System.out.println("3. Wyjscie");
    }

    public void showWelcome(String username) {
        System.out.println("Witaj, " + username);
    }

    public void getFromUserChoice() {
        System.out.print("Podaj wybór: ");
    }

    public void showCommandNotExist() {
        System.out.println("Ta komenda nie istnieje");
    }

    public void showGetContextText() {
        System.out.print("Podaj treść zadania: ");
    }

    public void showGetDateText() {
        System.out.println("Podaj date, w formacie " + ConfigModel.DATE_FORMAT);
        System.out.print("Data: ");
    }
}
