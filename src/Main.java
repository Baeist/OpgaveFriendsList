import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static boolean running = true;
    ArrayList<Friend> friends = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        Main main = new Main();

        while(running){
            main.run();
        }
    }

    public void run(){
        Friend newFriend = new Friend();

        String [] menuItems = {"1: Show list of friends.", "2: Enter new Friend.",
                "3: Delete friend.", "4: Save list.", "5: Load list.", "6: Exit program."};
        int choice;

        Menu menu = new Menu("Menu oversigt", "Angiv dit menuvalg:", menuItems);

        menu.printMenu();
        choice = menu.readChoice();
        switch(choice){
            case 1 :
                showListOfFriends(friends);
                break;
            case 2 :
                enterNewFriend();
                break;
            case 3 :
                deleteFriend();
                break;
            case 4 :
                saveList();
                break;
            case 5 :
                loadList();
                break;
            case 6 :
                exit();
                break;
        }
        }

        public static void exit(){
        running = false;
        }

        public void showListOfFriends(ArrayList<Friend> friends){
        for(int i = 0; i < friends.size(); i++){
        System.out.println((i + 1) + ":\nName: " + friends.get(i).getName() + "\nPhone number: " + friends.get(i).getPhone() + " Email: " + friends.get(i).getEmail());
        }
        }

        public void enterNewFriend(){
          String name;
          String phone;
          String email;

          name = userInput("Name:");
          phone = userInput("Phone number:");
          email = userInput("Email:");

          Friend newFriend = new Friend(name, phone, email);

          friends.add(newFriend);
        }

        public void deleteFriend(){
        showListOfFriends(friends);
        try{
        friends.remove((userInputInt("Which of your friends would you like to delete from the list? (index number)") - 1));
        }
        catch(Exception e){
            System.out.println("Your list of friends does not include that number.");
        }
        }

        public String userInput(String prompt){

            System.out.println(prompt);
            return scanner.nextLine();

        }
        public int userInputInt(String prompt){

        System.out.println(prompt);
        int x = 0;
        boolean check = true;
        do{
            if(scanner.hasNextInt()){
                x = scanner.nextInt();
                check = false;
            }
            scanner.nextLine();
        }while(check);

        return x;

    }

    public void saveList() {
        try {
            PrintStream list = new PrintStream("friends.txt");

            for (int i = 0; i < friends.size(); i++) {
                list.println(friends.get(i).getName() + " " + friends.get(i).getPhone() + " " + friends.get(i).getEmail());
            }
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }

    public void loadList(){
        try{
        Scanner load = new Scanner(new File("friends.txt"));
            do{
                String name;
                String phone;
                String email;
                name = load.next();
                phone = load.next();
                email = load.next();

                Friend newFriend = new Friend(name, phone, email);

                friends.add(newFriend);
            }
            while(load.hasNext());
        }
        catch (Exception e){
            System.out.println("File not found.");
        }

    }

    }


