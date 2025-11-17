Java реализации
Приоритетная очередь - система управления задачами

java
import java.util.*;

class TaskManager {
    private PriorityQueue<Task> taskQueue;
    
    static class Task implements Comparable<Task> {
        String name;
        int priority;
        String description;
        
        Task(String name, int priority, String description) {
            this.name = name;
            this.priority = priority;
            this.description = description;
        }
        
        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }
        
        @Override
        public String toString() {
            return String.format("Задача: %s | Приоритет: %d | Описание: %s", 
                               name, priority, description);
        }
    }
    
    public TaskManager() {
        taskQueue = new PriorityQueue<>();
    }
    
    public void addTask(String name, int priority, String description) {
        Task task = new Task(name, priority, description);
        taskQueue.offer(task);
        System.out.println("Добавлена задача: " + name);
    }
    
    public void processTasks() {
        System.out.println("\nОбработка задач:");
        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.poll();
            System.out.println("Выполняется: " + task);
        }
    }
    
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        
        manager.addTask("База данных", 1, "Настроить резервное копирование");
        manager.addTask("Интерфейс", 3, "Обновить дизайн");
        manager.addTask("Безопасность", 1, "Исправить уязвимости");
        manager.addTask("Документация", 2, "Обновить руководство");
        
        manager.processTasks();
    }
}
