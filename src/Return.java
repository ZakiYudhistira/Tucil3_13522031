public class Return {
    private String path[];
    private long exec_time;

    Return(String res[], long time){
        path = res;
        exec_time = time;
    }

    public String[] getPath(){return path;}
    public long getExecTime(){return exec_time;}

}