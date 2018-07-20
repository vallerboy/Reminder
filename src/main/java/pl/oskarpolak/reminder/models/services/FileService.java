package pl.oskarpolak.reminder.models.services;

import pl.oskarpolak.reminder.models.ConfigModel;
import pl.oskarpolak.reminder.models.TaskModel;
import pl.oskarpolak.reminder.models.UserModel;
import pl.oskarpolak.reminder.models.Utils;
import sun.security.krb5.Config;

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
            String[] simpleData = s.split(ConfigModel.IN_FILE_SEPARATOR);
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
                    Boolean.valueOf(simpleData[1]),
                    simpleData[2],
                    Utils.stringToDate(simpleData[3])));
        }

        return tasks;
    }

    public void addUserToFile(UserModel userModel) throws IOException {
        File file = new File(ConfigModel.PATH_TO_FILE_ACCOUNT);

        String userAsString = userModel.getUsername() + ConfigModel.IN_FILE_SEPARATOR + userModel.getPassword() + "\r\n";
        Files.write(file.toPath(), userAsString.getBytes(), StandardOpenOption.APPEND);
    }

    public void addTaskToFile(TaskModel model) throws IOException {
        File file = new File(ConfigModel.PATH_TO_FILE_TASKS);

        String taskAsString = model.getOwner() +
                ConfigModel.IN_FILE_SEPARATOR +
                model.isDone() +
                ConfigModel.IN_FILE_SEPARATOR +
                model.getContext() +
                ConfigModel.IN_FILE_SEPARATOR +
                Utils.dateToString(model.getDate()) +
                "\r\n";

        Files.write(file.toPath(), taskAsString.getBytes(), StandardOpenOption.APPEND);
    }

    public void clearTaskFile() throws IOException {
        File file = new File(ConfigModel.PATH_TO_FILE_TASKS);

        Files.write(file.toPath(), "".getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
    }
}
