//find the length of the longest substring without repeating characters. 

class Test{

    static final int MAX_CHAR = 26;
    static int longestUniqueSubstring(String s){
        int n = s.length();
        int res = 0;

        for(int i = 0; i < n; i++){
            boolean[] vis = new boolean[MAX_CHAR];
            for(int j = i; j < n; j++){
                if(vis[s.charAt(j) - 'a'] == true){
                    break;//If character is visited break the loop
                }else{
                    //Else update the result if this window is larger and mark current character as visited.
                    res = Math.max(res, j - i + 1);
                    vis[s.charAt(j) - 'a'] = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSubstring(s));
    }
}