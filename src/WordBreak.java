import java.util.*;

public class WordBreak{
    public static void main(String[] args) {
        String s = "leetcode";
       List<String> wordDict= new ArrayList<>();
       wordDict.add("leet");
       wordDict.add("code");

        HashSet<String> st =new HashSet<>();
        for(int i=0; i<wordDict.size(); i++){
            st.add(wordDict.get(i));
        }

        System.out.println(solve(0, s,new HashSet<>(st)));
    }
    public static boolean solve(int start, String s,HashSet<String> st){
        if(start >= s.length()){
            return true;
        }
        if(s.equals(st.contains(s))){
            return true;
        }

        for(int i=1; i<=s.length(); i++){
            String temp = s.substring(start,i);

            if(temp.equals(st.contains(temp)) && solve(start+i , s , st)){
                return true;
            }
        }
        return false;
    
    }
}