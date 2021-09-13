import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    private static Scanner scan;
    private static  String user;
    private static  String pass;
    private static  String place;
    public static void main(String[] args) {
        aboutShow();
        scan = new Scanner(System.in); 
        setUser();
        setPass();
        setPlace();
        scan.close();
        int isSucceed = 0;
        
        if (isSucceed == 1) {
            System.out.println("Ok. A kiírás sikeres.");
        } else {
            System.out.println("Hiba! A kiírás sikertelen");
        }

    }

    public static void aboutShow() {
        System.out.println("Nagy János");
        // Fejrész kiírása
        System.out.println("Jelszavak");
        // Verzió kiírása
        System.out.println("Verzió: 0.0.1");
    }
    public static void setUser(){
        System.out.print("Felhasználónév: ");
        user = scan.nextLine();
    }
    public static void setPass(){
        System.out.print("Jelszó: ");
        pass = scan.nextLine();
    }
    public static void setPlace(){
        System.out.print("Hely: ");
        place = scan.nextLine();
    }
    public static void profileWriteOut(){
        try {
            /*
             * A jelszó, a felhasználónév és a használati helye a passList objektumban van
             * tárolva
             */
            Profile profile = new Profile(user, pass, place);
            FileWriter fileWriter = new FileWriter("pass.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(profile.user);
            if (!profile.isPassEmpty()) {
                printWriter.print(profile.getPass());
            }
            printWriter.print(profile.place);
            printWriter.close();
            isSucceed = 1;
        } catch (IOException ex) {
            System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
        }
    }
}
