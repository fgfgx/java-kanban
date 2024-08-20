package main;

import main.models.*;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public interface TaskManager {
    Map<Integer, Task> getTaskHashMap();

    Map<Integer, Epic> getEpicHashMap();

    Map<Integer, Subtask> getSubtaskHashMap();

    List<Task> getHistory();


    TreeSet<Task> getPrioritizedTasks();

    // -----------------------------------------------------------
    // Методы для работы с задачами
    int getNewId();

    int getId();

    //  a. Получение списка всех задач.
    List<Task> getTasks();


    // b. Удаление всех задач.
    void deleteTasks() throws ManagerSaveException;

    //  c. Получение по идентификатору.
    Task getTask(int id) throws ManagerSaveException;


    // d. Создание. Сам объект должен передаваться в качестве параметра.
    void addTask(Task newTask) throws ManagerSaveException;

    //e. Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
    void updateTask(Task newTask) throws ManagerSaveException;

    // f. Удаление по идентификатору.
    void deleteTask(int id) throws ManagerSaveException;

    // g. изменение статуса задачи
    void changeTaskStatus(Task task, Status status) throws ManagerSaveException;

    //  a. Получение списка всех подзадач.
    List<Subtask> getSubtasks();

    //b. Удаление всех подзадач
    void deleteSubtasks() throws ManagerSaveException;

    //  c. Получение подзадачи по идентификатору.
    Subtask getSubtask(int id) throws ManagerSaveException;

    // d. Создание подзадачи. Сам объект должен передаваться в качестве параметра.
    void addSubtask(Subtask newSubtask) throws ManagerSaveException;


    //e. Обновление подзадачи. Новая версия объекта с верным идентификатором передаётся в виде параметра.
    void updateSubtask(Subtask newSubtask) throws ManagerSaveException;

    // f. Удаление подзадачи по идентификатору.
    void deleteSubtask(int id) throws ManagerSaveException;

    void changeSubtaskStatus(Subtask subtask, Status status) throws ManagerSaveException;

    //метод для проверки имеют ли все подзадачи эпика один и тот же статус
    boolean hasAllSubtaskSameStatus(Status status, Epic epic);

    // ЭПИКИ
    //Формирование нового индентификатора для эпика
    //  a. Получение списка всех эпиков.
    List<Epic> getEpics();

    // b. Удаление всех эпиков и их подзадач.
    void deleteEpics() throws ManagerSaveException;

    //  c. Получение по идентификатору.
    Epic getEpic(int id) throws ManagerSaveException;

    // d. Создание. Сам объект должен передаваться в качестве параметра.
    void addEpic(Epic newEpic) throws ManagerSaveException;

    //e. Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
    void updateEpic(Epic newEpic) throws ManagerSaveException;

    void removeEpicSubtask(Epic epic, int id) throws ManagerSaveException;

    // f. Удаление по идентификатору.
    void deleteEpic(int id) throws ManagerSaveException;

    // метод обновления статуса Эпика
    void updateEpicStatus(Epic epic) throws ManagerSaveException;


}
