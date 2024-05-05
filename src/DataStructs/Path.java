package DataStructs;
public class Path implements Comparable<Path>{
    // Linked list implementation for path result
    public String path;
    public Path predecessor;

    public Path(String path, Path pred){
        this.path = path;
        this.predecessor = pred;
    }

    public Integer getDistanceFrom(String root){
    // Retrieve distance between string
        int count = 0;
        for(int i = 0 ; i < root.length() ; i++){
            if(path.charAt(i) != root.charAt(i)){
                count++;
            }
        }
        return count;
    }

    public int compareTo(Path other) {
        return path.compareTo(other.path);
    }
}
