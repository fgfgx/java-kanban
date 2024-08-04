package service;

public class Managers {

    private Managers() {
    }

    public static InMemoryTaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory() {
        return (HistoryManager) new InMemoryHistoryManager();
    }
}