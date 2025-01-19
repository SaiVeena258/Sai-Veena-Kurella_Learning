import java.util.Scanner;

public class Enum {
    public enum TrafficLights{
        RED, GREEN, YELLOW
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter signal color: ");
        String color = sc.nextLine().toUpperCase();
        try{
            TrafficLights trafficLight = TrafficLights.valueOf(color);

            switch(trafficLight){
                case RED: System.out.println("Stop!!"); break;
                case GREEN: System.out.println("Go!!"); break;
                case YELLOW: System.out.println("Slow down!!"); break;
            }
        }catch (IllegalArgumentException e) {
            System.out.println("Invalid signal color. Please enter RED, GREEN or YELLOW.");
        }
        
        

        sc.close();
    }
}