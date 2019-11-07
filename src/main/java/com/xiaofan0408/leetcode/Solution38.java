package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/7 15:10
 */
public class Solution38 {

    //1.     1
    //2.     11
    //3.     21
    //4.     1211
    //5.     111221

    public String countAndSay(int n) {
       return countAndSayCallback("1",1,n);
    }

    public String countAndSayCallback(String ans,int depath, int n) {
        if (n == depath) {
            return ans;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (ans.length() == 1) {
            stringBuffer.append(1);
            stringBuffer.append(ans.charAt(0));
        } else {
            for (int i = 0; i < ans.length();i++) {
                int k = i;
                while ((k +1) < ans.length() && ans.charAt(k) == ans.charAt(k + 1)) {
                    k++;
                }
                stringBuffer.append(k -i + 1);
                stringBuffer.append(ans.charAt(i));
                i = k;
            }
        }

        return countAndSayCallback(stringBuffer.toString(),depath + 1, n);
    }


    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.countAndSay(1));
        System.out.println(solution38.countAndSay(2));
        System.out.println(solution38.countAndSay(3));
        System.out.println(solution38.countAndSay(4));
        System.out.println(solution38.countAndSay(5));
        System.out.println(solution38.countAndSay(6));
        System.out.println(solution38.countAndSay(7));
    }

}
