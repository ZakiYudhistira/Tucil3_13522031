import java.util.*;

public class UCS extends NodeProcessing implements Compute {
    public ArrayList<String> compute(String first_word, String second_word, Map<String, Boolean> dictionary) throws Exception{
        
        Path first = new Path(first_word, null); 
        
        Queue queue = new Queue(second_word);
        queue.addAll(getAdjacentNode(first, dictionary));

        while(!queue.isEmpty()){
            Path process = queue.poll();
            if(process.path.equals(second_word)){
                return getPath(first_word, process);
            } else {
                queue.addAll(getAdjacentNode(process, dictionary));
            }
        }

        throw new NoPossiblePath();
    }
}

class Queue extends ArrayList<Path> {
    public static String root;
    
    Queue(String begin){
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