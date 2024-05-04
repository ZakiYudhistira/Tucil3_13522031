import java.util.*;
// This is the UCS implementation
public class UCS extends NodeProcessing implements Compute {
    public ArrayList<String> compute(String first_word, String second_word, Map<String, Boolean> dictionary) throws Exception{
        
        Path first = new Path(first_word, null); 
        // Initiates the first path
        UCSQueue queue = new UCSQueue(second_word);
        // Initiates the priority queue based of the distance to target string
        queue.addAll(getAdjacentNode(first, dictionary));
        // First node initiation

        while(!queue.isEmpty()){
        // Node processing algorithm
            Path process = queue.poll();
            if(process.path.equals(second_word)){
                return getPath(first_word, process);
            } else {
                queue.addAll(getAdjacentNode(process, dictionary));
            }
        }

        throw new NoPossiblePath();
        // Throws exception if there are no possible path
    }
}

class UCSQueue extends ArrayList<Path> {
    // Priority queue implementation
    public static String root;
    
    UCSQueue(String begin){
        super();
        root = begin;
    }

    @Override
    public boolean add(Path e) {
        for(int i = 0 ; i < super.size() ; i++){
            if(e.getDistanceFrom(root) < super.get(i).getDistanceFrom(root)){
                super.add(i, e);
                return true;
            }
        }
        return super.add(e);
    }

    public Path poll(){
        Path temp = super.get(0);
        super.remove(0);
        return temp;
    }
}