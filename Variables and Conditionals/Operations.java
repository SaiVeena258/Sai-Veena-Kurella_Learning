public class Operations {
    public static void main(String[] args) {

        //Grocery items to be purchased and you have 500 rupees. Calculate the final cash left after purchase if,
        //Bread is 45 rupees. Oats is 90 rupees. Milk is 60 rupees. Egg is 30 rupees. Butter is 120 rupees.
        //You are asked to buy 2 milk bottles, oats 1 packet and eggs based on remaining amount.

        int moneyAvailable=500;
        int oatsPrice=90;
        int milkPrice=60;
        double eggPrice=30.2;

        int moneySpent=((2*milkPrice)+oatsPrice);
        int balance=moneyAvailable-moneySpent;
        int numOfEggs=(balance/(int)eggPrice);
        moneySpent+=numOfEggs*(int)eggPrice;
        int finalBalance=moneyAvailable-moneySpent;
        System.out.println("Final remianing amount: " +finalBalance);
    }
}
