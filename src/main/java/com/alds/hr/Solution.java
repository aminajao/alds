package com.alds.hr;

/**
 * @author rohsi
 *
 */
public class Solution {
    
   // https://github.com/thiaguimcavalcanti/hacker-rank-restapi-with-spring-boot.git
    /**
    <dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-entitymanager</artifactId>
    <version>4.3.7.Final</version>
</dependency>

/**
 * 
Select a.BG, a.AcceptorAmount-b.DonarAmount as MoreBloodNeeded
From
(Select BG,SUM(AMOUNT)as AcceptorAmount
From ACCEPTOR Group by BG) a
LEFT JOIN
(Select BG, SUM(Amount) as DonarAmount
From DONOR Group by BG) b on a.BG=b.BG
WHERE (a.AcceptorAmount - b.DonarAmount > 0)
 */
	
}
