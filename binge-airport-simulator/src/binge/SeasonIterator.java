import java.util.List;

public class SeasonIterator implements EpisodeIterator {
    private final List<Episode> episodes;
    private int current = 0;

    public SeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public boolean hasNext() {
        return current < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(current++);
    }
}
