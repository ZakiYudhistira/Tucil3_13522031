import java.util.*;

public class GreedyBfs extends NodeProcessing implements Compute {
    public ArrayList<String> compute(String first_word, String second_word, Map<String, Boolean> dictionary) throws Exception {
        Path first_path = new Path(first_word, null);

        ArrayList<Path> res = new ArrayList<>();

        ArrayList<String> ret = handleGreedyBFS(first_word, first_path, second_word, dictionary, res);

        return ret;
    }

    public ArrayList<String> handleGreedyBFS(String start_word, Path path_to_be_processed, String goal_path, Map<String, Boolean> dictionary, ArrayList<Path> result) throws Exception{
        ArrayList<Path> next_nodes = getAdjacentNode(path_to_be_processed, dictionary);

        if(next_nodes.isEmpty()){
            throw new NoPossiblePath();
        }
        
        Path next_node = nextNode(goal_path, next_nodes);

        result.add(path_to_be_processed);

        if(next_node.path.equals(goal_path)){
            result.add(next_node);
            ArrayList<String> ret = new ArrayList<>();
            for(Path node : result){
                ret.add(node.path);
            }
            return ret;
        }

        return handleGreedyBFS(start_word, next_node, goal_path, dictionary, result);
    }

    public Path nextNode(String target, ArrayList<Path> node_list){
        Path shortest = node_list.get(0);
        
        for(Path node : node_list){
            if(node.getDistanceFrom(target) < shortest.getDistanceFrom(target)){
                shortest = node;
            }
        }

        return shortest;
    }
}
