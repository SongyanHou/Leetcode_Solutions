/*Given n points on a 2D plane, 
find the maximum number of points that lie on the same straight line.*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
    	if(points.length==0)
    		return 0;
    	if(allSame)
    		return points.length;
    	int max=0;
    	for(int i=0; i<points.length; i++){
    		for(int j=i+1; j<points.length; j++){
    			if(points[i].x==points[j].x && points[i].y==points[j].y)
    				continue;
    			int cur=2;
    			for(int k=0; k<points.length; k++){
    				if(k!=i && k!=j && (points[j].y-points[i].y)*(points[k].x-points.[j].x)==(points[k].y-points[j].y)*(points[j].x-points[i].x))
    					cur++;
    			}
    			max=Math.max(cur, max);
    		}
    	}
    	return max;
    }

    private boolean allSame(Point[] points){
    	for(int i=1; i<points.length; i++){
    		if(points[0].x!=points[i].x||points[0].y!=points[i].y)
    			return false;
    	}
    	return true;
    }
}