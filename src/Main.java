import model.Epic;
import model.Subtask;
import model.Task;
import model.TaskStatus;
import service.Managers;
import service.TaskManager;


public class Main {

    public static void main(String[] args) {

        System.out.println("Поехали!");

        TaskManager manager = Managers.getDefault();


        Task task1 = new Task();
        Task task2 = new Task();
        manager.createTask(task1);
        manager.createTask(task2);


        Epic epic1 = new Epic();
        Epic epic2 = new Epic();
        manager.createEpic(epic1);
        manager.createEpic(epic2);


        Subtask subtask1 = new Subtask(epic1.getId());
        Subtask subtask2 = new Subtask(epic1.getId());
        Subtask subtask3 = new Subtask(epic2.getId());

        manager.createSubtask(subtask1);
        manager.createSubtask(subtask2);
        manager.createSubtask(subtask3);

        System.out.println(manager.getEpics());
        System.out.println(manager.getTasks());
        System.out.println(manager.getSubtasks());

        Task task3 = new Task(TaskStatus.DONE, task1.getId());
        Task task4 = new Task(TaskStatus.IN_PROGRESS,task2.getId());

        manager.updateTask(task3);
        manager.updateTask(task4);

        Subtask subtask4 = new Subtask(subtask1.getId(), TaskStatus.IN_PROGRESS, epic1.getId());
        Subtask subtask5 = new Subtask(subtask1.getId(), TaskStatus.DONE, epic1.getId());
        Subtask subtask6 = new Subtask(subtask3.getId(), TaskStatus.DONE, epic2.getId());

        manager.updateSubtask(subtask4);
        manager.updateSubtask(subtask5);
        manager.updateSubtask(subtask6);
        manager.updateEpic(epic1);
        manager.updateEpic(epic2);

        System.out.println();

        System.out.println(manager.getEpics());
        System.out.println(manager.getTasks());
        System.out.println(manager.getSubtasks());

        System.out.println();

        manager.deleteTaskById(2);
        manager.deleteEpicById(4);
        manager.deleteSubtaskById(6);

        printAllTasks(manager);

        System.out.println(manager.getEpics());
        System.out.println(manager.getTasks());
        System.out.println(manager.getSubtasks());
        System.out.println("Удаляем все задачи");
        manager.deleteAllTasks();
        manager.deleteAllEpics();
        manager.deleteAllSubtasks();

        System.out.println(manager.getEpics());
        System.out.println(manager.getTasks());
        System.out.println(manager.getSubtasks());
        System.out.println("Список задач пуст");

    }

    private static void printAllTasks(TaskManager manager) {
        System.out.println("Задачи:");
        for (Task task : manager.getTasks()) {
            System.out.println(task);
        }
        System.out.println("Эпики:");
        for (Task epic : manager.getEpics()) {
            System.out.println(epic);

            for (Task task : manager.getEpicSubtasks(epic.getId())) {
                System.out.println("--> " + task);
            }
        }
        System.out.println("Подзадачи:");
        for (Task subtask : manager.getSubtasks()) {
            System.out.println(subtask);
        }

        System.out.println("История:");
        for (Task task : manager.getHistory()) {
            System.out.println(task);
        }
    }
}