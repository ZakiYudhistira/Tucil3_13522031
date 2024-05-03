import java.util.ArrayList;
import java.util.Map;

public interface Compute {
    ArrayList<String> compute(String startString, String endString, Map<String, Boolean> dictionary) throws Exception;
}

class NoPossiblePath extends Exception {
    NoPossiblePath(){
        super("Target String unreachable");
    }
}