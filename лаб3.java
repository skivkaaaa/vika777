Java реализации
Куча Фибоначчи - система планирования процессов

java
import java.util.*;

class ProcessScheduler {
    private PriorityQueue<Process> queue;
    
    static class Process implements Comparable<Process> {
        String name;
        int priority;
        int burstTime;
        
        Process(String name, int priority, int burstTime) {
            this.name = name;
            this.priority = priority;
            this.burstTime = burstTime;
        }
        
        @Override
        public int compareTo(Process other) {
            return Integer.compare(this.priority, other.priority);
        }
        
        @Override
        public String toString() {
            return String.format("Процесс: %s | Приоритет: %d | Время: %d", 
                               name, priority, burstTime);
        }
    }
    
    public ProcessScheduler() {
        queue = new PriorityQueue<>();
    }
    
    public void addProcess(String name, int priority, int burstTime) {
        queue.offer(new Process(name, priority, burstTime));
        System.out.println("Добавлен процесс: " + name);
    }
    
    public void executeProcesses() {
        System.out.println("\nВыполнение процессов:");
        while (!queue.isEmpty()) {
            Process process = queue.poll();
            System.out.println("Выполняется: " + process);
        }
    }
    
    public static void main(String[] args) {
        ProcessScheduler scheduler = new ProcessScheduler();
        scheduler.addProcess("P1", 2, 10);
        scheduler.addProcess("P2", 1, 5);
        scheduler.addProcess("P3", 3, 8);
        scheduler.executeProcesses();
    }
}
Хеш-таблица - кэш данных

java
import java.util.*;

class DataCache {
    private class Node {
        String key;
        Object value;
        Node next;
        
        Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node[] table;
    private int size;
    
    public DataCache(int capacity) {
        table = new Node[capacity];
        size = 0;
    }
    
    private int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }
    
    public void put(String key, Object value) {
        int index = hash(key);
        Node current = table[index];
        
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }
        
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }
    
    public Object get(String key) {
        int index = hash(key);
        Node current = table[index];
        
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    
    public void displayCache() {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Индекс " + i + ": ");
            Node current = table[i];
            while (current != null) {
                System.out.print("[" + current.key + "=" + current.value + "] ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

// Использование
public class CacheExample {
    public static void main(String[] args) {
        DataCache cache = new DataCache(5);
        cache.put("user1", "Анна");
        cache.put("user2", "Борис");
        cache.put("config", 42);
        System.out.println("user1: " + cache.get("user1"));
        cache.displayCache();
    }
}
