package etc.DataStructure.Tree;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * 배열을 이용한 최소힙(Heap) 구현
 * - 배열로 구현하기 위해 제네릭 사용하지 않음
 * <p>
 * 주요 기능
 * add 노드 추가
 * delete 루트 노드 삭제
 * peak 루트 노드 조회
 * swap 노드 위치 교환
 */
public class HeapExample {

    public static void main(String[] args) {
        Random random = new Random();
        Heap h = new Heap(10);

        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(49) + 1; // 1 ~ 20
            h.add(n);
        }

        System.out.println("최초 heap: " + h);
        System.out.println("peek: " + h.peek());

        h.add(12);
        System.out.println("12 삽입 후 heap: " + h);
        h.add(5);
        System.out.println("5 삽입 후 heap: " + h);

        h.delete();
        System.out.println("힙 데이터 삭제 후 heap: " + h);

        h.delete();
        System.out.println("힙 데이터 삭제 후 heap: " + h);
    }

    protected static class Heap {
        int capacity = 0;
        int size = 0;
        int[] heap = null;

        public Heap(int capacity) {
            this.capacity = capacity;
            this.heap = new int[capacity + 1];
        }

        public void resize(int capacity) {
            if (size > capacity) {
                throw new IllegalArgumentException("힙의 크기보다 작아질 수는 없습니다.");
            }
            int[] newHeap = new int[capacity];
            for (int i = 1; i <= size; i++) {
                newHeap[i] = heap[i];
            }

            heap = newHeap;
        }

        private void add(int node) {
            if (size + 1 > capacity) {
                resize(size * 2); // 용량 초과시 2배로 증가
            }

            heap[size + 1] = node;

            // 들어갈 부모의 인덱스 = (size + 1) / 2
            int idx = size + 1;

            while (idx > 1) {
                if (heap[idx / 2] < node) {
                    break;
                }

                swap(idx / 2, idx);
                idx = idx / 2;
            }

            size++;
        }

        private void heapify(int idx) {
            int targetIdx = idx;

            if (idx * 2 <= size && heap[idx * 2] < heap[idx]) {
                targetIdx = idx * 2;
            }

            if (idx * 2 + 1 <= size && heap[idx * 2 + 1] < heap[idx]) {
                targetIdx = heap[idx * 2] <= heap[idx * 2 + 1] ? idx * 2 : idx * 2 + 1;
            }

            if (heap[targetIdx] < heap[idx]) {
                swap(targetIdx, idx);
                heapify(targetIdx);
            }
        }

        private int delete() {
            if (size == 0) {
                throw new NoSuchElementException();
            }

            // root 제거 -> root 자리에 last node 옮김
            int val = heap[1];
            heap[1] = heap[size];
            size--;

            heapify(1);

            return val;
        }

        private int peek() {
            if (size == 0) {
                throw new NoSuchElementException();
            }

            return heap[1];
        }

        private void swap(int idx0, int idx1) {
            int val = heap[idx0];
            heap[idx0] = heap[idx1];
            heap[idx1] = val;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= size; i++) {
                int val = heap[i];
                builder.append(val + ", ");
            }

            if (!builder.toString().isEmpty()) {
                builder.delete(builder.length() - 2, builder.length());
            }

            return "[" + builder + "]";
        }
    }
}

