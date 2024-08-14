package etc.DataStructure.Tree.BinarySearchTree;

/**
 * 탐색, 삽입, 삭제 - 모두 재귀함수 기반
 */
public class BinarySearchTreeExample {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        public Node search(int key) {
            return search(root, key);
        }

        public Node search(Node node, int key) {
            if (node == null || node.data == key) return node;
            else if (node.data > key) {
                return search(node.left, key);
            } else {
                return search(node.right, key);
            }
        }

        public void insert(int key) {
            root = insert(root, key);
        }

        private Node insert(Node node, int key) {
            if (node == null) {
                return new Node(key);
            }

            if (node.data > key) {
                node.left = insert(node.left, key);
            } else if (node.data < key) {
                node.right = insert(node.right, key);
            }

            return node;
        }

        public void delete(int key) {
            root = delete(root, key);
        }

        private Node delete(Node node, int key) {
            if (node == null) {
                return null;
            }

            if (node.data > key) {
                node.left = delete(node.left, key);
            } else if (node.data < key) {
                node.right = delete(node.right, key);
            } else {
                if (node.left == null) return node.right;
                else if (node.right == null) return node.left;
                else { // 왼쪽 서브 트리의 최댓값에 승계

                    node.data = getSuccessor(node.left); // 후계자 노드의 key값 가져오기
                    node.left = delete(node.left, node.data); // 옮기기 전의 후계자 노드 제거(재귀)
                }
            }

            return node;
        }

        public int getSuccessor(Node node) {
            Node parent = node;
            Node child = node.right;

            while (child != null) {
                parent = child;
                child = node.right;
            }

            return parent.data;
        }

        public void traversal() {
            traversal(root);
            System.out.println();
        }

        private void traversal(Node node) {
            if (node != null) {
                traversal(node.left);
                System.out.print(node.data + " ");
                traversal(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.traversal();
        tree.delete(5);
        tree.traversal();
    }
}
