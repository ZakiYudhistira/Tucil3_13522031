package Algorithm;
import java.util.Map;
import DataStructs.ArrayRet;

public interface Compute {
    // Compute interface for implementing the algorithm
    ArrayRet compute(String startString, String endString, Map<String, Boolean> dictionary) throws Exception;
    void printStatus();
}

class NoPossiblePath extends Exception {
    // No possible path exception
    NoPossiblePath(){
        super("Target String unreachable");
    }
}