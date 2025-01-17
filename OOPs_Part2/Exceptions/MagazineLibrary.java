import java.util.ArrayList;

public class MagazineLibrary {
    private ArrayList<Magazine> magazines;

    public MagazineLibrary() {
        this.magazines = new ArrayList<>();
    }
    
    public Magazine getMagazine(int index){
        Magazine magazine = magazines.get(index);
        Magazine copy=new Magazine(magazine);
        return copy;
    }

    public void setMagazine(Magazine magazine, int index){
        Magazine copy=new Magazine(magazine);
        this.magazines.set(index, copy);
    }

    public void addMagazine(Magazine magazine){
        Magazine copy=new Magazine(magazine);
        this.magazines.add(copy);
    }
}
