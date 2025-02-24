
package internship;
import java.util.Scanner;
public class NUMBER_GAME {

    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("This is a guessing game.\nEnter any number between 1 and 100 and see if youe get it right!");
        System.out.print("Enter your guess: ");
        int num = ValidNumber(input);
        int randomNumber = (int) (Math.random() * 100) + 1;
        boolean condition = true; 
        
        while (condition){
            if (num<randomNumber)
                System.out.println("Your guess is lower than the number.");
            
            else if (num>randomNumber)
                System.out.println("Your guess is Greater than the number.");
   
            else{
                System.out.println("YOU ARE RIGHT!!");
                condition=false;
                break;
            }
        System.out.print("Enter your guess: ");
            num = ValidNumber(input);
        }
        
    }

//______________________________________________________________________________
    public static boolean NumberChecker(String choice){
        
        int length= choice.length();
        int numCount=0;
        int otherCount=0;
        
        for (int i=0; i<length;i++){
            if (Character.isDigit(choice.charAt(i)))
                numCount++;
            else 
                otherCount++;
        }
        
        return (otherCount==0);
     }
//_____________________________________________________________________________ 
public static int ValidNumber(Scanner input){
    String choice = input.next();
    while(!NumberChecker(choice)){
        System.out.print("You should only enter numbers!\nEnter your guess: ");
        choice=input.next();    
        }
        int num = Integer.parseInt(choice);
        return num;
}    
}
