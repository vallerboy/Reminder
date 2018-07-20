package pl.oskarpolak.reminder.models.services;

import pl.oskarpolak.reminder.models.TaskModel;

import java.io.IOException;

public class TaskService {
     private FileService fileService;
     public TaskService() {
         fileService = new FileService();
     }

    public void addTask(TaskModel model) throws IOException {
            fileService.addTaskToFile(model);
    }
}
