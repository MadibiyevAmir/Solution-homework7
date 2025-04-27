import java.util.Iterator;
import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private final Iterator<Season> seasonIterator;
    private EpisodeIterator currentEpisodeIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasonIterator = seasons.iterator();
        advanceSeason();
    }

    private void advanceSeason() {
        if (seasonIterator.hasNext()) {
            currentEpisodeIterator = seasonIterator.next().createIterator();
        } else {
            currentEpisodeIterator = null;
        }
    }

    @Override
    public boolean hasNext() {
        while (currentEpisodeIterator != null) {
            if (currentEpisodeIterator.hasNext()) {
                return true;
            } else {
                advanceSeason();
            }
        }
        return false;
    }

    @Override
    public Episode next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more episodes!");
        }
        return currentEpisodeIterator.next();
    }
}
