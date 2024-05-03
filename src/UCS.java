import java.util.*;

public class UCS extends NodeProcessing implements Compute {
    public ArrayList<String> compute(String first_word, String second_word, Map<String, Boolean> dictionary) throws Exception{
        
        Path first = new Path(first_word, null); 
        
        ArrayList<Path> queue = new ArrayList<>();
        queue.addAll(getAdjacentNode(first, dictionary));

        while(!queue.isEmpty()){
            Path process = queue.get(0);
            if(process.path.equals(second_word)){
                return getPath(first_word, process);
            } else {
                queue.remove(0);
                queue.addAll(getAdjacentNode(process, dictionary));
            }
        }

        throw new NoPossiblePath();
    }
}
