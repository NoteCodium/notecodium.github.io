package concurrencyrefractored.NEW.BatchProcess.custom;

public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(5);
        threadPool.submitTask(new Task("Task1", 2, 1));
        threadPool.submitTask(new Task("Task2", 5, 2));
        threadPool.submitTask(new Task("Task3", 1, 3));
        threadPool.submitTask(new Task("Task4", 3, 4));
        threadPool.submitTask(new Task("Task5", 4, 5));
    }
}
