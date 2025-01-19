import static java.lang.Math.*;
import java.util.Scanner;

public class Static{

    public static final int MIN_AGE=18;
    public static void main(String[] args) {
        System.out.println(PI*PI);
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age=sc.nextInt();
        if(age>=MIN_AGE){
            System.out.println("Hey!! You can vote...");
        }else{
            System.out.println("Minimum age is " + MIN_AGE);
        }
        sc.nextLine();
        sc.close();
    }
}