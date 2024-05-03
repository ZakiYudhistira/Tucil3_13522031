import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Loader {
    public Map<String, Boolean> loadDictionary(Integer string_length, String dict_path) throws FileNotFoundException{
        Map<String, Boolean> map = new HashMap<>();
            File file = new File(dict_path);
    
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                String data = scan.nextLine().toUpperCase();

                if(data.length() == string_length){
                    map.put(data, false);
                }
            }

            scan.close();

        return map;
    }
}
