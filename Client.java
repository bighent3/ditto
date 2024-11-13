import java.io.*;
import java.util.*;

public class Client {
    public Client() {
    }

    public static void main(String[] args) {
        Scanner bob = new Scanner(System.in);
        Ditto shelby = new Ditto(bob);
        shelby.defaultGame();
    }
    
}