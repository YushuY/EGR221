import java.util.*;

public class Main {
    public static void main(String arg[]){
        Tree tree = new Tree();
        Map<Character, Integer> map = new TreeMap<>();
        String str="ABCDEF";
        System.out.print(tree.encode(str, map));
        //tree.decode(str, map)

    }
}
