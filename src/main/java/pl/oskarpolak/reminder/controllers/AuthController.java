package pl.oskarpolak.reminder.controllers;

import pl.oskarpolak.reminder.models.UserInstance;
import pl.oskarpolak.reminder.models.UserModel;
import pl.oskarpolak.reminder.models.services.LoginService;
import pl.oskarpolak.reminder.models.services.RegisterService;
import pl.oskarpolak.reminder.views.LoginView;

import java.io.IOException;
import java.util.Scanner;

public class AuthController {
    private LoginView loginView;
    private LoginService loginService;
    private RegisterService registerService;

    private UserInstance userLoginInstance = UserInstance.getInstance();

    private Scanner scanner;

    public AuthController() {
        loginView = new LoginView();
        loginService = new LoginService();
        registerService = new RegisterService();

        scanner = new Scanner(System.in);
    }

    public void start() {
        loginView.showWelcomeMessage();
        loginView.printMenu();

        createMenu();
    }

    private void createMenu() {
        loginView.getMenuChoose();
        String choose = scanner.nextLine();

        switch (choose){
            case "1": {
                getLoginData();
                break;
            }
            case "2": {
                getRegisterData();
                break;
            }
            default: {
                loginView.showNotFoundCommand();
            }
        }
    }

    private void getRegisterData() {
        String username, password, passwordRepeat;
        boolean isRegister = false;

        do {
            loginView.showGetLoginText();
            username = scanner.nextLine();

            loginView.showGetPasswordText();
            password = scanner.nextLine();


            loginView.showGetPasswordRepeat();
            passwordRepeat = scanner.nextLine();

            if(!password.equals(passwordRepeat)){
                loginView.showPasswordRepeatIncorrect();
                continue;
            }

            UserModel userModel = new UserModel(username, password);
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

    private void getLoginData() {
        String username, password;
        boolean isLogin = false;

        do {
            loginView.showGetLoginText();
            username = scanner.nextLine();

            loginView.showGetPasswordText();
            password = scanner.nextLine();
            try {
                isLogin = loginService.tryToLogin(username, password);
            } catch (IOException e) {
                loginView.showErrorWithFileOnLoginPage();
                e.printStackTrace();
                System.exit(-1);
            }

            if(!isLogin){
                loginView.showIncorrectLoginData();
            }
        }while (!isLogin);

        //tutaj juz ktos jest zalgowany!
        startNewActivity(username);
    }

    private void startNewActivity(String username) {
        userLoginInstance.setUserLogin(true);
        userLoginInstance.setUsername(username);

        new MainController().start();
    }
}
