
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.json.JSONObject;

public class Task {

    private int id;
    private String desc;
    private String status;
    private String createdAt;
    private String updatedAt;

    public Task(int id, String description) {
        this.id = id;
        this.desc = description;
        this.status = "todo";
        String now = getCurrentTimestamp();
        this.createdAt = now;
        this.updatedAt = now;
    }

    private String getCurrentTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    // Getter Methods
    public int getId() {
        return id;
    }

    public String getdesc() {
        return desc;
    }

    public String getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    // Setter Methods
    public void setdesc(String Desc) {
        this.desc = Desc;
        updateTimeStamp();
    }

    public void setStatus(String status) {
        this.status = status;
        updateTimeStamp();
    }

    // Internal: Updates Timestamps when the setter methods calls
    private void updateTimeStamp() {
        this.updatedAt = getCurrentTimestamp();
    }

    //Convert the tasks to the String of JSON-format
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("description", desc);
        obj.put("status", status);
        obj.put("createdAt", createdAt);
        obj.put("updatedAt", updatedAt);

        return obj.toString();
    }

    public static Task fromJSONString(String jsonString) {
        try {
            JSONObject obj = new JSONObject(jsonString);

            int id = obj.getInt("id");
            String description = obj.getString("description");
            String status = obj.getString("status");
            String createdAt = obj.getString("createdAt");
            String updatedAt = obj.getString("updatedAt");

            Task task = new Task(id, description);
            task.status = status;
            task.createdAt = createdAt;
            task.updatedAt = updatedAt;

            return task;
        } catch (Exception e) {
            System.out.println("Failed to parse task JSON: " + e.getMessage());
            return null;
        }
    }
}
