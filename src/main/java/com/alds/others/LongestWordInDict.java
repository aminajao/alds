/**
 * 
 */
package com.alds.others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rohsi
 *
 */
public class LongestWordInDict {
	
	public static String longestWord(String[] words) {
        
        if(words.length == 0) {
            return "";
        }
        
        Set<String> wordsSet = new HashSet<>();
        for(int i=0; i<words.length; i++) {
            wordsSet.add(words[i]);
        }
        
        List<String> result = new ArrayList<>();
        
        for(int i=0; i<words.length; i++){
            String elem = words[i];
            int len = elem.length();         
            int k=0;
            boolean isPresent = true;
            
            while(k<len) {
            	String ind = elem.substring(0,k+1);
                if(!wordsSet.contains(ind)){
                    isPresent = false;
                }
                k++;
            }
            if(isPresent) {
                result.add(elem);
            }
        }
        
        if(result.isEmpty()) {
            return "";
        }
        
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                }
                return s1.compareTo(s2);
            }   
        });
        
        return result.get(0);
	}

	public static void main(String[] args) {
        String[] in = {"w","wo","wor","worl","world"};
        System.out.println(longestWord(in));
    }
}
