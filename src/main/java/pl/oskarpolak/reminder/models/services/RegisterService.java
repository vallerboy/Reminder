package pl.oskarpolak.reminder.models.services;

import pl.oskarpolak.reminder.models.UserModel;

import java.io.IOException;
import java.util.List;

public class RegisterService {
    private FileService fileService;

    public RegisterService(){
        fileService = new FileService();
    }

    public boolean doRegister(UserModel userModel) throws IOException {
        if(!checkLoginIsFree(userModel.getUsername())){
            return false;
        }

        fileService.addUserToFile(userModel);
        return true;
    }

    private boolean checkLoginIsFree(String username) throws IOException {
        List<UserModel> userModelList = fileService.readUserModels();
        return userModelList.stream()
                .anyMatch(s -> s.getUsername().equals(username));
    }
}
