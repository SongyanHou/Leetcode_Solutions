 /*
 Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.*/

public class Solution {
    public List<String> letterCombinations(String digits) {
    	List<String> res=new ArrayList<String>();
    	res.add("");
    	if(digits==null||digits.length()==0)
    		return res;
    	for(int i=0; i<digits.length(); i++){
    		List<String> newRes=new ArrayList<String>();
    		String letters=getString(digits.charAt(i));
    		for(int j=0; j<res.size(); j++){
    			for(int k=0; k<letters.length(); k++)
    				newRes.add(res.get(j)+letters.charAt(k));
    		}
    		res=newRes;
    	}
    	return res;
    }

    private String getString(char digit){
    	switch(digit){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':  
                return "ghi";  
            case '5':  
                return "jkl";  
            case '6':  
                return "mno";  
            case '7':  
                return "pqrs";  
            case '8':  
                return "tuv";  
            case '9':  
                return "wxyz";  
            case '0':  
                return " ";  
            default:  
                return "";  
    	}
    }

    public List<String> letterCombinationsRecur(String digits){
    	String[] dict={" ","", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    	List<String> res=new ArrayList<String>();
    	res.add("");
    	if(digits.length==0||digits==null)
    		return res;
    	helper(digits,dict,new StringBuilder(), res, 0);
    }

    private void helper(String digits, String[] dict, StringBuilder item, List<String> res, int pos){
    	if(pos==digits.length()){
    		res.add(item.toString());
    		return;
    	}
    	String letters=dict[digits.charAt(pos)-'0'];
    	for(int i=0; i<letters.length(); i++){
    		item.append(letters.charAt(i));
    		helper(digits,dict,item,res,pos+1);
    		item.deleteCharAt(item.length()-1);
    	}
    }
}