package com.xiaofan0408.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author xuzefan  2020/8/14 17:11
 */
public class Solution752 {

    // 将 s[j] 向上拨动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }

    public int openLock(String[] deadends, String target) {
        int num = 0;
        Set<String> visited = new HashSet<>();
        Set<String> deadSet = new HashSet<>();
        for (String d:deadends) {
            deadSet.add(d);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        while (queue.size() > 0){
            int sz = queue.size();
            String temp;
            for (int i=0; i<sz;i++) {
                temp =  queue.poll();
                if (deadSet.contains(temp)) {
                    continue;
                }
                if (target.equals(temp)){
                    return num;
                }
                for (int j=0;j<4;j++){
                    String up = plusOne(temp,j);
                    String down = minusOne(temp,j);
                    if (!visited.contains(up)) {
                        visited.add(up);
                        queue.offer(up);
                    }
                    if (!visited.contains(down)) {
                        visited.add(down);
                        queue.offer(down);
                    }
                }
            }
            num++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution752 solution752 = new Solution752();
        System.out.println(solution752.openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));
        System.out.println(solution752.openLock(new String[]{"8888"},"0009"));
        System.out.println(solution752.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));
        System.out.println(solution752.openLock(new String[]{"0000"},"8888"));
    }
}
