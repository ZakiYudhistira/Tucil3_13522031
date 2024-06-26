package Util;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Loader {
    // Dictionary loading functions
    public static Map<String, Boolean> loadDictionary(String dict_path) throws FileNotFoundException{
        Map<String, Boolean> map = new HashMap<>();
            File file = new File(dict_path);
    
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String data = scan.nextLine().toUpperCase();
                    map.put(data, false);
            }

            scan.close();

        return map;
    }
}
