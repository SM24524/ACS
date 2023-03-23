import java.util.NoSuchElementException;

public class Tree {
    private Node root;

    public Tree(){
        root = null;
    }

    public void printSideways(){
        printSideways(root, "");
    }

    private void printSideways(Node root, String indent){
        //prints a sideways visualization of the entire tree with the root on the left
        if(root != null){
            printSideways(root.rightChild, indent + "    ");
            System.out.println(indent + root.data);
            printSideways(root.leftChild, indent + "    ");
        }
    }

    public String toString(){
        String result = toString(root, "[");
        return result.substring(0, result.length() - 2) + "]";
    }

    private String toString(Node root, String str){
        if(root != null){
            str = toString(root.leftChild, str);
            str = str + root.data + ", ";
            str = toString(root.rightChild, str);
        }
        return str;
    }

    public int getMin(){
        if(root == null) {
            throw new NoSuchElementException();
        }
        return getMin(root);
    }

    private int getMin(Node root){
        if(root.leftChild == null){
            return root.data;
        }else{
            return getMin(root.leftChild);
        }
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null){
            return 0;
        }else{
            return 1 + Math.max(height(root.leftChild), height(root.rightChild));
        }
    }

    private int balanceFactor(Node root){
        //calculates the balance factor for a given subtree (node)

        //TODO
        if (root == null){
            return 0;
        }
        return height(root.leftChild) - height(root.rightChild);

    }

    private Node leftRotate(Node a){
        //preforms a left rotation about the rightChild of the supplied node and returns the new root node with adjusted references

        //TODO
        Node b = a.rightChild;
        a.rightChild = b.leftChild;
        b.leftChild = a;
        return b;
    }

    private Node rightRotate(Node c){
        //preforms a right rotation about the leftChild of the supplied node and returns the new root node with adjusted references

        // TODO
        Node b = c.leftChild;
        c.leftChild = b.rightChild;
        b.rightChild = c;
        return b;
    }

    private Node balanceAdd(Node root, int value){
        //identifies which balance scenario the supplied node is in after the addition of the supplied value to the tree
        //returns root

        //TODO
        int balanceFactor = balanceFactor(root);
        if(balanceFactor > 1 && value < root.leftChild.data){
            return rightRotate(root);
        }
        if(balanceFactor < -1 && value > root.rightChild.data){
            return rightRotate(root);
        }
        if(balanceFactor > 1 && value < root.leftChild.data){
            root.leftChild = leftRotate(root.leftChild);
            return rightRotate(root);
        }
        if(balanceFactor < -1 && value < root.rightChild.data){
            root.rightChild = leftRotate(root.rightChild);
            return leftRotate(root);
        }
        return root;
    }

    public void add(int value){
        root = add(value, root);
    }

    private Node add(int value, Node root){
        if(root == null){
            root = new Node(value);
        }else if(value < root.data){
            root.leftChild = add(value, root.leftChild);
        }else if(value > root.data){
            root.rightChild = add(value, root.rightChild);
        }

        root = balanceAdd(root, value); //TODO: IMPLEMENT AVL PROPERTIES (BALANCE METHOD)

        return root;
    }

    public void remove(int value){
        root = remove(root, value);
    }

    private Node remove(Node root, int value){
        if(root == null){
            return null;
        }else if(root.data > value){
            root.leftChild = remove(root.leftChild, value);
        }else if(root.data < value){
            root.rightChild = remove(root.rightChild, value);
        }else{
            if(root.rightChild == null){
                return root.leftChild;
            }else if(root.leftChild == null){
                return root.rightChild;
            }else{
                root.data = getMin(root.rightChild);
                root.rightChild = remove(root.rightChild, root.data);
            }
        }
        return root;
    }

    private class Node {
        public int data;
        public Node leftChild, rightChild;

        public Node(int data){
            this.data = data;
            leftChild = null;
            rightChild = null;
        }

        public Node(int data, Node leftChild, Node rightChild){
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
    public static void main(String [] args){
        Tree test = new Tree();
        test.add(5);
        test.add(3);
        test.add(7);
        test.add(2);
        test.add(4);
        test.add(6);
        test.add(8);


        test.printSideways();


        test.remove(5);
        test.printSideways();
    }
}