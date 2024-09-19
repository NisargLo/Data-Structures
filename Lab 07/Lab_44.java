/*
    Solve - https://www.codechef.com/problems/VOWANX

    Vowel Anxiety

    Utkarsh has recently started taking English-language classes to improve his reading and writing skills.
    However, he is still struggling to learn English.
    His teacher gave him the following problem to improve his vowel-identification skills:

    There is a string S of length N consisting of lowercase English letters only.
    Utkarsh has to start from the first letter of the string.
    Each time he encounters a vowel (i.e. a character from the set {a,e,i,o,u}) he has to reverse the entire substring that came before the vowel.

    Utkarsh needs help verifying his answer.
    Can you print the final string after performing all the operations for him?

    Input Format
        First line will contain T, number of test cases. Then T test cases follow.
        The first line of each test case contains N, the length of the string.
        The second line contains S, the string itself.

    Output Format
        For each test case, output in a single line the final string after traversing S from left to right and performing the necessary reversals.

    Constraints
        1 ≤ T ≤ 10^4
        1 ≤ N ≤ 10^6
        Sum of N over all test cases does not exceed 10^6.

    Input
        2
        10
        abcdefghij
        7
        bcadage

    Output
        hgfeabcdij
        gacbade

    Explanation:
        Test case 1: The first letter is a vowel, but there is no substring before it to reverse, so we leave it as it is. Next, we reverse abcd and the string becomes dcbaefghij.
                    Next we reach the vowel i and reverse dcbaefgh to get the string hgfeabcdij.
        Test case 2: Initially, we reverse bc and the string becomes cbadage.
                    Next we reach the vowel a and reverse cbad to get the string dabcage.
                    Finally we reach the vowel e and reverse dabcag to get the string gacbade.
 */

import java.util.*;
import java.io.*;

public class Lab_44{
    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            try {
                br = new BufferedReader(new FileReader("input.txt"));
                PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
                System.setOut(out);
            }
            catch (Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        StringBuilder sb = new StringBuilder();
        int t = reader.nextInt();
        while (t-- > 0) {
            int n = reader.nextInt();
            String s = reader.nextLine();
            char[] fin = new char[n];
            int start = 0, end = n-1;
            int ptr = n-1;
            boolean from_last = true;
            char c;
            while(ptr>=0){
                c = s.charAt(ptr);
                ptr--;
                if(from_last){
                    fin[end] = c;
                    end--;
                }
                else{
                    fin[start] = c;
                    start++;
                }
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                    from_last = !from_last;
                }
            }
            for(char e: fin){
                sb.append(e);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}