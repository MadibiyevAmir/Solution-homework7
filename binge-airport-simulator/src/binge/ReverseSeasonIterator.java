import java.util.List;

public class ReverseSeasonIterator implements EpisodeIterator {
    private final List<Episode> episodes;
    private int current;

    public ReverseSeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
        this.current = episodes.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return current >= 0;
    }

    @Override
    public Episode next() {
        return episodes.get(current--);
    }
}
