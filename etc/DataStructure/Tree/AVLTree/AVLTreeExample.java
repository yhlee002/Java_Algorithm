package etc.DataStructure.Tree.AVLTree;

import java.util.*;

/**
 * AVL 트리
 * [정의] 자가 균형 이진 탐색 트리의 일종으로 데이터 삽입, 삭제가 일어날 때마다 BF를 이용해서 균형을 유지하는 트리
 * 균형도(BF,Balance Factor)값으로 [-1, 0, 1]만 허용
 * 상황에 따라 노드를 회전하여 균형을 이룸
 * [구현시 유의점]
 * 노드 삽입, 삭제는 기존의 이진 탐색 트리와 동일
 * 노드 삽입, 삭제 후 BF를 다시 계산해 균형도가 허용치를 벗어날 경우 리밸런싱 메서드 호출(리밸런싱의 기준은 항상 루트의 BF)
 * [리밸런싱]
 * 1) LL: 왼쪽 노드(의 서브트리)에 지우친 경우
 * -> 부모 노드를 기준이 되는 노드(왼쪽 자식 노드)의 오른쪽 자식 노드로 회전시킨 후,
 * 기준 노드의 오른쪽 자식이던 노드를 부모(였던) 노드의 왼쪽 자식 노드로 이동
 * 2) RR: 오른쪽 노드(의 서브트리)에 지우친 경우
 * -> 부모 노드를 기준이 되는 노드(오른쪽 자식 노드)의 왼쪽 자식 노드로 회전시킨 후,
 * 기준 노드의 왼쪽 자식이던 노드를 부모(였던) 노드의 오른쪽 자식 노드로 이동
 * 3) LR: 왼쪽 노드의 오른쪽 하위 트리에 새로운 자식 노드가 삽입되어 균형이 깨진 경우
 * -> 서브 트리를 L회전한 후 상위 트리를 R회전
 * 4) RL: 오른쪽 노드의 왼쪽 하위 트리에 새로운 자식 노드가 삽입되어 균형이 깨진 경우
 * -> 서브 트리를 R회전한 후 상위 트리를 L회전
 */
public class AVLTreeExample {

    static class AVLTree<E> {
        Node<E> root;
        Comparator<E> comparator;

        public AVLTree(Comparator<E> comparator) {
            root = null;
            this.comparator = comparator;
        }

        public Node<E> search(E key) {
            return search(key);
        }

        private Node<E> search(Node<E> node, E key) {
            if (node == null || node.value == key) {
                return node;
            } else if (comparator.compare(node.value, key) > 0) {
                return search(node.left, key);
            } else {
                return  search(node.right, key);
            }
        }

        public void add(E value) {
            root = add(root, value);
        }

        private Node<E> add(Node<E> node, E value) {
            if (node == null) {
                return new Node<>(value);
            }

            int compResult = comparator.compare(node.value, value);
            if (compResult > 0) {
                node.left = add(node.left, value);
            } else {
                node.right = add(node.right, value);
            }

            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            int bf = getBalance(node);

            // 균형도 확인
            // bf에 따라 node.left 또는 node.right는 반드시 있기 때문에 null check 하지 않음
            if (bf > 1 && comparator.compare(node.left.value, value) > 0) { // LL
                return rightRotate(node);
            } else if (bf <- 1 && comparator.compare(node.right.value, value) < 0) { // RR
                return leftRotate(node);
            } else if (bf > 1 &&  comparator.compare(node.left.value, value) < 0) { // LR
                return lrRotate(node);
            } else if(bf < -1 && comparator.compare(node.right.value, value) > 0) { // RL
                return rlRotate(node);
            } else {
                return node;
            }
        }

        public void delete(E value) {
            root = delete(root, value);
        }

        private Node<E> delete(Node<E> node, E value) {
            if (node == null) {
                return null; // 노드가 하나도 없는 경우
            }

            // 노드 탐색
            int compResult = comparator.compare(node.value, value);
            if (compResult > 0) {
                node.left = delete(node.left, value);
            } else if (compResult < 0) {
                node.right = delete(node.right, value);
            } else { // node.value == value
                if (node.left == null) return node.right;
                else if (node.right == null) return node.left;
                else {
                    // 후계자 노드 찾기
                    Node<E> successor = getSuccessor(node);
                    node.value = successor.value; // 여기서는 value라는 변수명을 사용했지만 실제로 이는 노드의 key를 의미한다. key를 변경함으로써 노드를 변경한 것으로 여길 수 있음
                    node.left = delete(node.left, node.value);
                }
            }

            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            int bf = getBalance(node);

            // 균형도 확인
            if (bf > 1 && comparator.compare(node.left.value, value) > 0) { // LL
                return rightRotate(node);
            } else if (bf < -1 && comparator.compare(node.right.value, value) < 0) { // RR
                return leftRotate(node);
            } else if (bf > 1 &&  comparator.compare(node.left.value, value) < 0) { // LR
                return lrRotate(node);
            } else if(bf < -1 && comparator.compare(node.right.value, value) > 0) { // RL
                return rlRotate(node);
            } else {
                return node;
            }
        }

        // 후계자 노드 반환
        private Node<E> getSuccessor(Node<E> node) {
            Node<E> current = node.left; // 왼쪽 서브 트리에서 탐색
            Node<E> parent = null;

            while (current != null) {
                parent = current;
                current = parent.right; // 왼쪽 서브 트리에서 가장 큰 값 탐색
            }

            return parent;
        }

        // 해당 노드의 height 반환
        public int getHeight(Node<E> node) {
            if (node == null) {
                return -1;
            }
            return node.height;
        }

        // 해당 node의 bf 반환
        private int getBalance(Node<E> node) {
            if (node == null) {
                return 0;
            }
            return getHeight(node.left) - getHeight(node.right);
        }

        /**
         * 회전할 노드를 인자로 받아 L 회전
         * (모든 회전 기능의 메서드는 기존 서브 트리의 루트를 인자로 받아 새로이 변한 루트를 반환)
         * @param node
         */
        private Node<E> leftRotate(Node<E> node) {
            Node<E> newParent = node.right;
            Node<E> left = newParent.left;

            newParent.left = node;
            node.right = left;

            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            newParent.height = Math.max(getHeight(newParent.left), getHeight(newParent.right)) + 1;

            return newParent;
        }

        private Node<E> rightRotate(Node<E> node) {
            Node<E> newParent = node.left;
            Node<E> right = newParent.right;

            newParent.right = node;
            node.left = right;

            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            newParent.height = Math.max(getHeight(newParent.left), getHeight(newParent.right)) + 1;

            return newParent;
        }

        private Node<E> lrRotate(Node<E> node) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        private Node<E> rlRotate(Node<E> node) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        public void traversal() {
            traversal(root);
            System.out.println();
        }

        private void traversal(Node<E> node) {
            if (node != null) {
                traversal(node.left);
                System.out.print(node.value + " ");
                traversal(node.right);
            }
        }
    }

    static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
        int height = 0;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        tree.add(23);
        tree.add(5);
        tree.add(6);
        tree.add(8);
        tree.add(4);
        tree.add(7);
        tree.add(1);
        tree.add(3);
        tree.add(9);

        tree.traversal();

         tree.delete(7);
         tree.traversal();
         tree.delete(9);
         tree.traversal();
    }
}
