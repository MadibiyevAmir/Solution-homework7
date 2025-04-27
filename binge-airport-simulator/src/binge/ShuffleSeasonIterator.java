import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private final List<Episode> shuffledEpisodes;
    private int current = 0;

    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        shuffledEpisodes = new ArrayList<>(episodes);
        Collections.shuffle(shuffledEpisodes, new Random(seed));
    }

    @Override
    public boolean hasNext() {
        return current < shuffledEpisodes.size();
    }

    @Override
    public Episode next() {
        return shuffledEpisodes.get(current++);
    }
}
