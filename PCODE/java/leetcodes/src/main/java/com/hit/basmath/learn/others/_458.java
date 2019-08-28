package com.hit.basmath.learn.others;

/**
 * 458. Poor Pigs
 * <p>
 * There are 1000 buckets, one and only one of them is poisonous, while the rest are filled with water. They all look identical. If a pig drinks the poison it will die within 15 minutes. What is the minimum amount of pigs you need to figure out which bucket is poisonous within one hour?
 * <p>
 * Answer this question, and write an algorithm for the general case.
 * <p>
 * General case:
 * <p>
 * If there are n buckets and a pig drinking poison will die within m minutes, how many pigs (x) you need to figure out the poisonous bucket within p minutes? There is exactly one bucket with poison.
 * <p>
 * Note:
 * <p>
 * 1. A pig can be allowed to drink simultaneously on as many buckets as one would like, and the feeding takes no time.
 * 2. After a pig has instantly finished drinking buckets, there has to be a cool down time of m minutes. During this time, only observation is allowed and no feedings at all.
 * 3. Any given bucket can be sampled an infinite number of times (by an unlimited number of pigs).
 */
public class _458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int status = minutesToTest / minutesToDie + 1;
        int num_of_pig = 0;
        while (Math.pow(status, num_of_pig) < buckets) {
            num_of_pig++;
        }
        return num_of_pig;
    }
}
