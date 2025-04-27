public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Pilot", 3600));
        season1.addEpisode(new Episode("Episode 2", 3400));

        Season season2 = new Season();
        season2.addEpisode(new Episode("New Beginnings", 3700));
        season2.addEpisode(new Episode("Final Countdown", 3500));

        Series series = new Series();
        series.addSeason(season1);
        series.addSeason(season2);

        System.out.println("Normal Order:");
        EpisodeIterator it = season1.createIterator();
        while (it.hasNext()) {
            System.out.println(it.next().getTitle());
        }

        System.out.println("\nReverse Order:");
        it = season1.createReverseIterator();
        while (it.hasNext()) {
            System.out.println(it.next().getTitle());
        }

        System.out.println("\nShuffle Order (seed=42):");
        it = season1.createShuffleIterator(42L);
        while (it.hasNext()) {
            System.out.println(it.next().getTitle());
        }

        System.out.println("\nBinge Watching:");
        it = series.createBingeIterator();
        while (it.hasNext()) {
            System.out.println(it.next().getTitle());
        }
    }
}
