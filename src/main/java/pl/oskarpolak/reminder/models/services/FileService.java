package pl.oskarpolak.reminder.models.services;

import pl.oskarpolak.reminder.models.ConfigModel;
import pl.oskarpolak.reminder.models.TaskModel;
import pl.oskarpolak.reminder.models.UserModel;
import pl.oskarpolak.reminder.models.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    //username:password
    public List<UserModel> readUserModels() throws IOException {
        File file = new File(ConfigModel.PATH_TO_FILE_ACCOUNT);

        List<String> listOfString = Files.readAllLines(file.toPath());
        List<UserModel> userModels = new ArrayList<>();
        for (String s : listOfString) {
            String[] simpleData = s.split(":");
            userModels.add(new UserModel(simpleData[0], simpleData[1]));
        }

        return userModels;
    }

    //owner:isDone:context:date
    public List<TaskModel> readAllTasks() throws IOException {
        File file = new File(ConfigModel.PATH_TO_FILE_TASKS);

        List<String> listOfString = Files.readAllLines(file.toPath());
        List<TaskModel> tasks = new ArrayList<>();
        for (String s : listOfString) {
            String[] simpleData = s.split(":");
            tasks.add(new TaskModel(simpleData[0],
                    Boolean.getBoolean(simpleData[1]),
                    simpleData[2],
                    Utils.stringToDate(simpleData[3])));
        }

        return tasks;
    }

    public void addUserToFile(UserModel userModel) throws IOException {
        File file = new File(ConfigModel.PATH_TO_FILE_ACCOUNT);

        String userAsString = userModel.getUsername() + ":" + userModel.getPassword() + "\r\n";
        Files.write(file.toPath(), userAsString.getBytes(), StandardOpenOption.APPEND);
    }

}
