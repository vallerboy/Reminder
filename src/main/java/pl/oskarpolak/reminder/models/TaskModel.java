package pl.oskarpolak.reminder.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TaskModel {
    private String owner;
    private boolean isDone;
    private String context;
    private LocalDate date;


    public TaskModel(String owner, boolean isDone, String context, LocalDate date) {
        this.owner = owner;
        this.isDone = isDone;
        this.context = context;
        this.date = date;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskModel taskModel = (TaskModel) o;
        return isDone == taskModel.isDone &&
                Objects.equals(owner, taskModel.owner) &&
                Objects.equals(context, taskModel.context) &&
                Objects.equals(date, taskModel.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(owner, isDone, context, date);
    }

    @Override
    public String toString() {
        return "TaskModel{" +
                "owner='" + owner + '\'' +
                ", isDone=" + isDone +
                ", context='" + context + '\'' +
                ", date=" + date +
                '}';
    }
}
