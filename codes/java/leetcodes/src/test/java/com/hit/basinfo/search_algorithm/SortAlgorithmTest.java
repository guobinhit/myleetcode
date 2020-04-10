package com.hit.basinfo.search_algorithm;

import com.hit.basinfo.sort_algorithm.*;

import java.util.Arrays;

/**
 * author:Charies Gavin
 * date:2019/11/11,14:33
 * https:github.com/guobinhit
 * description: Sort Algorithm Test
 */
public class SortAlgorithmTest {
    public static void main(String[] args) {
        int[] nums = {0, -1, 9, -3, 5, 3, 62, 20};
        System.out.println("nums is " + Arrays.toString(nums));
        new BubbleSort().bubbleSort(nums);
        System.out.println("after bubble sort, nums is " + Arrays.toString(nums));

        int[] nums2 = {0, -1, 9, -3, 5, 3, 62, 20};
        System.out.println("nums2 is " + Arrays.toString(nums2));
        new SelectSort().selectSort(nums2);
        System.out.println("after select sort, nums2 is " + Arrays.toString(nums2));

        int[] nums3 = {0, -1, 9, -3, 5, 3, 62, 20};
        System.out.println("nums3 is " + Arrays.toString(nums3));
        new InsertSort().insertSort(nums3);
        new InsertSort().binaryInsertSort(nums3);
        new InsertSort().shellInsertSort(nums3);
        System.out.println("after insert sort, nums3 is " + Arrays.toString(nums3));

        int[] nums4 = {0, -1, 9, -3, 5, 3, 62, 20};
        System.out.println("nums4 is " + Arrays.toString(nums4));
        new QuickSort().quickSort(nums4);
        System.out.println("after quick sort, nums4 is " + Arrays.toString(nums4));

        int[] nums5 = {0, -1, 9, -3, 5, 3, 62, 20};
        System.out.println("nums5 is " + Arrays.toString(nums5));
        new MergeSort().mergeSort(nums5);
        System.out.println("after merge sort, nums5 is " + Arrays.toString(nums5));

        int[] nums6 = {0, -1, 9, -3, 5, 3, 62, 20};
        System.out.println("nums6 is " + Arrays.toString(nums6));
        new HeapSort().heapSort(nums6, HeapSort.HeapType.MinHeap);
        System.out.println("after min heap sort, nums6 is " + Arrays.toString(nums6));
        new HeapSort().heapSort(nums6, HeapSort.HeapType.MaxHeap);
        System.out.println("after max heap sort, nums6 is " + Arrays.toString(nums6));
    }
}
