/*
     Design anagram game using array.
     Allow a user to enter N words and store it in an array.
     Generate a random number between 0 to N-1.
     Based on the random number generated display the word stored at that
     index of an array and allow user to enter its anagram.
     Check whether the word entered by the user is an anagram of displayed
     number or not and display an appropriate message.
     Given a word A and word B. B is said to be an anagram of A if and only if
     the characters present in B is same as characters present in A,
     irrespective of their sequence. For ex: “LISTEN” == “SILENT”
 */

import java.util.*;

public class Lab_32 {
     public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          System.out.println("How many words will you enter :");
          int n=sc.nextInt();
          String[] words=new String[n];
          for(int i=0;i<words.length;i++){
               System.out.println("Enter word "+(i+1)+" :");
               words[i]=sc.next();
          }
          int random=(int)(Math.random()*(n));
          System.out.println("Enter anagram of this word "+words[random]+" :");
          String anagram=sc.next();
          Anagram anag=new Anagram();
          if(anag.isAnagram(anagram, words[random])){
              System.out.println("\nAnagram");
          }
          else{
               System.out.println("\nNot Anagram");
          }
     }
}

class Anagram{
     protected boolean isAnagram(String word1 ,String word2){
          if (word1.length()!=word2.length()) {
               return false;
          }
          char[] char1=word1.toCharArray();
          char[] char2=word2.toCharArray();
          Arrays.sort(char1);
          Arrays.sort(char2);
          return Arrays.equals(char1, char2);
     }
}