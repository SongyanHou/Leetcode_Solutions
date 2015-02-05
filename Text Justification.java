/*Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.*/
public class Solution {
	public List<String> fullJustify(String[] words, int L) {
    	List<String> res=new ArrayList<String>();
    	if(words.length==0||words==null)
    		return res;
    	int last=0;
    	int count=0;
    	for(int i=0; i<words.length; i++){
    		if(count+words[i].length()+(i-last)>L){
    			int space=0;
    			int extra=0;
    			if(i-1-last>0){
    				space=(L-count)/(i-1-last);
    				extra=(L-count)%(i-1-last);
    			}
    			StringBuilder sb=new StringBuilder();
    			for(int j=last; j<i; j++){
    				sb.append(words[j]);
    				if(j<i-1){
    					for(int k=0; k<space; k++)
    						sb.append(" ");
    					if(extra>0){
    						sb.append(" ");
    						extra--;
    					}
    					//extra--;
    				}
    			}
    			//if just one word, left justified
    			for(int l=sb.length(); l<L; l++){
    				sb.append(" ");
    			}
    			res.add(sb.toString());
    			last=i;
    			count=0;
    		}
    		count+=words[i].length();
    	}
    	StringBuilder sb=new StringBuilder();
    	for(int i=last; i<words.length; i++){
    		sb.append(words[i]);
    		if(sb.length()<L)
    			sb.append(" ");
    	}
    	for(int i=sb.length(); i<L; i++){
            sb.append(" ");
        }
    	res.add(sb.toString());
    	return res;
    }
}