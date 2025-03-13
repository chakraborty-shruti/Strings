//Check if a string can be obtained by rotating a string by 2 places

class Test{

    public boolean isRotated(String str1, String str2){
        int n = str1.length();
        boolean clockwise = true;
        boolean anticlockwise = true;

        //Check if str2 can be obtained by rotating str1 clockwise by 2 places
        for(int i = 0; i < n; i++){
            if(str1.charAt(i) != str2.charAt((i + 2) % n)){
                clockwise = false; //not rotated clockwise
                break;
            }
        }

        //Check if str2 can be obtained by rotating str1 anticlockwise by 2 places
        for(int i = 0; i < n; i++){
            if(str1.charAt((i+2)%2) != str2.charAt(i)){
                anticlockwise = false; //not rotated anticlockwise
                break;
            }
        }

        return clockwise || anticlockwise;
    }

    public static void main(String[] args) {
        Test solution = new Test();

        String str1 = "amazon";
        String str2 = "azonam";
        System.out.println(solution.isRotated(str1,str2));

        str1 = "amazon";
        str2 = "onamaz";
        System.out.println(solution.isRotated(str1, str2));
    }
}