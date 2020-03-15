package com.hit.basmath.interview.we_meet.huawei;

import java.util.*;

public class TimeOfGuest {
    public static void main(String[] args) {
        // 存储时间段与访客数量的映射关系
        Map<String, Integer> timeTable = new LinkedHashMap<>();
        timeTable.put("[12,13)", 0);
        timeTable.put("[13,14)", 0);
        timeTable.put("[14,15)", 0);
        timeTable.put("[15,16)", 0);
        timeTable.put("[16,17)", 0);
        timeTable.put("[17,18)", 0);
        timeTable.put("[18,19)", 0);
        timeTable.put("[19,20)", 0);
        // 存储时间点与 timeTable 键的映射关系
        Map<Integer, String> indexToTable = new LinkedHashMap<>();
        indexToTable.put(12, "[12,13)");
        indexToTable.put(13, "[13,14)");
        indexToTable.put(14, "[14,15)");
        indexToTable.put(15, "[15,16)");
        indexToTable.put(16, "[16,17)");
        indexToTable.put(17, "[17,18)");
        indexToTable.put(18, "[18,19)");
        indexToTable.put(19, "[19,20)");
        indexToTable.put(20, null);
        // 转换输入为字符串数组
        String[] timeStrArr;
        // 创建共享变量，防止每次输入都创建数组，节省开销
        int[] timeIntArr = new int[2];
        String timeTableKey;
        // 控制台输入
        Scanner in = new Scanner(System.in);
        // 循环处理输入参数
        while (in.hasNext()) {
            String guestInfo = in.nextLine();
            // 判断终止条件
            if ("-1,-1".equals(guestInfo) || !guestInfo.contains(",")) {
                break;
            }
            // 转换输入值至整型数组
            timeStrArr = guestInfo.split(",");
            timeIntArr[0] = Integer.valueOf(timeStrArr[0]);
            timeIntArr[1] = Integer.valueOf(timeStrArr[1]);
            // 校验参数非法情况
            if (timeIntArr[0] < 12 || timeIntArr[1] > 20) {
                continue;
            }
            // 过滤时间点的集合
            Set<Integer> timeSet = new HashSet<>();
            // 将大于签到开始时间的值放入集合
            for (Integer arriveTime : indexToTable.keySet()) {
                if (arriveTime >= timeIntArr[0]) {
                    timeSet.add(arriveTime);
                }
            }
            // 将大于签到结束时间的值移除集合
            for (Integer leaveTime : indexToTable.keySet()) {
                if (leaveTime >= timeIntArr[1]) {
                    timeSet.remove(leaveTime);
                }
            }
            // 处理满足条件的时间段，累加访客数量
            for (Integer time : timeSet) {
                timeTableKey = indexToTable.get(time);
                timeTable.put(timeTableKey, timeTable.get(timeTableKey) + 1);
            }
        }
        // 输出结果
        for (String timeKey : timeTable.keySet()) {
            System.out.println(timeKey + ":" + timeTable.get(timeKey));
        }
    }
}