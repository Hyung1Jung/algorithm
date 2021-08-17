package bank_salad;

public class Problem135_2 {

    private Node newNode;
    private static int min = Integer.MAX_VALUE;

    public Node makeNode(int data, Node leftNode, Node rightNode) {
        newNode = new Node(data);
        newNode.setLeftNode(leftNode);
        newNode.setRightNode(rightNode);

        return newNode;
    }

    public void solution(Node node, int sum) {

        if (node.left == null && node.right == null) {
            min = Math.min(sum, min);
            return;
        }

        if (node.left != null) {
            solution(node.left, sum + node.left.data);
        }

        if (node.right != null) {
            solution(node.right, sum + node.right.data);
        }
    }

    public static void main(String[] args) {
        Problem135_2 tc = new Problem135_2();

        Node n6 = tc.makeNode(-1, null, null);
        Node n5 = tc.makeNode(1, n6, null);
        Node n4 = tc.makeNode(2, null, null);
        Node n3 = tc.makeNode(5, null, n5);
        Node n2 = tc.makeNode(5, null, n4);
        Node n1 = tc.makeNode(10, n2, n3);

        tc.solution(tc.newNode, tc.newNode.data);
        System.out.println(min);
    }

    class Node {
        private int data;    //노드의 값
        private Node left;    //왼쪽 자식노드의 값
        private Node right;    //오른쪽 자식노드의 값

        public Node(int data) {
            this.data = data;
        }

        public void setLeftNode(Node node) {
            this.left = node;
        }

        public void setRightNode(Node node) {
            this.right = node;
        }

        public Node getLeftNode() {
            return this.left;
        }

        public Node getRightNode() {
            return this.right;
        }
    }
}
