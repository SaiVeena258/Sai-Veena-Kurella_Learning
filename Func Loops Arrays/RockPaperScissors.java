import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Let's play Rock Paper Scissors.");
        System.out.println("When I say 'Shoot', Choose: rock, paper or scissors.\n");
        System.out.println("Are you ready? Write 'yes' if you are.");
        
        String userChoice = scan.nextLine();

        if(userChoice.equals("yes")){
            System.out.println("Great!");
            System.out.println("rock - paper - scissors, Shoot!");
            String yourChoice = scan.nextLine();
            String computerChoice=computerChoice();
            String result=result(yourChoice, computerChoice);
            printResult(yourChoice, computerChoice, result);
        }else{
            System.out.println("Darn, some other time...!");
        }            

        scan.close();
    }

    public static String computerChoice() {
        int randomChoice=(int) Math.random()*3;
        if(randomChoice==0){
            return "rock";
        }else if(randomChoice==1){
            return "paper";
        }else{
            return "scissors";
        }
    }

    public static String result(String yourChoice, String computerChoice) {
        String result = "";
        if((yourChoice.equals("rock") && computerChoice.equals("scissors")) || (yourChoice.equals("paper") && 
        computerChoice.equals("rock"))  || (yourChoice.equals("scissors") && computerChoice.equals("paper"))){
            result += "You win!!";
        }else if((yourChoice.equals("scissors") && computerChoice.equals("rock" )) || (yourChoice.equals("rock") 
        && computerChoice.equals("paper")) || (yourChoice.equals("paper") && computerChoice.equals("scissors"))){
            result += "You lose...";
        }else if(yourChoice.equals(computerChoice)){
            result += "It's a tie..!";
        }else{
            System.out.println("INVALID CHOICE");
        }
        return result;
    }
 
    public static void printResult(String yourChoice, String computerChoice, String result) {
        System.out.println("You chose: " + yourChoice);
        System.out.println("The computer chose: " + computerChoice);
        System.out.println(result);
    }
}
