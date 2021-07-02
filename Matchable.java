import java.util.ArrayList;

public interface Matchable<Generic>{
    public MatchableContainer combineMatches(MatchableContainer firstData, MatchableContainer secondData);
    public MatchableContainer commonMatches(MatchableContainer firstData, MatchableContainer secondData);
    public boolean onlyFirst(MatchableContainer firstData, MatchableContainer secondData, Generic element);
    public int cardinality(MatchableContainer data);//returns num of elements
    public boolean equalMatches(MatchableContainer firstData, MatchableContainer secondData);
    public boolean nonMatches(MatchableContainer firstData, MatchableContainer secondData);
}