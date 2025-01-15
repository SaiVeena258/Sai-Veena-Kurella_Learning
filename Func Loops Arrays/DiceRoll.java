import java.util.Scanner;

public class DiceRoll {
    public static void main(String[] args) {
        
        int roll1=diceRolls();
        int roll2=diceRolls();
        int roll3=diceRolls();

        System.out.println("Actual rolls are: "+ roll1 + " " + roll2 + " " + roll3);
        int actualSum=roll1+roll2+roll3;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number between 1 and 6: ");

        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();

        sc.nextLine();
        sc.close();

        int obtainedSum=num1+num2+num3;

        boolean correctParam1=moreThan0(num1, num2, num3);
        boolean correctParam2=lessThan7(num1, num2, num3);

        if(correctParam1 && correctParam2){
            if(userWon(actualSum,obtainedSum)){
                System.out.println("You Won!!");
            }else{
                System.out.println("Sorry! Better try next time...");
            }
        }else{
            System.out.println("Invalid input");
        }
        
        System.out.println("Your Sum: " + obtainedSum + " Computer Sum: " + actualSum );
       
    }
    public static int diceRolls(){
        return (int)(Math.random()*6 +1);
    }

    public static boolean moreThan0(int num1,int num2,int num3){
        return (num1>0 && num2>0 && num3>0);
    }

    public static boolean lessThan7(int num1,int num2,int num3){
        return(num1<7 && num2<7 && num3<7);
    }
    
    public static boolean userWon(int actualSum,int obtainedSum){
        return ((actualSum>obtainedSum) && (actualSum-obtainedSum<=3));
        }
}
