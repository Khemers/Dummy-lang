package fonte;
import java.util.*;

public class Util {
    public static String[] appendArray (int size, String[] Array, String newElement){
        String[] newArray = Arrays.copyOf(Array, size+1);
        newArray[newArray.length-1] = newElement;
        return newArray;
    }
    public static String[] removeArray (int size, String[] Array, int position) {
        String[] newArray = new String[0];
        if(position == size-1){
            size--;
        }
        for(int i = 0; i < size; i++){
            if(i == position){
                i++;
            }
            newArray = appendArray(newArray.length, newArray, Array[i]);
        }
        return newArray;
    }
}


