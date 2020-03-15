package com.hit.basmath.interview.we_meet.xindongfang;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/4,下午4:28
 * @description
 */
public class BoxEgg {
    public static void main(String[] args) {
        BoxEgg egg = new BoxEgg();
        System.out.println(egg.lastBox(0));
        System.out.println(egg.lastBox(1));
        System.out.println(egg.lastBox(2));
        System.out.println(egg.lastBox(3));
        System.out.println(egg.lastBox(10));
        System.out.println(egg.lastBox(20));
        System.out.println(egg.lastBox(26));
        System.out.println(egg.lastBox(27));
        System.out.println(egg.lastBox(28));
    }

    private int lastBox(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += getEggCount(i);
            if (count >= n) {
                count -= getEggCount(i);
                if (n - count == 0) {
                    return getEggCount(i);
                } else {
                    return n - count;
                }

            }
        }
        return -1;
    }

    private int getEggCount(int n) {
        return (int) Math.pow(2, n - 1);
    }
}
