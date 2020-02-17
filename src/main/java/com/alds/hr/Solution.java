package com.alds.hr;

/**
 * @author rohsi
 *
 */
public class Solution {
    
    public float openHoursRatio(TimeRange queryTimeRange, List<TimeRange> openHours) {
  //Convert person timings to minutes
    double personStartTime=(double)(queryTimeRange.start)*60;
    double personEndTime=(double)(queryTimeRange.end)*60;

    //Count the overlap between intervals
    double overlap = 0.0;
    for(TimeRange t : openHours)
    {
        //Convert store timings to minutes
        double storeStartTime=(double)(t.start) * 60;
        double storeEndTime=(double)(t.end) * 60;
        
        //no overlap 
        if(storeStartTime > personEndTime || personStartTime > storeEndTime)
            continue;

        //Get the latest start    
        double overlapStart= Math.max(personStartTime,storeStartTime);
        //Get the earliest end 
        double overlapEnd= Math.min(personEndTime,storeEndTime);
        //Total overlap 
        overlap+=overlapEnd-overlapStart;

    }
    //To avoid divide by 0
    if(personEndTime!=personStartTime)
        return (float)(overlap/(personEndTime - personStartTime));
    return (float)overlap;
    }
    
}
