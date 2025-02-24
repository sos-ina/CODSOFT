
package internship;
import java.util.Scanner;
public class STUDENT_GRADE_CALCULATOR {
    public static void main(String[] args) {
        System.out.print("Enter the number of subjects: ");
        Scanner input= new Scanner(System.in);
        double num = ValidNumber(input);
        double sum = 0;
        
        double[] subject= new double[(int)num];
        for(int i=0;i<num;i++){
           System.out.print("Score for subject "+(i+1)+ ":"); 
           subject [i]= ValidNumber(input);
           
           sum= sum+subject[i];
        }
        
        double average= sum/num;
        System.out.println("Total: "+ sum);
        System.out.println("Average: "+ average);
        
        if(average >= 90)
            System.out.println("Grade: A");
        else if(average>=85)
            System.out.println("Grade: B+");
        else if(average>=80)
            System.out.println("Grade: B");
        else if(average>=75)
            System.out.println("Grade: C+");
        else if(average>=70)
            System.out.println("Grade: C");
        else if(average>=65)
            System.out.println("Grade: D+");
        else if(average>=60)
            System.out.println("Grade: D");
        else
            System.out.println("Grade: F"); 
                
    
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
//______________________________________________________________________________ 
    public static double ValidNumber(Scanner input){
    String choice = input.next();
    while(!NumberChecker(choice)){
        System.out.print("You should only enter numbers!\nEnter the correct input: ");
        choice=input.next();    
        }
        
        int num = Integer.parseInt(choice);
        return (double)num;
}    
}
