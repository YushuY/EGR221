import java.util.*;

public class main {
    public static void main(String []args){
        Scanner reader = new Scanner(System.in);
        Tree tree = new Tree();
        for(int i = 0; i < 5; i++){
            tree.buildTree(reader.nextInt());
        }
        System.out.println("Min Value:" + tree.minValue());
        System.out.println("Max Value:" + tree.maxValue());
        tree.print();
        System.out.println();
        //tree.increment(1);
        //tree.print();
        tree.replaceWithSum();
        //tree.print();
        //Tree treeCopy = new Tree();
       // tree.copy();
       // treeCopy.print();
    }

}
