import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class TaskStorage{
    public static final String FILE_NAME = "tasks.json";

    public static void initializeStorage(){
        File file = new File(FILE_NAME);
        if(!file.exists()){
            try{
                Files.write(Paths.get(FILE_NAME), "[]".getBytes());
                System.out.println("Storage file created: " + FILE_NAME);
            }
            catch(IOException e){
                System.out.println("Failed to create Storage file: " + e.getMessage());
            }
        }
    }

    public static List<Task> loadTasks(){
        List<Task> tasks = new ArrayList<>();

        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_NAME)));
            JSONArray array = new JSONArray(content);

            for(int i = 0; i < array.length(); i++){
                JSONObject obj = array.getJSONObject(i);
                Task task = Task.fromJSONString(obj.toString());
                if(task != null){
                    tasks.add(task);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading tasks: " + e.getMessage());

        }
        return tasks;
    }

    public static void saveTasks(List<Task> tasks){
        JSONArray array = new JSONArray();

        for (Task task : tasks){
            JSONObject obj = new JSONObject(task.toJSONString());
            array.put(obj);
        }

        try{
            Files.write(Paths.get(FILE_NAME), array.toString(4).getBytes());
        }
        catch (IOException e){
            System.out.println("Error saving tasks: "+ e.getMessage());
        }
    }

    
}