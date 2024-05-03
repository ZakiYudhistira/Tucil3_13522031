import java.util.ArrayList;
import java.util.Map;

public class NodeProcessing {
    protected ArrayList<Path> getAdjacentNode(Path path, Map<String, Boolean> dictionary){
        ArrayList<Path> ret = new ArrayList<>();
        for(Map.Entry<String, Boolean> key : dictionary.entrySet()){
            if(!key.getValue()){
                if(path.getDistanceFrom(key.getKey()) == 1){
                    key.setValue(true);
                    ret.add(new Path(key.getKey(), path));
                }
            }
        }
        return ret;
    }

    protected ArrayList<String> reverseArrayList(ArrayList<String> alist)
    {
        ArrayList<String> revArrayList = new ArrayList<String>();
        for (int i = alist.size() - 1; i >= 0; i--) {

            revArrayList.add(alist.get(i));
        }

        return revArrayList;
    }
    
    protected ArrayList<String> getPath(String target, Path start){
        ArrayList<String> ret = new ArrayList<>();
        
        while(true){
            if(start.predecessor.path.equals(target)){
                ret.add(start.path);
                break;
            } else {
                ret.add(start.path);
                start = start.predecessor;
            }
        }
        ret = reverseArrayList(ret);
        ret.add(0, target);
        return ret;
    }
}
