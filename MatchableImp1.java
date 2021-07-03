import java.security.GeneralSecurityException;
import java.util.ArrayList;

public class MatchableImp1<Generic> extends Matchable<Generic>{
    public MatchableContainer<Generic> combinedMatches(MatchableContainer<Generic> firstData, MatchableContainer<Generic> secondData){
        ArrayList<Generic> first = firstData.get();
        ArrayList<Generic> second = secondData.get();
        first.addAll(second);
        return new MatchableContainer<Generic>(first);
    }
    public MatchableContainer<Generic> commonMatches(MatchableContainer<Generic> firstData, MatchableContainer<Generic> secondData){
        ArrayList<Generic> first = firstData.get();
        ArrayList<Generic> second = secondData.get();
        ArrayList<Generic> temp = new ArrayList<Generic>();
        for(int i = 0; i < first.size(); i++){
            for(int j = 0; j < second.size();j++){
                if((first.get(i)).compareTo(second.get(j)) == 0) temp.add(first.get(i)); 
            }
        }
    }
    public boolean onlyFirst(MatchableContainer<Generic> firstData, MatchableContainer<Generic> secondData,Generic element){
        ArrayList<Generic> first = firstData.get();
        ArrayList<Generic> second = secondData.get();
        for(int j = 0; j < second.size();j++){
            if(second.get(j).compareTo(element) == 0) return false; 
        }
        for(int j = 0; j < first.size();j++){
            if(first.get(j).compareTo(element) == 0) return true; 
        }
        return false;
    }
    public int cardinality(MatchableContainer<Generic> firstData){
        ArrayList<Generic> data = firstData.get();
        return data.size();
    }
    public boolean equalMatches(MatchableContainer<Generic> firstData, MatchableContainer<Generic> secondData){
        if(cardinality(firstData) != cardinality(secondData)) return false;
        if(cardinality(commonMatches(firstData, secondData)) == cardinality(firstData)) return true;
        return false;        
    }
    public boolean nonMatches(MatchableContainer firstData, MatchableContainer secondData){
        if(cardinality(commonMatches(firstData, secondData)) == 0) return true;
        return false;
    }
}