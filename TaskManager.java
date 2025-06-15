
import java.util.List;

public class TaskManager {

    private List<Task> tasks;

    public TaskManager() {
        TaskStorage.initializeStorage();
        this.tasks = TaskStorage.loadTasks();
    }

    public void addTask(String description) {
        int newId = generateNextId();
        Task task = new Task(newId, description);
        tasks.add(task);
        TaskStorage.saveTasks(tasks);
        System.out.println("Task added successfully (ID: " + newId + ")");
    }

    private int generateNextId() {
        int maxId = 0;
        for (Task task : tasks) {
            if (task.getId() > maxId) {
                maxId = task.getId();
            }
        }
        return maxId + 1;
    }

    public void listAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
            return;
        }

        for (Task task : tasks) {
            printTask(task);
        }
    }

    private void printTask(Task task) {
        System.out.println("ID: " + task.getId());
        System.out.println("Description: " + task.getdesc());
        System.out.println("Status: " + task.getStatus());
        System.out.println("Created At: " + task.getCreatedAt());
        System.out.println("Updated At: " + task.getUpdatedAt());
        System.out.println("--------------");
    }

    public void updateTask(int id, String newDesc) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setdesc(newDesc);
                TaskStorage.saveTasks(tasks);
                System.out.println("Task updated succesfully.");
                return;
            }
        }
        System.out.println("Task with ID: " + id + " not found.");
    }

    public void deleteTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) {
                tasks.remove(i);
                TaskStorage.saveTasks(tasks);
                System.out.println("Task deleted successfully");
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    public void markInProgress(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus("in-Progress");
                TaskStorage.saveTasks(tasks);
                System.out.println("Task marked as in-progress.");
                return;
            }
        }

        System.out.println("Task with ID " + id + " not found.");
    }

    public void markDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus("done");
                TaskStorage.saveTasks(tasks);
                System.out.println("Task marked as done.");
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    public void listByStatus(String Status) {
        boolean found = false;

        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase(Status)) {
                printTask(task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tasks with Status: " + Status.toLowerCase());
        }
    }
}
