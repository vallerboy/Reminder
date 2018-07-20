package pl.oskarpolak.reminder.controllers;

import pl.oskarpolak.reminder.models.TaskModel;
import pl.oskarpolak.reminder.models.UserInstance;
import pl.oskarpolak.reminder.models.UserModel;
import pl.oskarpolak.reminder.models.Utils;
import pl.oskarpolak.reminder.models.services.TaskService;
import pl.oskarpolak.reminder.views.MainView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class MainController {
    private UserInstance userInstance = UserInstance.getInstance();
    private MainView mainView;
    private TaskService taskService;
    private Scanner scanner;

    public MainController() {
        mainView = new MainView();
        scanner = new Scanner(System.in);
        taskService = new TaskService();
    }

    public void start() {
        mainView.showWelcome(userInstance.getUsername());

        String answer;
        do{
            mainView.showMenu();
            mainView.getFromUserChoice();
            answer = scanner.nextLine();

            switch (answer){
                case "1": {
                      addTask();
                      break;
                }
                case "2":{
                      //makeTaskDone();
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

                mainView.showGetContextText();
                context = scanner.nextLine();

                mainView.showGetDateText();
                date = scanner.nextLine();


                TaskModel taskModel =
                        new TaskModel(userInstance.getUsername(), false, context, Utils.stringToDate(date));
                try {
                    taskService.addTask(taskModel);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }

             mainView.showAddedTask();
        }
    }


