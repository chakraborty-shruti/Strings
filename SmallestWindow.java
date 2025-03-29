//Smallest window in a String containing all characters of other String
//Given two strings S (length m) and P (length n), the task is to find the smallest substring in S that contains all characters of P, including duplicates.

class Test{

    static boolean check(int c1[], int c2[]){

        boolean flag = true;
        for(int i =0; i< 26; i++){
            if(c1[i] < c2[i]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    static String smallestWindow(String s, String p){
        int l , r ,ans_l = -1, ans_r = -1;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        String ans;

        for(int i = 0; i < 26; i++){
            c1[i] = c2[i] = 0;
        }
        int n = s.length();
        int m = p.length();

        for(int i =0; i < m ; i++){
            c2[p.charAt(i) - 'a']++;
        }

        l = r = 0;

        for(r =0; r<n; r++){
            c1[s.charAt(r) - 'a']++;// increment the count of the character at index r in the frequency array c1.

            while(check(c1,c2) == true){
                //we are initiating ans_left and ans_right if not initiated
                if(ans_l == -1){
                    ans_l =l;
                    ans_r = r;
                }else if((ans_r - ans_l +1) > (r -l +1)){
                    //if the current value of left and right are smaller than already present left and right than we change the current ans_l and ans_r
                    ans_l =l;
                    ans_r = r;
                }
                c1[s.charAt(l) - 'a']--;// decreases the count of the character at index l in the frequency array c1
                l++;
            }
        }
        if(ans_l == -1){
            ans = "-1";
        }else{
            ans = s.substring(ans_l, ans_r - ans_l + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "timetoprac";
        String p = "toc";

        System.out.println(smallestWindow(s,p));
    }
}