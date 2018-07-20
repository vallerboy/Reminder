package pl.oskarpolak.reminder.models.services;

import pl.oskarpolak.reminder.models.TaskModel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
     private FileService fileService;
     public TaskService() {
         fileService = new FileService();
     }

    public void addTask(TaskModel model) throws IOException {
            fileService.addTaskToFile(model);
    }

    public List<TaskModel> getTasksForUser(String username) throws IOException {
       return  fileService.readAllTasks().stream()
               .filter(s -> s.getOwner().equals(username))
               .collect(Collectors.toList());
     }

    public List<TaskModel> getTasksForUser(String username, LocalDate localDate) throws IOException {
        return  fileService.readAllTasks().stream()
                .filter(s -> s.getOwner().equals(username) && s.getDate().equals(localDate))
                .collect(Collectors.toList());
    }

    public List<TaskModel> getTasksForUser(String username, LocalDate localDate, boolean isDone) throws IOException {
        return  fileService.readAllTasks().stream()
                .filter(s -> s.getOwner().equals(username) && s.getDate().equals(localDate) && s.isDone() == isDone)
                .collect(Collectors.toList());
    }

    public void updateTask(TaskModel chooseTask) throws IOException {
         List<TaskModel> allTaskModels = fileService.readAllTasks();

         fileService.clearTaskFile();

        for (TaskModel taskModel : allTaskModels) {
            //Szukamy w pliku naszego taksu do przeprowadzenia aktualizacji
            if(taskModel.getDate().equals(chooseTask.getDate()) &&
                    taskModel.getOwner().equals(chooseTask.getOwner()) &&
                        taskModel.getContext().equals(chooseTask.getContext())){
                taskModel.setDone(true);
            }

            fileService.addTaskToFile(taskModel);
        }
    }
}

