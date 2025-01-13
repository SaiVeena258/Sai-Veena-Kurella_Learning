import java.util.Scanner;
public class Conditions {
    public static void main(String[] args) {
        
        //You have 3 days of office work. You have to go to office on Monday, Tuesday and Wednesday.
        //Based on your login time and other contidions you will have a feedback.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the day:");
        String day = sc.nextLine();
        System.out.println("Enter the login time:");
        int loginTime = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the logout time:");
        int logoutTime = sc.nextInt();
        sc.nextLine();
        Boolean regular=true;
        sc.close();

        switch(day){
            case "Monday": 
                if((loginTime<=9 && logoutTime>=17) || regular){
                    System.out.println("Good job");
                }else{
                System.out.println("Try to be in time");}
                break;
            case "Tuesday": 
                if((loginTime>11 && logoutTime<=17) || regular){
                    System.out.println("Try to work more!");
                }else{
                    System.out.println("Your performance is not too good.");}
                break;
            case "Wednesday": 
                if((loginTime>12 && logoutTime>=17) || regular){
                    System.out.println("You need to be more punctual.");
                }else{
                    System.out.println("Your performance is bad.");}
                break;
            default:System.out.println("It's work from home today...");
                break;
        }
    }
}
