import java.util.HashMap;

class Test{

    static int romanToDecimal(String s){
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);

        int res = 0;
        for(int i =0; i< s.length(); i++){
            //If the current value is less than the next value,subtract current from next and add to res
            if(i + 1< s.length() && romanMap.get(s.charAt(i))<romanMap.get(s.charAt(i + 1))){
                res += romanMap.get(s.charAt(i + 1)) - romanMap.get(s.charAt(i));

                //Skip the next symbol
                i++;

            }
            else{
                //Otherwise add the current value to res
                res += romanMap.get(s.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "IX";
        System.out.println(romanToDecimal(s));
    }
}