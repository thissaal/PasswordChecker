
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PasswordTester {

    public static boolean validPasswd = false;
    public static boolean unqiuePasswd = false;

    public static void doesExist(String password) throws FileNotFoundException{

        File rockyou = new File("resources/rockyou.txt");
        Scanner scanFile = new Scanner(rockyou);
        boolean found = false;
    
        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            if (line.equals(password)) {
                System.out.println("WARNING: Common Password Found!");
                found = true;
                break;
            }
        } 
            
            unqiuePasswd = !found;

    }

    public static void passwordRepeater(String password){
        boolean hasSymbol = false;
        boolean isUpper = false;
        boolean hasNumbers = false;
        boolean secureLength = false;


        char[] characters = password.toCharArray();
        if (characters.length >= 10){
            secureLength = true;
        } 

        for (int i=0;i<characters.length;i++)
        {
            if(Character.isUpperCase(characters[i])) {
                isUpper = true;
            }

            else if(Character.isDigit(characters[i])){
                hasNumbers = true;
            }

            else if(!Character.isLetterOrDigit(characters[i])){
                hasSymbol = true;
            }

        }

        System.out.println("");
        if (isUpper && hasNumbers && hasSymbol && secureLength) {
            System.out.println("Password is valid!");
            validPasswd = true;
        } 
        else 
        {
            if (!isUpper) {
                System.out.println("- Please add at least 1 Uppercase!");
            }
            if (!hasNumbers) {
                System.out.println("- Please add a Number!");
            }
            if (!hasSymbol) {
                System.out.println("- Please add a Symbol! (e.g #,%,&)");
            }
            if (!secureLength) {
                System.out.println("- Password is not long enough (min: 10 char)");
            }
        }
        System.out.println("");

        
    }

    public static void openScreen(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("     _____                                    _        _               _             ");
        System.out.println("    |  __ \\                                  | |      | |             | |            ");
        System.out.println("    | |__) |_ _ ___ _____      _____  _ __ __| |   ___| |__   ___  ___| | _____ _ __ ");
        System.out.println("    |  ___/ _` / __/ __\\ \\ /\\ / / _ \\| '__/ _` |  / __| '_ \\ / _ \\/ __| |/ / _ \\ '__|");
        System.out.println("    | |  | (_| \\__ \\__ \\\\ V  V / (_) | | | (_| | | (__| | | |  __/ (__|   <  __/ |   ");
        System.out.println("    |_|   \\__,_|___/___/ \\_/\\_/ \\___/|_|  \\__,_|  \\___|_| |_|\\___|\\___|_|\\_\\___|_|  ");
        System.out.println("");
        System.out.println("");
        
        System.out.println("----------------------------------------TOOLS----------------------------------------");
        System.out.println("");
        System.out.println("1 ----- Password Checker");
        System.out.println("2 ----- Password Hasher");
        System.out.println("3 ----- Quit");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("");
                                                                                  

    }

    public static void PasswordGenerator() {
        boolean Symbol = false;
        boolean Upper = false;
        boolean Numbers = false;
        int Length = (int)(Math.random() * 5) + 11;

        char[] lowercaseLetters = {
            'a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z'
        };

        char[] uppercaseLetters = {
            'A','B','C','D','E','F','G','H','I','J','K','L','M',
            'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
        };

        char[] digits = {'0','1','2','3','4','5','6','7','8','9'};

        char[] specialChars = {
            '!','@','#','$','%','^','&','*','(',')','-','_','+','=','[',']','{','}',';',':','<','>','?','/'
        };

        char[][] passwordGroups = {lowercaseLetters, uppercaseLetters, digits, specialChars};
        char[] passWord = new char[Length];

        for(int i = 0; i < Length;i++){
            char[] selectedValue = passwordGroups[(int)(Math.random() * passwordGroups.length)];
            passWord[i] = selectedValue[(int)(Math.random() * selectedValue.length)];
        }
        System.out.println("");
        System.out.println("Welcome to Password tool!");
        System.out.println("");
        System.out.println("Your Password is: " + new String(passWord));
        System.out.println("");
    }


    public static void main(String[] args) throws FileNotFoundException {

        boolean running = true;
        Scanner dotoday = new Scanner(System.in);  

        while(running){
            openScreen();
            System.out.print("What Would you like to do today? ");
            String doToday = dotoday.nextLine();  

            switch(doToday) {
                case "1":
                    while (validPasswd == false || unqiuePasswd == false)
                    {
                        Scanner myPwd = new Scanner(System.in);  
                        System.out.print("Enter Password: ");
                        String myPasswd = myPwd.nextLine();  
                        doesExist(myPasswd);
                        passwordRepeater(myPasswd);
                    }

                    System.out.print("Press [Enter] to return to the menu: ");
                    dotoday.nextLine();
                    validPasswd = false;
                    unqiuePasswd = true;
                    break;

                case "2":
                
                    PasswordGenerator(); 
                    System.out.print("Press [Enter] to return to the menu: ");
                    dotoday.nextLine();
                    break;
                    

                case "3":
                    System.out.println("Exiting... Have a great day!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Try again.\n");
                    
            }
        }
         
	}


}
