package pl.oskarpolak.reminder.controllers;

import pl.oskarpolak.reminder.models.UserInstance;
import pl.oskarpolak.reminder.models.UserModel;
import pl.oskarpolak.reminder.views.MainView;

import java.io.IOException;
import java.util.Scanner;

public class MainController {
    private UserInstance userInstance = UserInstance.getInstance();
    private MainView mainView;
    private Scanner scanner;

    public MainController() {
        mainView = new MainView();
        scanner = new Scanner(System.in);

    }

    public void start() {
        mainView.showWelcome(userInstance.getUsername());

        String answer;
        do{
            mainView.getFromUserChoice();
            answer = scanner.nextLine();

            switch (answer){
                case "1": {
                      addTask();
                      break;
                }
                case "2":{
                      makeTaskDone();
                      break;
                }
                default: {
                    mainView.showCommandNotExist();
                }
            }

        }while (!answer.equals("exit"));
    }

    private void addTask() {
        String context, date;
            do {
                mainView.showGetContextText();
                context = scanner.nextLine();

                mainView.showGetDateText();
                date = scanner.nextLine();



                try {
                    isRegister = registerService.doRegister(userModel);
                } catch (IOException e) {
                    loginView.showErrorWithFileOnLoginPage();
                    e.printStackTrace();
                    System.exit(-1);
                }
                if(!isRegister){
                    loginView.showLoginBusyOrPasswordRepeatIncorrect();
                }
            }while (!isRegister);


            //tutaj juz ktos jest zarejestrowany!
            startNewActivity(username);
        }
    }
}
