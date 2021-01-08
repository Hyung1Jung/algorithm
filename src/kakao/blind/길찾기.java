package src.kakao.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 길찾기 {

    class Node {

        Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }

        int value;

        int x;

        int y;

        Node left;

        Node right;
    }

    int index;

    Comparator<Node> Comp = new Comparator<Node>() {
        @Override
        public int compare(Node a, Node b) {

            if (a.y == b.y) {
                return a.x - b.x;
            }

            return b.y - a.y;
        }
    };

    List<Node> nodeList = new ArrayList<>();

    void addNode(Node parent, Node child) {

        if (child.x < parent.x) {

            if (parent.left == null) {
                parent.left = child;
            } else {
                addNode(parent.left, child);
            }

        } else {

            if (parent.right == null) {
                parent.right = child;
            } else {
                addNode(parent.right, child);
            }

        }
    }

    void preorder(int[][] answer, Node node) {

        if (node == null) {
            return;
        }

        answer[0][index++] = node.value;

        if (node.left != null) {
            preorder(answer, node.left);
        }

        if (node.right != null) {
            preorder(answer, node.right);
        }
    }

    void postorder(int[][] answer, Node node) {

        if (node == null) {
            return;
        }

        if (node.left != null) {
            postorder(answer, node.left);
        }

        if (node.right != null) {
            postorder(answer, node.right);
        }

        answer[1][index++] = node.value;
    }

    public int[][] solution(int[][] nodeinfo) {
        int size = nodeinfo.length;

        for (int i = 0; i < size; ++i) {
            nodeList.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        nodeList.sort(Comp);
        Node root = nodeList.get(0);

        for (int i = 1; i < size; ++i) {
            addNode(root, nodeList.get(i));
        }

        int[][] answer = new int[2][size];

        preorder(answer, root);
        index = 0;
        postorder(answer, root);

        return answer;
    }

    public static void main(String[] args) {
        길찾기 instance = new 길찾기();
        int[][] nodeinfo = new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};

        System.out.println(Arrays.deepToString(instance.solution(nodeinfo)));
    }
}
