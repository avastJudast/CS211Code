import java.util.ArrayList;
public class MatchableContainer<Generic>{
    ArrayList elements;
    public MatchableContainer(){
        elements = new ArrayList<Generic>();
    }
    public MatchableContainer(ArrayList elements){
        this.elements = new ArrayList<Generic>();
        this.elements.addAll(elements);
    }
    public void set(ArrayList elements){
        this.elements.clear();
        this.elements.addAll(elements);
    }
    public ArrayList get(){
        return elements;
    }
    public String toString(){
        return elements.toString();//calls arraylist toString so there is no recursion
    }
}