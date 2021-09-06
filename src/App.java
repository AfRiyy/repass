import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        nevjegy();
        //Fejrész kiírása
        System.out.println("Jelszavak");
        //Verzió kiírása
        System.out.println("Verzió: 0.0.1");
        
        //Az a objektummal kérhetünk be a konzolról
        Scanner scan = new Scanner(System.in); //az a nem megfelelő változónév

        System.out.print("Felhasználónév: ");
        // A b változó tárolja a jelszót
        String username = scan.nextLine();//a b nem megfelelő változónév
        System.out.print("Jelszó: ");
        String pass = scan.nextLine();//a c nem megfelelő változónév
        System.out.print("Hely: ");
        String place = scan.nextLine(); //a d nem megfelelő változónév
        scan.close(); 
        int isSucceed = 0;
        try {
            /* 
            A jelszó, a felhasználónév és a 
            használati helye a passList 
            objektumban van tárolva            
            */
            Store passList = new Store(username, pass, place);
            FileWriter fileWriter = new FileWriter("pass.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(passList.user);
            if(!passList.hollow()) { printWriter.print(passList.retrieval()); }
            printWriter.print(passList.place);
            printWriter.close();
            isSucceed = 1;
        } catch (IOException ex) {
            System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
        }

        if(isSucceed == 1) { 
            System.out.println("Ok. A kiírás sikeres.");  
        }
        else {  
            System.out.println("Hiba! A kiírás sikertelen"); 
        }

    }

    public static void nevjegy() {
        System.out.println("Nagy János");
    }
}
