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
}