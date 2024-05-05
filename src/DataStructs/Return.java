package DataStructs;
import java.util.ArrayList;

public class Return {
    // Return class, to be displayed to the user
    public ArrayList<String> path;
    public long exec_time;
    public long mem_usage;
    public long words_processed;

    public Return(ArrayRet res, long time, long usage){
        path = res.array;
        exec_time = time;
        mem_usage = usage;
        words_processed = res.count;
    }

    public ArrayList<String> getPath(){return path;}
    public long getExecTime(){return exec_time;}

}