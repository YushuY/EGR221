public class Node {
    public String chars= " ";
    public int frequence = 0;
    public Node parent;
    public Node leftNode;
    public Node rightNode;

    public String getChars(){
        return chars;
    }

    public boolean isLeftChild(){
        return parent != null && this == parent.leftNode;
    }

    public boolean isLeaf(){
        return chars.length() == 1;
    }
}
