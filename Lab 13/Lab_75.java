/*
    Write a program to simulate music player application using suitable data structure.
    There is no estimation about number of music files to be managed by the music player.
    Your program should support aplaylist the basic music player operations to play and manage the playlist.
 */

import java.util.Scanner;

public class Lab_75 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String_LinkedList playlist = new String_LinkedList();
        int choice=0;
        while (choice!=-1) {
            System.out.println("\nEnter 1 to add song at first position in playlist :");
            System.out.println("Enter 2 to add song at last position in playlist :");
            System.out.println("Enter 3 to add song in ascending order in playlist :");
            System.out.println("Enter 4 to add song at specific position in playlist :");
            System.out.println("Enter 5 to delete song, which is at first position in playlist :");
            System.out.println("Enter 6 to delete song, which is at last position in playlist :");
            System.out.println("Enter 7 to delete song, which is at specific position in playlist :");
            System.out.println("Enter 8 to delete given song in playlist :");
            System.out.println("Enter 9 to delete aplaylist songs in playlist :");
            System.out.println("Enter 10 to check if playlist is empty or not :");
            System.out.println("Enter 11 to display playlist :");
            System.out.println("Enter -1 to exit music player application :");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Number :");
                    String song1=sc.nextLine();
                    playlist.insertAtFirstPosition(song1);
                    break;

                case 2:
                    System.out.println("Enter Number :");
                    String song2=sc.nextLine();
                    playlist.insertAtLastPosition(song2);
                    break;

                case 3:
                    System.out.println("Enter Number :");
                    String song3=sc.nextLine();
                    playlist.insertAtOrder(song3);
                    break;

                case 4:
                    System.out.println("Enter Index :");
                    int index1=sc.nextInt();
                    System.out.println("Enter Number :");
                    String song4=sc.nextLine();
                    playlist.insertAtSpecificPosition(index1, song4);
                    break;

                case 5:
                    playlist.deleteFromFirstPosition();
                    break;

                case 6:
                    playlist.deleteFromLastPosition();
                    break;

                case 7:
                    System.out.println("Enter Index :");
                    int index2=sc.nextInt();
                    playlist.deleteFromSpecificPosition(index2);
                    break;

                case 8:
                    System.out.println("Enter Number :");
                    String song5=sc.nextLine();
                    playlist.deleteGivenDataFromLinkedList(song5);
                    break;

                case 9:
                    playlist.deleteAllMusic_Nodes();
                    break;

                case 10:
                    System.out.println(playlist.isEmpty());
                    break;

                case 11:
                    playlist.displayLinkedList();
                    break;

                case -1:
                    System.out.println("Program Over...");
                    break;

                default:
                    System.out.println("Invalid");
            }
        }
    }
}

class Music_Node {
    public String info;
    public Music_Node link;

    public Music_Node(String data){
        this.info=data;
        this.link=null;
    }

    public Music_Node(String data, Music_Node anotherLink){
        this.info=data;
        this.link=anotherLink;
    }
}

class String_LinkedList{
    Music_Node first=null;

    protected void insertAtFirstPosition(String data){
        Music_Node newMusic_Node=new Music_Node(data);
        newMusic_Node.link=first;
        first=newMusic_Node;
    }

    protected void insertAtLastPosition(String data){
        Music_Node newMusic_Node=new Music_Node(data);
        if(first==null){
            first=newMusic_Node;
            return;
        }
        Music_Node current=first;
        while(current.link!=null){
            current=current.link;
        }
        current.link=newMusic_Node;
    }

    protected void insertAtOrder(String data) {
        Music_Node newMusic_Node = new Music_Node(data);
        if (first == null || newMusic_Node.info.charAt(0) <= first.info.charAt(0)) {
            newMusic_Node.link = first;
            first = newMusic_Node;
            return;
        }
        Music_Node current = first;
        while (current.link != null && newMusic_Node.info.charAt(0) >= current.link.info.charAt(0)) {
            current = current.link;
        }
        newMusic_Node.link = current.link;
        current.link = newMusic_Node;
    }

    // user enters 1 based index :-
    protected void insertAtSpecificPosition(int index, String data) {
        Music_Node newMusic_Node = new Music_Node(data);
        if (index <= 0) {
            System.out.println("Invalid index.");
            return;
        }
        if (index == 1) {
            newMusic_Node.link = first;
            first = newMusic_Node;
            return;
        }
        Music_Node current = first;
        int currentIndex = 1;
        while (current != null && currentIndex < index - 1) {
            current = current.link;
            currentIndex++;
        }
        if (current == null) {
            System.out.println("Index out of bounds.");
            return;
        }
        newMusic_Node.link = current.link;
        current.link = newMusic_Node;
    }

    protected void deleteFromFirstPosition(){
        if(first==null){
            System.out.println("Empty LinkedList...");
            return;
        }
        first=first.link;
    }

    protected void deleteFromLastPosition(){
        if(first==null){
            System.out.println("Empty LinkedList...");
            return;
        }
        if (first.link == null) {
            first = null;
            return;
        }
        Music_Node current=first;
        while(current.link != null && (current.link).link!=null){
            current=current.link;
        }
        current.link=null;
    }

    // user enters 1 based index :-
    protected void deleteFromSpecificPosition(int index) {
        if (first == null) {
            System.out.println("Empty LinkedList...");
            return;
        }
        if (index <= 0) {
            System.out.println("Invalid index.");
            return;
        }
        if (index == 1) {
            first = first.link;
            return;
        }
        Music_Node current = first;
        int currentIndex = 1;
        while (currentIndex < index - 1 && current.link != null) {
            current = current.link;
            currentIndex++;
        }
        if (current.link == null) {
            System.out.println("Index out of bounds.");
            return;
        }
        current.link = current.link.link;
    }

    protected void deleteGivenDataFromLinkedList(String data){
        if(first==null){
            System.out.println("Empty LinkedList...");
            return;
        }
        if(first.info.equals(data)){
            first=first.link;
            return;
        }
        Music_Node current=first;
        while(current.link!=null && !current.link.info.equals(data)){
            current=current.link;
        }
        if(current.link==null){
            System.out.println("No such element in LinkedList...");
            return;
        }
        current.link=(current.link).link;
    }

    protected void deleteAllMusic_Nodes() {
        first=null;
    }

    protected boolean isEmpty() {
        return first==null;
    }

    protected void displayLinkedList() {
        if (first == null) {
            System.out.println("Empty LinkedList...");
            return;
        }
        Music_Node current = first;
        System.out.print("LinkedList : [");
        while (current != null) {
            System.out.print(current.info);
            if (current.link != null) {
                System.out.print(", ");
            }
            current = current.link;
        }
        System.out.println("]");
    }
}