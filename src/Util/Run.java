package Util;
import DataStructs.*;
import java.util.*;

import Algorithm.*;

public class Run {
    Map<String, Boolean> main_dict;
    public String first;
    public String second;
 
    public Run(final Map<String, Boolean> dict, String first_word, String second_word){
        int word_length = first_word.length();
        main_dict = new HashMap<String, Boolean>();
        for(Map.Entry<String, Boolean> key : dict.entrySet()){ // Add a visited node
            if(key.getKey().length() == word_length){
                main_dict.put(key.getKey(), false);
            }
        }

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