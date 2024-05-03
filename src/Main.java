import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args){
        long start_memory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        Scanner io_scan = new Scanner(System.in);

        System.out.print("Enter your starting word : ");
        String first_word = io_scan.nextLine().toUpperCase();

        String dict_dir = "src/Dictionary/words.txt";
        
        Loader load = new Loader();

        Map<String, Boolean> main_dict = new HashMap<>();

        UCS algorithm = new UCS();

        try {
            main_dict = load.loadDictionary(first_word.length(), dict_dir);
        } catch(FileNotFoundException e){
            System.out.println("No dictionary is found, please provide a dictionary in the 'Dictionary' folder!");
            System.out.println("Exiting program...");
            System.exit(0);
        }

        while(true){
            if(main_dict.containsKey(first_word.toUpperCase())){
                break;
            } else {
                System.out.print("Word is not recognized, please provide a valid word : ");
                first_word = io_scan.nextLine().toUpperCase();
                
                try{
                    main_dict = load.loadDictionary(first_word.length(), dict_dir);
                } catch(FileNotFoundException e){}
            }
        }

        System.out.print("Enter your target word : ");
        String second_word = io_scan.nextLine().toUpperCase();

        while(true){
            if(main_dict.containsKey(second_word)){
                break;
            } else {
                if(second_word.length() != first_word.length()){
                    System.out.print("Word length are not equal, ");
                } else if (!main_dict.containsKey(second_word)){
                    System.out.print("Word not recognized, ");
                }
                System.out.print("please provide a valid word : ");
                second_word = io_scan.nextLine().toUpperCase();
            }
        }

        main_dict.put(first_word.toUpperCase(), true);

        long start = System.currentTimeMillis();

        try {
            ArrayList<String> res = algorithm.compute(first_word.toUpperCase(), second_word.toUpperCase(), main_dict);
            System.out.println(res);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        // Path first = new Path(first_word.toUpperCase(), null);
        // ArrayList<Path> temp = new  ArrayList<>(algorithm.getAdjacentNode(first, main_dict));
        long runtime = System.currentTimeMillis() - start;

        System.out.println(runtime);

        long end_memory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long actualMemUsed=end_memory-start_memory;

        System.out.println(actualMemUsed);
        io_scan.close();
    }
}