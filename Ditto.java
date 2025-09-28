import java.io.*;
import java.util.*;
// Core JavaFX application classes
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

// UI controls
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

// Layout panes
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;

// Event handling
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// FXML related classes
import javafx.fxml.FXMLLoader;

// Graphics and media
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

// Geometry and positioning
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Ditto {
    public Scanner bob;

    public Ditto(Scanner bob) {
        System.out.println("Welcome to Ditto: the social game by Shelby Marshall \nWhat would you like to do?\n[1] " +
        "- Play Default Game\n[2] - Build your own game\n[3] - Go to the wrong Florida " +
        "\n[4] - Add to Ditto Bank\n[5] - Upload From Filek\n[7] - Quit");
        System.out.println();
        int option = bob.nextInt();
        while ( option != 7 ) {
            if ( option == 1 ) {
                defaultGame();
            } else if ( option == 2 ) {
                buildGame(bob);
            } else if ( option == 3 ) {
                callShelby();
            } else if ( option == 4 ) {
                dittoBank(bob);
            } else if ( option == 5 ) {
                upload();
            } else { throw new IllegalArgumentException(" Value must be between 1 and 10");
            }
            option = bob.nextInt();
        }
    }  

    public void defaultGame() {
        System.out.print("Volunteers with the American Cancer Society     ");
        System.out.print("|     Completed a marathon      |");
        System.out.println("    Has a favorite Burger at Bareburger");
        System.out.print("Is an Artist      ");
        System.out.print("        |                  DITTO               |           ");
        System.out.println("Speaks More Than 2 Languages        ");
        System.out.print("Attended a Greenwich YAG Event this Year      ");
        System.out.print("|      Lived in New York City      |");
        System.out.println("        Has their own Business");
        System.out.println();
    }

    public void buildGame(Scanner bob) {
        System.out.println("Please enter 8 Dittos");
        System.out.println();
        int boardOptions = 8;
        TreeMap<Integer, String> dittoTree = new TreeMap<>();
        bob.nextLine();
        for (int i = 0; i < boardOptions; i++) {
            dittoTree.put(i, bob.nextLine());
        }
        //dittoTree.put(5, "DITTO");
        //System.out.println(dittoTree);
        //System.out.println(makeBoard(dittoTree));
        TreeMap<Integer, String> pringle = (makeBoard(dittoTree));
    }

    public void callShelby() {
        System.out.println("SHELBY IS A POOPY PANTS!!");
    }

    public void dittoBank(Scanner bob) {
        TreeSet<String> dittoSet = new TreeSet<>();
        System.out.println("Would you like to add another Ditto to Ditto Bank?");
        System.out.println();
        String response = bob.nextLine();
        while (!response.equalsIgnoreCase("yes")) {
            System.out.println("Please add your ditto");
            System.out.println();
            dittoSet.add(bob.nextLine());
            System.out.println("Would you like to add another Ditto to Ditto Bank?");
            response = bob.next(); 
        }
        //System.out.println(dittoSet);
    }

    public void upload() {
        try { 
            String filePath = "DittoCard.txt";
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println("poo");
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found:");
        }
        //BufferedReader reader = new BufferedReader(new FileReader(filePath));

    }

    public void print() {
        System.out.println("Here is your Ditto Board    -   ENJOY!");

    }

    public TreeMap<Integer, String> makeBoard(Map<Integer, String> rawBoard) {
        TreeMap<Integer, String> refinedBoard = new TreeMap<>();
        for (Integer poop : rawBoard.keySet()) {
            Integer poopStorage = poop;
            String valueStorage = rawBoard.get(poop);
            if (poop < 4 ) {
                refinedBoard.put(poop - 1, rawBoard.get(poop));
            }
        }
        refinedBoard.put(3, "DITTO");
        //System.out.println(refinedBoard);    
        for (Integer cheese : rawBoard.keySet()) {
            if ( cheese >= 4 ) {
                refinedBoard.put(cheese, rawBoard.get(cheese));
            }
        }
        //System.out.println(refinedBoard); 
        for (int j = -1; j < refinedBoard.size() -1 ; j += 3) {
            System.out.println();
            System.out.print(refinedBoard.get(j) + "      ");
            System.out.print("|     " + refinedBoard.get(j + 1) + "      |");
            System.out.println("        " + refinedBoard.get(j + 2));
        }
        return refinedBoard;
    }
}


