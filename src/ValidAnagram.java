import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s= "anagram";
        String t ="naagram";

        System.out.println(isAnagram(s,t));
    }
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i =0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i) , 1 );
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }

        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            Integer value = map.get(c);
            if (value == null) {
                return false;
            } else {
                if (value == 1) {
                    map.remove(c);
                } else {
                    map.put(c, value - 1);
                }
            }
        }

        return map.size()==0;
    }
}
