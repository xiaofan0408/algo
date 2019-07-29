package com.xiaofan0408.other;

import java.util.BitSet;

/**
 * @author xuzefan  2019/7/29 13:59
 */
public class BloomFilter {

    private final int DEFAULT_SIZE = 2 << 28;

    private  static  final int[] seeds  =  new int[] {  3, 5, 7 ,  11 ,  13 ,  31 ,  37 ,  61 };

    private BitSet bitSet = new BitSet(DEFAULT_SIZE);

    private Hash[] func = new Hash[seeds.length];

    public  BloomFilter() {
        for  ( int  i  =   0 ; i  <  seeds.length; i ++ ) {
            func[i]  =   new  Hash(DEFAULT_SIZE, seeds[i]);
        }
    }

    public   void  add(String value) {
        for  (Hash f : func) {
            bitSet.set(f.hash(value),  true );
        }
    }

    public   boolean  contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ret = true;
        for (Hash f : func) {
            ret = ret && bitSet.get(f.hash(value));
        }
        return ret;
    }

    private class Hash{
        int cap;
        int seed;

        Hash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        public   int  hash(String value) {
            int  result  =   0 ;
            int  len  =  value.length();
            for  ( int  i  =   0 ; i  <  len; i ++ ) {
                result  =  seed  *  result  +  value.charAt(i);
            }
            return  (cap  -   1 )  &  result;
        }
    }

    public   static   void  main(String[] args) {
        String value  =   " stone2083@yahoo.cn " ;
        BloomFilter filter  =   new  BloomFilter();
        System.out.println(filter.contains(value));
        filter.add(value);
        System.out.println(filter.contains(value));
    }

}
