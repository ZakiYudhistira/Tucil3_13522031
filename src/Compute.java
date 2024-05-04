import java.util.ArrayList;
import java.util.Map;

public interface Compute {
    // Compute interface for implementing the algorithm
    ArrayList<String> compute(String startString, String endString, Map<String, Boolean> dictionary) throws Exception;
}

class NoPossiblePath extends Exception {
    // No possible path exception
    NoPossiblePath(){
        super("Target String unreachable");
    }
}