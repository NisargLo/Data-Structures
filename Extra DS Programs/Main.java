public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        tree.root = tree.insert(arr, 0);

        System.out.println("Tree Structure:");
        tree.printTree(tree.root, "", true);

        System.out.println("\nPre-order Traversal:");
        tree.pre_traverse(tree.root);

        System.out.println("\n\nIn-order Traversal:");
        tree.in_traverse(tree.root);

        System.out.println("\n\nPost-order Traversal:");
        tree.post_traverse(tree.root);
    }
}

class Nodes {
    int data;
    Nodes left;
    Nodes right;

    public Nodes(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Nodes root = null;

    public Nodes insert(int[] arr, int index) {
        if (index >= arr.length) {
            return null;
        }
        Nodes newNode = new Nodes(arr[index]);
        newNode.left = insert(arr, index * 2 + 1);
        newNode.right = insert(arr, index * 2 + 2);
        return newNode;
    }

    public void pre_traverse(Nodes root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + ", ");
        pre_traverse(root.left);
        pre_traverse(root.right);
    }

    public void in_traverse(Nodes root) {
        if (root == null) {
            return;
        }
        in_traverse(root.left);
        System.out.print(root.data + ", ");
        in_traverse(root.right);
    }

    public void post_traverse(Nodes root) {
        if (root == null) {
            return;
        }
        post_traverse(root.left);
        post_traverse(root.right);
        System.out.print(root.data + ", ");
    }

    public void printTree(Nodes node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("└── ");
                indent += "    ";
            } else {
                System.out.print("├── ");
                indent += "|   ";
            }

            System.out.println(node.data);

            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }
}
