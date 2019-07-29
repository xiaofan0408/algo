package com.xiaofan0408.swordoffer;

/**
 * @author xuzefan  2019/7/29 17:41
 */
public class ReplaceBlank {


    private static int replaceBlank(char[] string, int i) {
        if (string == null || string.length == 0) {
            return 0;
        }
        int numOfblank = 0;
        for(int k=0;k<i; k++) {
            char ch = string[k];
            if (ch == ' ') {
                numOfblank++;
            }
        }
        int newLength = i + numOfblank * 2;
        int indexOrigin = i - 1;
        int indexNew = newLength - 1;
        while (indexOrigin>=0&& indexNew > indexOrigin){
            if (string[indexOrigin] == ' ') {
                string[indexNew] = '0';
                indexNew --;
                string[indexNew] = '2';
                indexNew--;
                string[indexNew] = '%';
                indexNew --;
            } else {
                string[indexNew] = string[indexOrigin];
                indexNew --;
            }
            indexOrigin --;
        }
        return newLength;
    }
    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';

        int length = replaceBlank(string, 12);
        System.out.println(new String(string, 0, length));
    }
}
