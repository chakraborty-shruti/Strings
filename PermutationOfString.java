import java.util.*;

class UniquePermutationsWithVisited {
    static void recurPermute(int i, int n, char[] p, List<String> ans,String S, boolean visited[]) {
        if (i == n) {
            ans.add(new String(p));
            return;
        }

        for (int j = 0; j < n; j++) {
            if(visited[j] == false){
                if(j>0){
                    //If j is not the first character in the string
                    //Here the codition are last charater should not be same as the present character if it us same then it should be alredy visited in the present permutation. 
                    if(S.charAt(j -1)!=S.charAt(j) || visited[j - 1] == true){
                        p[i] = S.charAt(j);
                        visited[j] = true;
                        recurPermute(i+1, n, p, ans, S, visited);
                        //Each time a complete permutation is formed, the recursive function backtracks by unmarking visited[j], allowing the same character to be used in different positions for other permutations.
                        visited[j] = false;
                    }
                }
                else{
                    //If j is the first character in the string then the following operation takes place
                    p[i] = S.charAt(j);
                    visited[j] = true;
                    recurPermute(i+1, n, p, ans, S, visited);
                    visited[j] = false;
                }
            }
        }
    }

    public static List<String> findUniquePermutations(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        
        char[] arr = s.toCharArray();
        Arrays.sort(arr); // Sorting helps to handle duplicates efficiently
        String S = arr.toString();

        boolean[] visited = new boolean[s.length()];

        char[] p = new char[n]; //Create a character array for storing permutation
        recurPermute(0,n,p,ans,S,visited);
        return ans;
    }

    public static void main(String[] args) {
        String s = "AAB";
        System.out.println(findUniquePermutations(s)); // [AAB, ABA, BAA]
    }
}
