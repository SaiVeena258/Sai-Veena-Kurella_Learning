package OOPs_Part1.Mutable_Immutable;

public class Main {
    public static void main(String[] args) {
    
        Integer immutable1 = 10;
        Integer immutable2=immutable1;
        immutable2=20;   
        System.out.println(immutable1);
        System.out.println(immutable2);
        System.out.println("-----------------------------------");
        Books book1=new Books("Too Good to be True!");
        Books book2=new Books(book1);
        book1.setName("Jane Eyre");;
        book2.setName("Pride and Prejudice");
        System.out.println(book1.getName());
        System.out.println(book2.getName());

    }

    
}
