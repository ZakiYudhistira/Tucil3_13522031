import java.util.*;

public class AStar extends NodeProcessing implements Compute {
    
    public ArrayList<String> compute(String startString, String endString, Map<String, Boolean> dictionary) throws Exception {
        Path first = new Path(startString, null); 
        
        AStarQueue queue = new AStarQueue(startString, endString);
        // Priority queue

        queue.addAll(getAdjacentNode(first, dictionary));
        // First node initiation

        while(!queue.isEmpty()){
        // Node processing algorithm
            Path process = queue.poll();
            if(process.path.equals(endString)){
                return getPath(startString, process);
            } else {
                queue.addAll(getAdjacentNode(process, dictionary));
            }
        }

        throw new NoPossiblePath();
    }
}

class AStarQueue extends ArrayList<Path>{
    public static String root;
    public static String goal;
    
    AStarQueue(String begin, String end){
        // Queue constructor
        super();
        root = begin;
        goal = end;
    }
    
    @Override
    public boolean add(Path e) {
        for(int i = 0 ; i < super.size() ; i++){
            if(sumCost(e, root, goal) < sumCost(super.get(i), root, goal)){
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

    public int sumCost(Path path, String start, String target){
        // Minimum sum-cost path
        return path.getDistanceFrom(start) + path.getDistanceFrom(target);
    }
}