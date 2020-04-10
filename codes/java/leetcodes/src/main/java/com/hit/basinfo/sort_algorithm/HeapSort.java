package com.hit.basinfo.sort_algorithm;

import com.hit.utils.CommonUtils;

/**
 * author:Charies Gavin
 * date:2019/11/11,19:30
 * https:github.com/guobinhit
 * description: Heap Sort
 */
public class HeapSort {

    /**
     * Heap Sort
     * <p>
     * Sort by max heap by default
     *
     * @param nums pending array
     */
    public void heapSort(int[] nums) {
        heapSort(nums, HeapType.MaxHeap);
    }

    /**
     * Heap Sort
     *
     * @param nums pending array
     * @param type heap type
     */
    public void heapSort(int[] nums, HeapType type) {
        // check parameters
        if (nums == null || nums.length == 1 || type == null) {
            return;
        }

        /**
         * The first sorting, building the largest heap,
         * only ensures that the top element of the heap is the largest in the array
         */
        buildHeap(nums, type);

        for (int i = nums.length - 1; i >= 1; i--) {
            /**
             * After the above column operations,
             * array[0] is the largest element in the current array,
             * which needs to be exchanged with the element at the end
             */
            CommonUtils.swapElementInArray(nums, 0, i);

            /**
             * After the exchange, the next time you traverse,
             * you should skip the last element, which is the maximum value,
             * and start rebuilding the maximum heap
             */
            if (HeapType.MaxHeap.name().equals(type.name())) {
                maxHeap(nums, i, 0);
            } else if (HeapType.MinHeap.name().equals(type.name())) {
                minHeap(nums, i, 0);
            } else {
                throw new IllegalArgumentException("heap type must be one of MaxHeap or MinHeap");
            }
        }
    }

    /**
     * Heap Sort
     *
     * @param nums pending array
     * @param type heap type
     */
    private void buildHeap(int[] nums, HeapType type) {
        // check parameters
        if (nums == null || nums.length == 1 || type == null) {
            return;
        }

        // heap formula is: root = 2*i, left = 2*i+1, right = 2*i+2
        int cursor = nums.length / 2;
        for (int i = cursor; i >= 0; i--) {
            if (HeapType.MaxHeap.name().equals(type.name())) {
                maxHeap(nums, nums.length, i);
            } else if (HeapType.MinHeap.name().equals(type.name())) {
                minHeap(nums, nums.length, i);
            } else {
                throw new IllegalArgumentException("heap type must be one of MaxHeap or MinHeap");
            }
        }
    }

    /**
     * Max Heap
     *
     * @param nums     pending array
     * @param heapSize the size of heap
     * @param index    the index of heap
     */
    private void maxHeap(int[] nums, int heapSize, int index) {
        // left child node
        int left = index * 2 + 1;
        // right child node
        int right = index * 2 + 2;
        // temporarily set at index is the maximum value
        int maxValue = index;

        /**
         * If the value of the left child node is larger than the current maximum value,
         * the position of the maximum value will be replaced by the position of the left child node
         */
        if (left < heapSize && nums[left] > nums[maxValue]) {
            maxValue = left;
        }

        /**
         * If the value of the right child node is larger than the current maximum value,
         * the position of the maximum value will be replaced by the position of the right child node
         */
        if (right < heapSize && nums[right] > nums[maxValue]) {
            maxValue = right;
        }

        /**
         * If it's not equal, it means that the value of this child node is larger than itself,
         * and the position has changed
         */
        if (maxValue != index) {
            // swap location elements
            CommonUtils.swapElementInArray(nums, index, maxValue);

            /**
             * After swapping positions, it is also necessary to determine whether
             * the child node breaks the property of the maximum heap.
             * Maximum heap property: both child nodes are smaller than the parent node
             */
            maxHeap(nums, heapSize, maxValue);
        }
    }

    /**
     * Min Heap
     *
     * @param nums     pending array
     * @param heapSize the size of heap
     * @param index    the index of heap
     */
    private void minHeap(int[] nums, int heapSize, int index) {
        // left child node
        int left = index * 2 + 1;
        // right child node
        int right = index * 2 + 2;
        // temporarily set at index is the minimum value
        int minValue = index;

        /**
         * If the value of the left child node is smaller than the current minimum value,
         * the position of the minimum value is replaced by the position of the left child node
         */
        if (left < heapSize && nums[left] < nums[minValue]) {
            minValue = left;
        }

        /**
         * If the value of the right child node is smaller than the current minimum value,
         * the position of the minimum value is replaced by the position of the left child node
         */
        if (right < heapSize && nums[right] < nums[minValue]) {
            minValue = right;
        }

        /**
         * If it's not equal, it means that the value of this child node is less than itself,
         * and the position has changed
         */
        if (minValue != index) {
            // swap location elements
            CommonUtils.swapElementInArray(nums, index, minValue);

            /**
             * After swapping positions, it is also necessary to determine whether
             * the child nodes break the minimum heap property.
             * Minimum property: both child nodes are larger than the parent node
             */
            minHeap(nums, heapSize, minValue);
        }
    }

    /**
     * Heap Type
     */
    public enum HeapType {
        // Sort from small to large
        MaxHeap,
        // Sort from large to small
        MinHeap
    }
}
