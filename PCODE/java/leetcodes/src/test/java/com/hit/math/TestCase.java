package com.hit.math;

import com.hit.utils.CommonUtils;
import com.hit.utils.ListNode;
import com.hit.utils.TreeNode;

import java.math.BigInteger;
import java.util.*;

/**
 * author:Charies Gavin
 * date:2018/8/25,17:00
 * https:github.com/guobinhit
 * description: Test Case Class
 */
public class TestCase {
    public static void main(String[] args) {
        int[] ints = {1, 3, 3};
        int[] ints2 = {1, 1, 3};
//        System.out.println(findMin(ints));
//        System.out.println(findMin(ints2));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        while (root != null) {
            if (root.left == null) {
                list.add(root.val);
                if (root.right == null) {
                    return list;
                } else {
                    root = root.right;
                    list.add(root.val);
                }
            } else {
                root = root.left;
                list.add(root.val);
            }
        }
        return list;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                // Reverse the process of preorder
                result.addFirst(root.val);
                // Reverse the process of preorder
                root = root.right;
            } else {
                TreeNode node = stack.pop();
                // Reverse the process of preorder
                root = node.left;
            }
        }
        return result;
    }
}
