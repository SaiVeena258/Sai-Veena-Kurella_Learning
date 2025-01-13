import java.util.Scanner;
public class Details{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name=sc.nextLine();
        System.out.println("Enter your age:");
        int age=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your city:");
        String city=sc.nextLine();
        System.out.println("Enter your state:");
        String state=sc.nextLine();
        System.out.println("Enter your country:");
        String country=sc.nextLine();
        sc.close();
        System.out.println("Hello " + name + "! So you are of " + age + " years old. You are from "+ city +" "+ state +" "+ country);
    }
}