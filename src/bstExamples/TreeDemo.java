package bstExamples;

/**
 * Node class to initialize a node
 * Left and right children are innitially set to null
 *
 * @param value  value of the node
 */
class Node{
    int value;
    Node left, right;
    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }
}
class BinarySearchTree{
    Node root;

    /**
     * Inserts a value into the Binary Search Tree
     * First value becomes the root
     * @param value The value inserted into tree
     */
    public void insert(int value){
//tree is empty
        if(root == null){
            root = new Node(value);
            return;
        }else{
            Node current = root;
            Node parent = null;
            while(true){
                parent = current;
                if(value < current.value){
                    current = current.left;
                    if(current == null){
                        parent.left = new Node(value);
                        return;
                    }
                }else{
                    current = current.right;
                    if(current == null){
                        parent.right = new Node(value);
                        return;
                    }
                }
            }//closing while
        }//closing main if-else
    }
    /**
     * Method performs pre-order traversal
     * Root → Left → Right
     *
     * @param root The root of the subtree
     */
    public void preOrderTraversal(Node root){
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
    /**
     * Method performes in-order traversal
     * Left → Root → Right
     *
     * @param root The root of the subtree
     */
    public void inOrderTraversal(Node root){
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.value + " ");
            inOrderTraversal(root.right);
        }
    }
    /**
     * Method performs post-order traversal
     * Left → Right → Root.
     *
     * @param root The root of the subtree
     */
    public void postOrderTraversal(Node root){
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value + " ");
        }
    }
    /**
     * Method finds  node with the specified key
     *
     * @param root The root of the subtree
     * @param key The value being searched
     * @return True if the value is found, false if not
     */
    public boolean find(Node root, int key){
        if (root == null) {
            return false;
        }
        if (key == root.value) {
            return true;
        } else if (key < root.value) {
            return find(root.left, key);
        } else {
            return find(root.right, key);
        }
    }
    /**
     * Finds the minimum value
     *
     * @param root The root of the subtree
     * @return The smallest value
     */
    public int getMin(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root.value;
    }
    /**
     * Finds the maximum value
     *
     * @param root The root of the subtree
     * @return The largest value
     */
    public int getMax(Node root){
        while (root.right != null) {
            root = root.right;
        }
        return root.value;
    }

    /**
     * Deletes a specified node, replaces node after deletion
    *
    * @param root The root of the subtree
    * @param key The value to delete
    * @return The new root
    */
    public Node delete(Node root, int key){
        if(root == null){
            return root;
        }else if(key < root.value){
            root.left = delete(root.left, key);
        }else if(key > root.value){
            root.right = delete(root.right, key);
        }else{
//node has been found
            if(root.left==null && root.right==null){
//case #1: leaf node
                root = null;
            }else if(root.right == null){
//case #2 : only left child
                root = root.left;
            }else if(root.left == null){
//case #2 : only right child
                root = root.right;
            }else{
//case #3 : 2 children
                root.value = getMax(root.left);
                root.left = delete(root.left, root.value);
            }
        }
        return root;
    }
}
/**
 * A  demo class to test operations
 * Inserts values into the tree and prints the in-order traversal
 */
public class TreeDemo{
    public static void main(String[] args){
        BinarySearchTree t1 = new BinarySearchTree();
        t1.insert( 24);
        t1.insert(80);
        t1.insert(18);
        t1.insert(9);
        t1.insert(90);
        t1.insert(22);
        System.out.print("in-order : ");
        t1.inOrderTraversal(t1.root);
        System.out.println();
    }
}