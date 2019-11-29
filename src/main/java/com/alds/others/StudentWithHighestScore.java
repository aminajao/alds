/*
* Copyright (C) 2019 BlackRock.
*
* Created on Nov 28, 2019
*
* Last edited by: $Author: $
*             on: $Date: $
*       Filename: $Id:  $
*       Revision: $Revision: $
*/
package com.alds.others;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author rohsingh
 *
 */
public class StudentWithHighestScore {
    
    public static String solve(String[][] in) { 
        
        class Student implements Comparable<Student>{
             public String name;
             public int avgScore;
             public int count;
             
            @Override
            public int compareTo(Student o) {
                if(this.avgScore < o.avgScore) {
                    return 1;
                } else {
                    return -1;
                }
            }        
        }
        
        
       Map<String, Student> data = new HashMap<>();
       
       for(String[] row : in) {
           if(!data.containsKey(row[0])) {
               Student s = new Student();
               s.name = row[0];
               s.avgScore = Integer.parseInt(row[1]);
               s.count = 1;
               data.put(row[0], s);    
           } else {
               Student so = data.get(row[0]);
               so.count +=1;
               so.avgScore = (so.avgScore + Integer.parseInt(row[1])) / so.count;
               data.put(row[0], so);  
           }
       }
       
       List<Student> res = data.values().stream().sorted().collect(Collectors.toList());
       
       return res.get(0).name;
    }
    
    public static void main(String[] args) {
        String[][] in = {{"Jerry", "65"}, {"Bob", "91"}, {"Jerry", "23"}, {"Eric", "83"}, {"Eric", "68"}, {"Bob", "80"}, {"Jerry", "25"}};
        System.out.println(solve(in));
    }

}
