/*
    Write a program to simulate music player application using suitable data structure.
    There is no estimation about number of music files to be managed by the music player.
    Your program should support all the basic music player operations to play and manage the playlist.
 */

import java.util.Scanner;

public class Lab_75 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String_LinkedList playlist = new String_LinkedList();
        int choice=0;
        String song;
        int index;
        while (choice!=-1) {
            System.out.println("\nEnter 1 to play next song from playlist :");
            System.out.println("Enter 2 to play previous song from playlist :");
            System.out.println("Enter 3 to add song at first position in playlist :");
            System.out.println("Enter 4 to add song at last position in playlist :");
            System.out.println("Enter 5 to add song in ascending order in playlist :");
            System.out.println("Enter 6 to add song at specific position in playlist :");
            System.out.println("Enter 7 to delete song, which is at first position in playlist :");
            System.out.println("Enter 8 to delete song, which is at last position in playlist :");
            System.out.println("Enter 9 to delete song, which is at specific position in playlist :");
            System.out.println("Enter 10 to delete given song in playlist :");
            System.out.println("Enter 11 to delete all songs in playlist :");
            System.out.println("Enter 12 to check if playlist is empty or not :");
            System.out.println("Enter 13 to display playlist :");
            System.out.println("Enter -1 to exit music player application :");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    playlist.playNext();
                    break;

                case 2:
                    playlist.playPrevious();
                    break;

                case 3:
                    System.out.println("Enter song :");
                    song=sc.nextLine();
                    playlist.insertAtFirstPosition(song);
                    break;

                case 4:
                    System.out.println("Enter song :");
                    song=sc.nextLine();
                    playlist.insertAtLastPosition(song);
                    break;

                case 5:
                    System.out.println("Enter song :");
                    song=sc.nextLine();
                    playlist.insertAtOrder(song);
                    break;

                case 6:
                    System.out.println("Enter Index :");
                    index=sc.nextInt();
                    System.out.println("Enter song :");
                    song=sc.nextLine();
                    playlist.insertAtSpecificPosition(index, song);
                    break;

                case 7:
                    playlist.deleteFromFirstPosition();
                    break;

                case 8:
                    playlist.deleteFromLastPosition();
                    break;

                case 9:
                    System.out.println("Enter Index :");
                    index=sc.nextInt();
                    playlist.deleteFromSpecificPosition(index);
                    break;

                case 10:
                    System.out.println("Enter song :");
                    song=sc.nextLine();
                    playlist.deleteGivenDataFromLinkedList(song);
                    break;

                case 11:
                    playlist.deleteAllString_Nodes();
                    break;

                case 12:
                    System.out.println(playlist.isEmpty());
                    break;

                case 13:
                    playlist.displayLinkedList();
                    break;

                case -1:
                    System.out.println("Music Player Program Over...");
                    break;

                default:
                    System.out.println("Invalid");
            }
        }
    }
}

class String_Node {
    String info;
    String_Node link;

    public String_Node(String data){
        this.info=data;
    }
}

class String_LinkedList{
    String_Node first=null;
    String_Node playPosition=null;

    protected void playNext() {
        if (playPosition==null) {
            if (first == null) {
                System.out.println("Empty playlist...");
                return;
            }
            playPosition = first;
            System.out.println("Now playing: " + playPosition.info);
            return;
        }
        if (playPosition.link == null) {
            System.out.println("End of playlist reached.");
            return;
        }
        playPosition = playPosition.link;
        System.out.println("Now playing: " + playPosition.info);
    }

    protected void playPrevious() {
        if (playPosition==null) {
            if (first == null) {
                System.out.println("Empty playlist...");
                return;
            }
            playPosition = first;
            System.out.println("Now playing: " + playPosition.info);
            return;
        }
        if (playPosition == first) {
            System.out.println("Already at the beginning of the playlist.");
            return;
        }
        String_Node previous = first;
        while (previous.link != playPosition) {
            previous = previous.link;
        }
        playPosition = previous;
        System.out.println("Now playing: " + playPosition.info);
    }

    protected void insertAtFirstPosition(String data){
        String_Node newString_Node=new String_Node(data);
        newString_Node.link=first;
        first=newString_Node;
    }

    protected void insertAtLastPosition(String data){
        String_Node newString_Node=new String_Node(data);
        if(first==null){
            first=newString_Node;
            return;
        }
        String_Node current=first;
        while(current.link!=null){
            current=current.link;
        }
        current.link=newString_Node;
    }

    protected void insertAtOrder(String data) {
        String_Node newString_Node = new String_Node(data);
        if (first == null || newString_Node.info.toLowerCase().charAt(0) <= first.info.toLowerCase().charAt(0)) {
            newString_Node.link = first;
            first = newString_Node;
            return;
        }
        String_Node current = first;
        while (current.link != null && newString_Node.info.toLowerCase().charAt(0) >= current.link.info.toLowerCase().charAt(0)) {
            current = current.link;
        }
        newString_Node.link = current.link;
        current.link = newString_Node;
    }

    // user enters 1 based index :-
    protected void insertAtSpecificPosition(int index, String data) {
        String_Node newString_Node = new String_Node(data);
        if (index <= 0) {
            System.out.println("Invalid index.");
            return;
        }
        if (index == 1) {
            newString_Node.link = first;
            first = newString_Node;
            return;
        }
        String_Node current = first;
        int currentIndex = 1;
        while (current != null && currentIndex < index - 1) {
            current = current.link;
            currentIndex++;
        }
        if (current == null) {
            System.out.println("Index out of bounds.");
            return;
        }
        newString_Node.link = current.link;
        current.link = newString_Node;
    }

    protected void deleteFromFirstPosition(){
        if(first==null){
            System.out.println("Empty playlist...");
            return;
        }
        first=first.link;
    }

    protected void deleteFromLastPosition(){
        if(first==null){
            System.out.println("Empty playlist...");
            return;
        }
        if (first.link == null) {
            first = null;
            return;
        }
        String_Node current=first;
        while(current.link != null && (current.link).link!=null){
            current=current.link;
        }
        current.link=null;
    }

    // user enters 1 based index :-
    protected void deleteFromSpecificPosition(int index) {
        if (first == null) {
            System.out.println("Empty playlist...");
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
        String_Node current = first;
        int currentIndex = 1;
        while (currentIndex < index - 1 && current.link != null) {
            current = current.link;
            currentIndex++;
        }
        if (current.link == null) {
            System.out.println("Invalid index.");
            return;
        }
        current.link = current.link.link;
    }

    protected void deleteGivenDataFromLinkedList(String data){
        if(first==null){
            System.out.println("Empty playlist...");
            return;
        }
        if(first.info.equals(data)){
            first=first.link;
            return;
        }
        String_Node current=first;
        while(current.link!=null && !current.link.info.equals(data)){
            current=current.link;
        }
        if(current.link==null){
            System.out.println("No such element in playlist...");
            return;
        }
        current.link=(current.link).link;
    }

    protected void deleteAllString_Nodes() {
        first=null;
    }

    protected boolean isEmpty() {
        return first==null;
    }

    protected void displayLinkedList() {
        if (first == null) {
            System.out.println("Empty playlist...");
            return;
        }
        String_Node current = first;
        System.out.print("Playlist : [");
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