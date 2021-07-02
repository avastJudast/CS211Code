import java.util.ArrayList;

public class MatchableContainer<Generic> implements Comparable{
    ArrayList elements;
    public MatchableContainer(){
        elements = new ArrayList<Generic>();
    }
    public MatchableContainer(ArrayList<Generic> input){
        elements = new ArrayList<Generic>();
        elements.addAll(input);
    }
    public Generic get(){
        return elements;
    }
    public void set(ArrayList<Generic> input){
        elements = input;
    }
    public String toString(){
        String output = elements.toString();
        return output;
    }
}