package model;

import java.util.Objects;

public class Subtask extends Task {
    private int epicId;


    public Subtask(int id, TaskStatus taskStatus, int EpicId) {
        super(taskStatus, id);
        this.epicId = EpicId;
    }

    public Subtask(int id) {
    }


    public int getEpicId() {
        return epicId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), epicId);
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "epicId=" + getEpicId() +
                ", description='" + getDescription() + '\'' +
                ", id=" + getId() +
                ", name='" + getName() + '\'' +
                ", status=" + getStatus() +
                '}';

    }
}