package Util;
import DataStructs.*;
import java.util.*;


import Algorithm.*;

public class Run {
    Map<String, Boolean> main_dict;
    public String first;
    public String second;
    // public long start_mem;
    // Main program
    // public static void main(String[] args){
    //     long start_memory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    //     Scanner io_scan = new Scanner(System.in);

    //     System.out.print("Enter your starting word : ");
    //     String first_word = io_scan.nextLine().toUpperCase();

    //     String dict_dir = "src/Dictionary/words.txt";

    //     Map<String, Boolean> main_dict = new HashMap<>();

    //     AStar algorithm = new AStar();

    //     try {
    //         main_dict = Loader.loadDictionary(dict_dir);
    //     } catch(FileNotFoundException e){
    //         System.out.println("No dictionary is found, please provide a dictionary in the 'Dictionary' folder!");
    //         System.out.println("Exiting program...");
    //         System.exit(0);
    //     }

    //     while(true){
    //         if(main_dict.containsKey(first_word.toUpperCase())){
    //             break;
    //         } else {
    //             System.out.print("Word is not recognized, please provide a valid word : ");
    //             first_word = io_scan.nextLine().toUpperCase();
                
    //             try{
    //                 main_dict = Loader.loadDictionary(dict_dir);
    //             } catch(FileNotFoundException e){}
    //         }
    //     }

    //     System.out.print("Enter your target word : ");
    //     String second_word = io_scan.nextLine().toUpperCase();

    //     while(true){
    //         if(main_dict.containsKey(second_word)){
    //             break;
    //         } else {
    //             if(second_word.length() != first_word.length()){
    //                 System.out.print("Word length are not equal, ");
    //             } else if (!main_dict.containsKey(second_word)){
    //                 System.out.print("Word not recognized, ");
    //             }
    //             System.out.print("please provide a valid word : ");
    //             second_word = io_scan.nextLine().toUpperCase();
    //         }
    //     }

    //     main_dict.put(first_word.toUpperCase(), true);
    //     algorithm.printStatus();

    //     long start = System.currentTimeMillis();

    //     try {
    //         ArrayList<String> res = algorithm.compute(first_word.toUpperCase(), second_word.toUpperCase(), main_dict);
    //         System.out.println(res);
    //     } catch (Exception e){
    //         System.out.println(e.getMessage());
    //     }
    //     long runtime = System.currentTimeMillis() - start;

    //     System.out.println(runtime);

    //     long end_memory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
    //     long actualMemUsed=end_memory-start_memory;

    //     System.out.println(actualMemUsed);
    //     io_scan.close();
    // }
    public Run(final Map<String, Boolean> dict, String first_word, String second_word){
        int word_length = first_word.length();
        // start_mem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        main_dict = new HashMap<String, Boolean>();
        for(Map.Entry<String, Boolean> key : dict.entrySet()){ // Add a visited node
            if(key.getKey().length() == word_length){
                main_dict.put(key.getKey(), false);
            }
        }
        // main_dict = dict;
        first = first_word;
        second = second_word;
    }

    public Return runBFS() throws Exception{
        long start_mem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long start = System.currentTimeMillis();
        GreedyBfs b = new GreedyBfs();
        ArrayRet res = b.compute(first, second, main_dict);
        long end_memory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long runtime = System.currentTimeMillis() - start;
        return new Return(res, runtime, end_memory - start_mem);
    }

    public Return runAStar() throws Exception{
        long start_mem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long start = System.currentTimeMillis();
        AStar b = new AStar();
        ArrayRet res = b.compute(first, second, main_dict);
        long end_memory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long runtime = System.currentTimeMillis() - start;
        return new Return(res, runtime, end_memory - start_mem);
    }

    public Return runUCS() throws Exception{
        long start_mem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long start = System.currentTimeMillis();
        UCS b = new UCS();
        ArrayRet res = b.compute(first, second, main_dict);
        long end_memory = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long runtime = System.currentTimeMillis() - start;
        return new Return(res, runtime, end_memory - start_mem);
    }
}