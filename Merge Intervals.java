/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].*/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	//First we should sort these intervals
    	//set the start as the comparing metric
    	//define a new comparator
    	List<Interval> res=new ArrayList<Interval>();
    	if(intervals==null||intervals.size()==0)
    		return intervals;
    	Comparator<Interval> comp=new Comparator<Interval>(){
    		public int compare(Interval i1,Interval i2){
    			if(i1.start==i2.start)
    				return i1.end-i2.end;
    			return i1.start-i2.start;
    		}
    	};
    	Collections.sort(intervals,comp);

    	res.add(intervals.get(0));
    	for(int i=1; i<intervals.size(); i++){
    		if(res.get(res.size()-1).end>=intervals.get(i).start){
    			res.get(res.size()-1).end=Math.max(res.get(res.size()-1).end, intervals.get(i).end);
    		}else{
    			res.add(intervals.get(i));
    		}

    	}
    	return res;
    }
}