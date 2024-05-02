import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner io_scan = new Scanner(System.in);

        System.out.print("Enter your starting word : ");
        String first_word = io_scan.nextLine().toUpperCase();

        String dict_dir = "src/Dictionary/source.txt";
        
        Loader load = new Loader();

        Map<String, Boolean> main_dict = new HashMap<>();

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

        // for(Map.Entry<String, Boolean> entry : main_dict.entrySet()){
        //     System.out.println(entry);
        // }
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

        io_scan.close();
    }
}