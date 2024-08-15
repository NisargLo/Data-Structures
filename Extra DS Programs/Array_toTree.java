// Convert an array to a strict binary tree.

public class Array_toTree {
    public static void main(String[] args) {

    }
}

class Int_Tree_Node{
    int info;
    Int_Tree_Node left;
    Int_Tree_Node right;

    public Int_Tree_Node(int data) {
        this.info = data;
        this.left = null;
        this.right = null;
    }
}

class Strict_Binary_Tree{
    Int_Tree_Node root=null;

    protected Int_Tree_Node insert(int index, int[] a){
        if(index>=a.length){
            return null;
        }
        Int_Tree_Node newNode=new Int_Tree_Node(a[index]);
        newNode.left=insert(2*index+1, a);
        newNode.right=insert(2*index+2, a);
        return newNode;
    }

    
}