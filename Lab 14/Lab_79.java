//Write a program to check whether the given two trees are same or not.

public class Lab_79 {
    public static void main(String[] args) {

    }

    private static boolean isEqual(Int_Tree_Node node1, Int_Tree_Node node2){
        if (node1==null || node2==null) {
            return node1==node2;
        }
        if(node1.info!=node2.info){
            return false;
        }
        return isEqual(node1.left,node2.left) && isEqual(node1.right,node2.right);
    }
}
