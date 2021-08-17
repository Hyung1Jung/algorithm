package bank_salad;

import java.util.Scanner;

public class Problem135 {

    public Node root;
    private static int min = Integer.MAX_VALUE;

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

    public void createNode(int data, int leftData, int rightData) {
        if (root == null) {
            root = new Node(data);

            if (leftData != 0) {
                root.left = new Node(leftData);
            }

            if (rightData != 0) {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public void searchNode(Node node, int data, int leftData, int rightData) {
        if (node == null) {
            return;
        } else if (node.data == data) {

            if (leftData != 0) {
                node.left = new Node(leftData);
            }

            if (rightData != 0) {
                node.right = new Node(rightData);
            }
        } else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Problem135 t = new Problem135();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            t.createNode(a, b, c);
        }

        t.solution(t.root, t.root.data);
        System.out.println(min);
    }

    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
}

