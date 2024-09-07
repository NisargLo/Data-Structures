// Caesar Cipher Method

import java.util.Scanner;

public class Cryptography {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Text :");
        String plaintext=sc.nextLine();
        System.out.println("Enter Caesar Cipher (K) :");
        int K=sc.nextInt();
        Caesar_Cipher_Method ccm=new Caesar_Cipher_Method(plaintext, K);
        System.out.println("Encrypt or Decrypt?");
        String choose=sc.next().trim();
        ccm.display(choose);
    }
}

class Caesar_Cipher_Method{
    private final char[] charArry;
    private final byte K;

    private byte calculateK(int K){
        K %= 26;
        return (byte)K;
    }

    Caesar_Cipher_Method(String text, int K){
        this.charArry=text.toCharArray();
        if(K>26 || K<-26){
            this.K=calculateK(K);
        }
        else{
            this.K=(byte)K;
        }
    }

    private String encryption(){
        for (int i=0;i<this.charArry.length;i++) {
            this.charArry[i]=(char)(this.charArry[i]+K);
        }
        return new String(this.charArry);
    }

    private String decryption(){
        for (int i=0;i<this.charArry.length;i++) {
            this.charArry[i]=(char)(this.charArry[i]-K);
        }
        return new String(this.charArry);
    }

    protected void display(String choose){
        if(choose.equalsIgnoreCase("Encrypt")){
            System.out.println("Ciphertext - "+encryption());
        }
        else if(choose.equalsIgnoreCase("Decrypt")){
            System.out.println("Plaintext - "+decryption());
        }
        else{
            System.out.println("Invalid");
        }
    }
}