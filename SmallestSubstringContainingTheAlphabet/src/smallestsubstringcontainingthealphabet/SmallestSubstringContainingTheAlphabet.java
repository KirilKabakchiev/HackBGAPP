/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smallestsubstringcontainingthealphabet;

/**
 *
 * @author Win7
 */

//        for (int i = 0; i < counting.length; i++) {
//            count[(int) counting[i]]++;
//        }
//        for (int i = 0; i < count.length; i++) {
//            if(count[i] != 0 )
//                System.out.println((char)i);
//        }
public class SmallestSubstringContainingTheAlphabet {

    //I believe that its possible for a more effective solution to be produced.
    //
    public static String smallestSubstringContainingTheAlphabet(String str, String key) {
        int minLen = 0;
        int currentPosition = 0;
        String minString = "";
        char[] keyArray = key.toCharArray();
        int[] count = new int[256];
        char[] strArray = str.toCharArray();
        String res = "";


        for (int i = 0; i < strArray.length; i++) {
            int counter = 0;
            currentPosition = i;
            for (int j = 0; j < keyArray.length; j++) {
                if (res.contains(String.valueOf(keyArray[j]))) {
                    counter++;
                }
            }
            if (counter == keyArray.length) {
                break;
            }
            res += strArray[i];
        }
        
        while(res.charAt(0) == res.charAt(1)){
            res = res.substring(1);
        }

        minLen = res.length();
        minString = res;
        for (int i = currentPosition; i < strArray.length; i++) {
            res += strArray[i];
            if (strArray[i] == res.charAt(0)) {
                while (!key.contains(String.valueOf(res.charAt(0)))
                        || (key.contains(String.valueOf(res.charAt(0))) && res.substring(1).contains(String.valueOf(res.charAt(0))))) 
                {
                    //System.out.println(res.charAt(0));
                    res = res.substring(1);
                }         
                    if (minLen > res.length()) {
                        minLen = res.length();
                        minString = res;
                    }              
            }
        }
        
        while(res.charAt(res.length()-1) == res.charAt(res.length()-2)){
            res = res.substring(0, res.length()-1);
        }
        return res;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(smallestSubstringContainingTheAlphabet("abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn", "abcdefghijklmnopqrstuvwxyz"));
    }

}
