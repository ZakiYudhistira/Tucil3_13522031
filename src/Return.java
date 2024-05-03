import java.util.ArrayList;

public class Return {
    public ArrayList<String> path;
    public long exec_time;

    Return(ArrayList<String> res, long time){
        path = new ArrayList<>(res);
        exec_time = time;
    }

    public String[] getPath(){return path;}
    public long getExecTime(){return exec_time;}

}