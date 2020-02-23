package com.alds.hr;

/**
 * @author rohsi
 *
 */
public class Solution {
    
    public static List<String> findReachableBusinesses(Business startingBusiness, int distance) {
        visited.put(startingBusiness, true);
        dfs(startingBusiness, distance, 0);
        return answer;
    }
    static List<String> answer = new ArrayList<>();
    static Map<Business, Boolean> visited = new HashMap<>();
    public static void dfs(Business startingBusiness, int distance, int curr){
        Map<Business, Integer> near = startingBusiness.getNearbyBusinesses();
        for(Business b: near.keySet()){
            if(visited.getOrDefault(b, false)==false && near.get(b) + curr <= distance){
                visited.put(b, true);
                answer.add(b.getName());
                dfs(b, distance, curr + near.get(b));
            }
        }
    }
}
