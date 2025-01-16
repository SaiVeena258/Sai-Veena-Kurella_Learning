package OOPs_Part1.Mutable_Immutable;
public class Books {
    private String name;

    public Books(String name) {
        this.name=name;
    }

    public Books(Books source){
        this.name=source.name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }
}
