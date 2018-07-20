package pl.oskarpolak.reminder.views;

import pl.oskarpolak.reminder.models.ConfigModel;
import pl.oskarpolak.reminder.models.TaskModel;

import java.util.List;

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

    public void showAddedTask(){
        System.out.println("Dodałes nowe zadanie!");
    }

    public void showTasksForToday(List<TaskModel> taskModelList) {
        System.out.println("Zadania na dziś: ");
        for (int i = 0; i < taskModelList.size(); i++) {
            System.out.println(i + ". " + taskModelList.get(i).getContext() + " (" + (taskModelList.get(i).isDone() ? "Zrobione" : "Do zrobienia") + ")");
        }
        System.out.println("--------------------------");
    }

    public void getTaskToDoneId() {
        System.out.print("Podaj id tasku: ");
    }

    public void showThisTaskIsAlreadyDone() {
        System.out.println("Ten task jest juz zrobiony");
    }
}
