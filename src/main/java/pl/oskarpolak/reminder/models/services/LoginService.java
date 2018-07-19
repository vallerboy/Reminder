package pl.oskarpolak.reminder.models.services;

import pl.oskarpolak.reminder.controllers.MainController;
import pl.oskarpolak.reminder.models.UserModel;

import java.io.IOException;
import java.util.List;

public class LoginService {
    private FileService fileService;

    public LoginService() {
        fileService = new FileService();
    }

    public boolean tryToLogin(String username, String password) throws IOException {
        List<UserModel> userModelList = fileService.readUserModels();
        return userModelList.stream().anyMatch(s -> s.getPassword().equals(password) && s.getUsername().equals(username));
    }
}
