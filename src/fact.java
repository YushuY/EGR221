import java.util.*;

public class fact{

    public double fact(int n){
        if (n == 1){
            return n;
        } else{
            return n*fact(n-1);
        }
    }

    public static void main(String args[]){

        fact f= new fact();
        System.out.println(f.fact(1));
        System.out.println(f.fact(4));
        System.out.println(f.fact(7));
        System.out.println(f.fact(22));

    }
}
