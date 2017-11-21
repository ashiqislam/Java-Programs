/**
 * Word Counter
 * Created by (Ashiq) Asiqul Hoque
 */

import java.util.Scanner;
    public class WordCounter {
        public static void main(String args[]){
            Scanner in=new Scanner(System.in);
            System.out.println("Enter a sentence:");
            String sentence=in.nextLine();
            int result=count(sentence);
            System.out.println("Number of words in this sentence: "+ result);
        }

        private static int count(String sentence) { //count method
            int count=0;
            if(sentence.charAt(0)!=' '){
                count++;
            }
            for(int i=0;i<sentence.length();i++){
                if((sentence.charAt(i)==' ')){
                    count++;
                }
            }
            return count;
        }
}