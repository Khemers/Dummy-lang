package fonte;
import java.util.*;

public class Util {
    public static String[] appendArray (int size, String[] Array, String newElement){
        String[] newArray = Arrays.copyOf(Array, size+1);
        newArray[newArray.length-1] = newElement;
        return newArray;
    }
}


