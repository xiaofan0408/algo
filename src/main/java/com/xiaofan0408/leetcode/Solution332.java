package com.xiaofan0408.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author xuzefan  2020/8/14 14:32
 */
public class Solution332 {

    //Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
   //Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

    //Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
   //Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]

    //[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
    List<String> result = new ArrayList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> list: tickets) {
            if (map.get(list.get(0)) == null) {
                map.put(list.get(0),new PriorityQueue<>());
            }
            map.get(list.get(0)).offer(list.get(1));
        }
        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    private void dfs(String from) {
        if (!map.containsKey(from)) {
            result.add(from);
            return;
        }
        PriorityQueue<String> queue = map.get(from);
        if (queue.size() <= 0) {
            result.add(from);
            return;
        } else {
            while (queue.size()!=0){
                dfs(queue.poll());
            }
            result.add(from);
        }
    }

//    public void callBack(String from,Map<String,PriorityQueue<String>> map,List<String> result){
//        if (from != null) {
//            result.add(from);
//            if (map.get(from)!= null) {
//                PriorityQueue<String> queue = map.get(from);
//                callBack(queue.poll(),map,result);
//            }
//        }
//    }

}
