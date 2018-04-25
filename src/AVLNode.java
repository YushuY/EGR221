import java.util.*;

public class AVLNode <T extends Comparable> {
    public AVLNode left;
    public AVLNode right;
    public T data;
    public int height;

    public AVLNode (T data) {
        this(null, null, data);
    }

    public AVLNode(AVLNode left, AVLNode right, T data) {
        this(left, right, data, 0);
    }

    public AVLNode (AVLNode left, AVLNode right, T data, int height){
        this.left = left;
        this.right = right;
        this.data = data;
        this.height = height;
    }

    private int height(AVLNode node){
        return node == null? -1:node.height;
    }

    private AVLNode singleRotateLeft(AVLNode x){
        AVLNode w = x.left;
        x.left = w.right ;
        w.right = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        w.height = Math.max(height(w.left), x.height) + 1;
        return w;
    }

    private AVLNode singleRotateRight (AVLNode x){
        AVLNode w = x.right;
        x.right = w.left;
        w.left = x;
        x.height = Math.max(height(x.right), height(x.left)) + 1;
        w.height = Math.max(height(w.left), x.height) + 1;
        return w;
    }

    private AVLNode doubleRotateWithLeft (AVLNode x){
        x.left = singleRotateRight(x.left);
        return singleRotateLeft(x);
    }

    private AVLNode doubleRotateWithRight (AVLNode x){
        x.right = singleRotateLeft(x.right);
        return singleRotateRight(x);
    }

    private AVLNode insert (T data, AVLNode x) {
        if(x == null){
            x = new AVLNode(data);
        } else if(data.compareTo(x.data) < 0){
            x.left = insert(data, x.left);

            if(height(x.left) - height(x.right) == 2){

                if(data.compareTo(x.left.data) < 0){
                    x = singleRotateLeft(x);
                } else {
                    x = doubleRotateWithLeft(x);
                }
            }
        } else if(data.compareTo(x.data) > 0) {
            x.right = insert(data, x.right);

            if(height(x.right) - height(x.left) == 2) {
                if(data.compareTo(x.right.data) < 0) {
                    x = doubleRotateWithRight(x);
                } else {
                    x = singleRotateRight(x);
                }
            }
        }
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
}
