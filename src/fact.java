import java.util.*;

public class fact{

    public int fact(int n){
        if (n <= 1){
            return n;
        } else{
            return fact(n-1)+fact(n-2);
        }
    }

}