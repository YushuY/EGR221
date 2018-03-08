
public class Tree {
    private Node root;

    public Tree(){
        root = null;
    }
    private void buildTree(Node node, int value){
        if(root == null)
            root = new Node(value);
        else if(value < node.data){
            if(node.left == null)
                node.left = new Node(value);
            else
                buildTree(node.left, value);
        }
        else{
            if(node.right == null)
                node.right = new Node(value);
            else
                buildTree(node.right, value);
        }
    }

    public void buildTree(int value){
        buildTree(root, value);
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        }
        else
            insertRec(root, node);
    }

    private void insertRec(Node lastestRoot, Node node){

        if(lastestRoot.data > node.data){
            if(lastestRoot.left == null)
                lastestRoot.left = node;
            else
                insertRec(lastestRoot.left,node);
        }
        else{
            if(lastestRoot.right == null)
                lastestRoot.right = node;
            else
                insertRec(lastestRoot.right,node);
        }
    }

    private int maxValue(Node lastestRoot){
        if(lastestRoot.right == null)
            return lastestRoot.data;
        return maxValue(lastestRoot.right);

    }

    private int minValue(Node lastestRoot){
        if(lastestRoot.left == null)
            return lastestRoot.data;
        return minValue(lastestRoot.left);
    }
    private void print(Node lastestRoot){
        if(lastestRoot != null){
            System.out.print(lastestRoot.data + " ");
            print(lastestRoot.left);
            print(lastestRoot.right);
        }
    }

    public int maxValue(){
        return maxValue(root);
    }

    public int minValue(){
        return minValue(root);
    }

    public void print(){
        print(root);
    }

    private void search(Node lastestRoot, int value){
        if(lastestRoot == null)
            System.out.println("No such value in this tree");
        else if(lastestRoot.data == value){
           lastestRoot.data++;
        }
        else if(lastestRoot.data > value){
            if(lastestRoot.left == null)
                search(lastestRoot.right,value);
            else{
                search(lastestRoot.left, value);
                lastestRoot.data++;
            }
        }
        else if(lastestRoot.data < value){
            if(lastestRoot.right == null){
                search(lastestRoot.left, value);
            }else{
                search(lastestRoot.right, value);
                lastestRoot.data++;
            }
        }
    }

    public void increment(int value){
        search(root, value);
    }

    private int replaceWithSum(Node lastestRoot){
        if(lastestRoot == null)
            return 0;
        int value;
        value = lastestRoot.data;
        lastestRoot.data = replaceWithSum(lastestRoot.left) + replaceWithSum(lastestRoot.right);
        return lastestRoot.data + value;
    }
    public void replaceWithSum(){
        replaceWithSum(root);
        print();
    }

    private Node copy(Node lastestRoot){
        if(lastestRoot == null)
            return null;
        Node node = new Node(lastestRoot.data);
        node.left = copy(lastestRoot.left);
        node.right = copy(lastestRoot.right);
        return node;
    }

    public void copy(){
        copy(root);
        print();
    }
}
