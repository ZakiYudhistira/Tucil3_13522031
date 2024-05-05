package Algorithm;
import java.util.*;

import DataStructs.ArrayRet;
import DataStructs.Path;

// Greedy best first search algorithm implementation

public class GreedyBfs extends NodeProcessing implements Compute {
    public ArrayRet compute(String first_word, String second_word, Map<String, Boolean> dictionary) throws Exception {
        // Compute interface implementation
        Path first_path = new Path(first_word, null);

        ArrayList<Path> res = new ArrayList<>();
        
        ArrayRet ret = handleGreedyBFS(first_word, first_path, second_word, dictionary, res, 0);

        return ret;
    }

    public ArrayRet handleGreedyBFS(String start_word, Path path_to_be_processed, String goal_path, Map<String, Boolean> dictionary, ArrayList<Path> result, int count) throws Exception{
        // Recursive greedy bfs function
        ArrayList<Path> next_nodes = getAdjacentNode(path_to_be_processed, dictionary); // Retrieve the next nodes

        if(next_nodes.isEmpty()){
            throw new NoPossiblePath(); // No path is available, throws no possible path erxception
        }
        
        Path next_node = nextNode(goal_path, next_nodes); // Retrieve the next note to visit

        result.add(path_to_be_processed);

        count++;
        if(next_node.path.equals(goal_path)){ // If a match is found, get the result array and return
            result.add(next_node);
            ArrayList<String> ret = new ArrayList<>();
            for(Path node : result){
                ret.add(node.path);
            }
            return new ArrayRet(count, ret);
        }
        return handleGreedyBFS(start_word, next_node, goal_path, dictionary, result, count); // if not, the algorithm continues recursively
    }

    public Path nextNode(String target, ArrayList<Path> node_list){ // Function to decide the next note, or f(n)
        Path shortest = node_list.get(0);
        
        for(Path node : node_list){
            if(node.getDistanceFrom(target) < shortest.getDistanceFrom(target)){ // Calculates the next nearest node to the result
                shortest = node;
            }
        }

        return shortest;
    }

    public void printStatus(){
        System.out.println("Running the Greedy Breadth First Search Algorithm...");
    }
}
