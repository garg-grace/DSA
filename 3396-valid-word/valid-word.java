class Solution {
    public boolean isValid(String word) {
        int len = word.length();
        if(len<3) return false;
        boolean containsVowel=false;
        boolean containsConsonant = false;

        for(char ch:word.toCharArray()){
            if(48<=ch && ch<=57){}
            else if((65<=ch && ch<=90) || (97<=ch && ch<=122)){
                char temp = Character.toLowerCase(ch);
                if(temp=='a' || temp=='e' || temp=='i' || temp=='o' || temp=='u') containsVowel=true;
                else containsConsonant = true;
            }else{
                return false;
            }
        }
        if(containsConsonant && containsVowel) return true;
        return false;
    }
}