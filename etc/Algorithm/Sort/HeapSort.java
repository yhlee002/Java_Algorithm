package etc.Algorithm.Sort;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        Random random = new Random();

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(49) + 1;
        }
        System.out.println("arr: " + Arrays.toString(arr));

        MaxHeap.heapSort(arr);
        System.out.println("arr(after heap sort): " + Arrays.toString(arr));
    }

    static class MaxHeap {
        private static void swap(int[] list, int idx0, int idx1) {
            int val = list[idx0];
            list[idx0] = list[idx1];
            list[idx1] = val;
        }

        /**
         * 힙 또는 힙이 아닌 배열을 재정렬
         *
         * @param list 배열
         * @param idx 재정렬을 시작할 부모 노드 인덱스
         * @param lastIdx 마지막 인덱스보다 작아야 노드가 존재하는 것이기 때문에 이를 위해 넣음
         *                (sorting시 추가적인 메모리 사용을 막기 위해 기존 배열을 heapify(shift-down)한 뒤
         *                루트 노드를 맨 뒤 요소와 바꾸면서 재정렬하는 길이를 1씩 줄임(루트 요소와 맞바꾼 요소는
         *                더이상 sorting되지 않도록 하기 위함)
         */
        private static void shiftDown(int[] list, int idx, int lastIdx) {
            int cIdx0 = idx * 2 + 1;
            int cIdx1 = idx * 2 + 2;

            int targetIdx = idx;
            if (cIdx0 <= lastIdx && list[cIdx0] > list[targetIdx]) {
                targetIdx = cIdx0;
            }

            if (cIdx1 <= lastIdx && list[cIdx1] > list[targetIdx]) {
                targetIdx = cIdx1;
            }

            if (targetIdx != idx) {
                swap(list, targetIdx, idx);
                shiftDown(list, targetIdx, lastIdx);
            }
        }

        /**
         * 정렬되지 않은 배열(이진 트리)를 힙 속성을 만족하도록 재정렬(heap sort)
         * @param list 외부 배열
         * @return result
         */
        public static void heapSort(int[] list) {
            if (list.length < 2) {
                return;
            }

            int parentIdx = (list.length - 1) / 2;
            int lastIdx = list.length - 1;

            for (int i = parentIdx; i >= 0; i--) { // 재정렬
                shiftDown(list, i, lastIdx);
            }

            for (int i = list.length - 1; i >= 0; i--) {
                swap(list, 0, i); // 마지막 요소부터 하나씩 앞으로 당기며 root값 가짐
                lastIdx--;
                shiftDown(list, 0, lastIdx);
            }
        }
    }
}
