public interface Matchable<Generic>{
    public MatchableContainer<Generic> combinedMatches(MatchableContainer<Generic> firstData, MatchableContainer<Generic> secondData);
    public MatchableContainer<Generic> commonMatches(MatchableContainer<Generic> firstData, MatchableContainer<Generic> secondData);
    public boolean onlyFirst(MatchableContainer<Generic> firstData, MatchableContainer<Generic> secondData,Generic element);
    public int cardinality(MatchableContainer<Generic> firstData);
    public boolean equalMatches(MatchableContainer<Generic> firstData, MatchableContainer<Generic> secondData);
    public boolean nonMatches(MatchableContainer<Generic> firstData, MatchableContainer<Generic> secondData);
}