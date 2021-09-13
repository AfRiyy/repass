import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        aboutShow();
        String[] profileArray = inputProfile();
        boolean success = writeProfile(profileArray);
        writeSuccess(success);
    }

    public static void aboutShow() {
        System.out.println("Nagy János");
        System.out.println("Jelszavak");
        System.out.println("Verzió: 0.0.1");
    }

    public static String input(String msg){
        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);
        String inputStr = scanner.nextLine();
        return inputStr;   
    }
    public static String[] inputProfile(){
       String user = input("Felhasználónév: ");
       String pass = input("Jelszó: ");
       String place = input("Hely: ");
       String[] array = {user,pass,place};
       return array;
    }
    public static void writeSuccess(boolean success){
        if (success) {
            System.out.println("Ok. A kiírás sikeres.");
        } else {
            System.out.println("Hiba! A kiírás sikertelen");
        }
    }
    public static boolean writeProfile(String[] profileArray){
        try {
            tryWriteProfile(profileArray);
            return true;
        } catch (IOException ex) {
            System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
            return false;
        }
    }
    public static void tryWriteProfile(String[] profileArray) throws IOException{
        Profile profile = new Profile(profileArray);
        FileWriter fileWriter = new FileWriter("pass.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(profile.getUser()+" ");
        if (!profile.isPassEmpty()) {
            printWriter.print(profile.getPass()+" ");
        }
        printWriter.print(profile.getPlace()+" ");
        printWriter.close();
    }
}
