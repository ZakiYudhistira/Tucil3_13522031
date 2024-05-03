public class Path {
    public String path;
    public Path predecessor;

    Path(String path, Path pred){
        this.path = path;
        this.predecessor = pred;
    }

    public Integer getDistanceFrom(String root){
        int count = 0;
        for(int i = 0 ; i < root.length() ; i++){
            if(path.charAt(i) != root.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
