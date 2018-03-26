import java.util.*;

public class Tree {
    private Node root;
    private static Tree buildTree (Map<Character, Integer> map, List<Node> leaves){
        Character [] keys = map.keySet().toArray(new Character[0]);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (Character character : keys) {
            Node node = new Node();
            node.chars = character.toString();
            node.frequence = map.get(character);
            priorityQueue.add(node);
            leaves.add(node);
        }

        for(int i = 0; i < priorityQueue.size()-1; i++){
            Node node1 = priorityQueue.poll();
            Node node2 = priorityQueue.poll();

            Node sumNode = new Node();
            sumNode.chars = node1.chars + node2.chars;
            sumNode.frequence = node1.frequence +node2.frequence;

            sumNode.leftNode = node1;
            sumNode.rightNode = node2;
            node1.parent = sumNode;
            node2.parent = sumNode;
            priorityQueue.add(sumNode);
        }

        Tree tree = new Tree();
        tree.root = priorityQueue.poll();
        return tree;
    }

    public Map<Character, String> buildEncoding(List<Node> leaf) {
        Map<Character, String> code = new HashMap<Character, String>();
        for(Node newLeaf : leaf){
            Character character = new Character(newLeaf.getChars().charAt(0));
            String newCode = " ";
            Node currentNode = newLeaf;
            while(currentNode.parent != null){
                if(currentNode.isLeftChild()){
                    newCode = "0" + newCode;
                } else{
                    newCode = "1" + newCode;
                }
                currentNode = currentNode.parent;
            }
            code.put(character, newCode);
        }
        return code;
    }

    public String encode(String str, Map<Character, Integer> map) {
        if(str == null){
            return " ";
        }
        char[] charArray = str.toCharArray();
        List<Node> leaf = new ArrayList<Node>();
        buildTree(map, leaf);
        Map<Character, String> encodInfo = buildEncoding(leaf);
        StringBuffer buffer = new StringBuffer();
        for(char c : charArray) {
            Character character = new Character(c);
            buffer.append(encodInfo.get(character));
        }
        return buffer.toString();
    }

    public String decode (String binaryStr, Map<Character, Integer> map){
        if(binaryStr == null){
            return " ";
        }

        char[] binaryCharArray = binaryStr.toCharArray();
        LinkedList<Character> binaryList = new LinkedList<Character>();
        for(int i = 0; i < binaryCharArray.length; i++){
            binaryList.addLast(new Character(binaryCharArray[i]));
        }

        List<Node> leaf = new ArrayList<Node>();
        Tree tree = buildTree(map, leaf);

        StringBuffer buffer = new StringBuffer();
        while(binaryList.size() > 0){
            Node node = tree.root;
            while(!node.isLeaf()){

                Character c = binaryList.removeFirst();
                if(c.charValue() == '0') {
                    node = node.leftNode;
                } else {
                    node = node.rightNode;
                }
            }
            buffer.append(node.chars);
        }
        return buffer.toString();
    }
}
