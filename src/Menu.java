import java.util.Scanner;
import java.util.Arrays;


public class Menu {
    private String menuHeader;
    private String leadText;
    private String [] menuItems = new String[0];


    public Menu(){};
    public Menu(String menuHeader, String leadText, String [] menuItems){
        setMenuHeader(menuHeader);
        setLeadText(leadText);
        setMenuItems(menuItems);
    }

    public void setMenuHeader(String menuHeader){
        this.menuHeader = menuHeader;
    }

    public void setLeadText(String leadText){
        this.leadText = leadText;
    }

    public void setMenuItems(String[] menuItems){
        this.menuItems = menuItems;
    }

    public void printMenu(){
        int menuSize = menuItems.length;
        System.out.println();
        System.out.println(menuHeader);

        for(int i = 0; i < menuSize; i++){
            System.out.println(menuItems[i]);
        }
    }

    public int readChoice(){
        Scanner scanner = new Scanner(System.in);
        int menuChoice = 0;
        int menuSize = menuItems.length;

        do {
            System.out.println(leadText);
            if (scanner.hasNextInt())
                menuChoice = scanner.nextInt();
            scanner.nextLine();
        }
        while(menuChoice > menuSize || menuChoice < 1);

        return menuChoice;
    }

}

