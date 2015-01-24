import java.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
       
        int n = numbers.length;
        
        
        int [] copy = new int[n];
        for (int i=0; i<n; i++){
            copy[i]=numbers[i];
        }
        Arrays.sort(copy);
        
        int first=0, last=n-1;
        while(first<last){
            if(copy[first]+copy[last]<target){
                first++;
                continue;
            }
            else if(copy[first]+copy[last]>target){
                last--;
                continue;
            }
            else
            break;
        }
        
        int r1=-1, r2=-1;
        for (int j=0; j<n; j++){
            if(numbers[j]==copy[first]||numbers[j]==copy[last]){
                if(r1==-1){
                    r1=j+1;
                }
                else if (r2==-1){
                    r2=j+1;
                }
            }
        }
        
        int [] res = new int[] {r1,r2};
        return res;
        
        
    }
}