import java.util.*;

public class DrawStars {

    public DrawStars(){
    }

    public void print(int size){
        if((2 * size -1) == 1){
            System.out.print("*");
        }
        else {
            for(int i = 0; i < (2 * size -1); i ++){
                System.out.print("*");
            }
            System.out.println();
            print(size - 1);
        }
    }
}
