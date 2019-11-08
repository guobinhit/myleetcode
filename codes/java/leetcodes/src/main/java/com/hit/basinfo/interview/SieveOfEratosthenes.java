package com.hit.basinfo.interview;

/**
 * author:Charies Gavin
 * date:2019/1/4,10:20
 * https:github.com/guobinhit
 * description: 埃拉托斯特尼筛法
 */
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int i = 0;
        for (boolean b : sieveOfEratosthenes(100)) {
            int prime = i++;
            if (b) {
                System.out.println(prime);
            }
//            System.out.println(prime + (b ? " is " : " is't ") + "prime!");
        }
    }


    public static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];

        // 定制初始化布尔数组
        init(flags);
        int prime = 2;

        // 当前迭代的素数小于等于 max 的时候，继续迭代
        while (prime <= max) {
            // 划掉 prime 的倍数
            crossOff(flags, prime);
            // 获取下一个素数
            prime = getNextPrime(flags, prime);
            // 如果 prime 超过布尔数组的长度，即可停止迭代
            if (prime >= flags.length) {
                break;
            }
        }
        return flags;
    }


    /**
     * 初始化布尔数组，将除索引值为 0 和 1 之外的其他索引对应的值设置为 true
     *
     * @param flags
     */
    private static void init(boolean[] flags) {
        // 当布尔数组的长度小于 2 时，索引值 0 和 1 均非素数，无须处理，直接返回
        if (flags != null && flags.length > 2) {
            // 将索引位置除 0 和 1 之外的所有元素设置为 true
            for (int i = 2; i < flags.length; i++) {
                flags[i] = true;
            }
        }
    }

    /**
     * 划掉余下为 prime 倍数的数字，我们可以从 (prime * prime) 开始，
     * 因为如果 k * prime 且 K < prime，则该值早就在之前的迭代里面被划掉了
     *
     * @param flags
     * @param prime
     */
    private static void crossOff(boolean[] flags, int prime) {
        // 每次迭代步长为 prime，增幅后的数字即为 prime 的倍数
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    /**
     * 获取下一个为 true 的值
     *
     * @param flags
     * @param prime
     * @return
     */
    private static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }
}
