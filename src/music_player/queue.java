package music_player;

import java.util.*;

/**
 * A class representing the Queue in the Music Player App.
 * It contains a list of songs that the Music Player can play
 * using different playing strategy.
 * It can contain repeated songs.
 */
public class queue implements Iterable <song> {
    private static final List<song> aSongElements = new ArrayList<>();
    private static final queue INSTANCE = new queue();
    public static queue instance(){ return INSTANCE;}

    /**
     * Iterate over the current order of the queue
     * @pre aSongElements != empty;
     */
    public void orderedPlay () {
        assert aSongElements.size() != 0;
        Iterator iterator = aSongElements.iterator();
        System.out.print("\nQueue initialized.. songs in ordered queue are: \n");
        while (iterator.hasNext()){
            song entry = (song) iterator.next();
            System.out.println(entry.getName());
        }
    }

    /**
     * Shuffles the contents of aSongElements
     * @pre aSongElements != empty;
     */
    public void shufflePlay() {
        assert aSongElements.size() != 0;
        Collections.shuffle(aSongElements);
        Iterator iterator = aSongElements.iterator();
        System.out.print("\nQueue initialized.. songs in shuffled queue are: \n");
        while (iterator.hasNext()){
            song entry = (song) iterator.next();
            System.out.println(entry.getName());
        }
    }

    /**
     * Add pPlaylist to the Queue.
     * @param pPlaylist The Playlist to add.
     * @pre pPlaylist != empty;
     */
    public void addToQueue (playlist pPlaylist) {
        assert !pPlaylist.isEmpty();
        for (song addition : pPlaylist)
        { aSongElements.add(addition); }
    }

    /**
     * Obtain the number of songs in the queue
     * @return the number of songs in the queue
     */
    public int size() {
        return aSongElements.size();
    }

    /**
     * Obtain the song using its index in the queue.
     * @param index the position of the song in the queue
     * @return the song in the queue at the position of the input index
     * @pre index >=0 && index < aSongElements.size()
     */
    public song get(int index) {
        assert index >=0 && index < aSongElements.size();
        return aSongElements.get(index);
    }

    /**
     * Add a single song to the queue.
     * @param pItem the Song to be added to the queue
     * @pre pItem!=null
     */
    public void add(song pItem) {
        assert pItem!=null;
        aSongElements.add(pItem);
    }

    /**
     * Add a single song from the queue if it can be found.
     * If it appears more than once in the queue, the first occurrence will be removed.
     * @param pItem the Song to be removed to the queue if presented
     * @pre pItem!=null
     */
    public void remove(song pItem) {
        assert pItem!=null;
        aSongElements.removeAll(Collections.singleton(pItem));
    }

    /**
     * traverse the songs in the Queue
     */
    public void getQueueSongs(){
        assert aSongElements != null;
        int songCounter = 1;
        System.out.print("\nQueue initialized.. songs in Queue are: \n");
        for (int i = 0; i < aSongElements.size(); i++) {
            System.out.print("Song " + songCounter + ": " + aSongElements.get(i).getName() + "\n");
            songCounter++;
        }
    }

    /**
     * 'pop' function to simulate going to the next song
     */
    public void nextSong() {
        System.out.println("\nController requests next on song: " + aSongElements.get(0).getName() + "...");
        aSongElements.remove(0);
    }

    /**
     * Iterator to go over the contents (Song) of aQueue
     */
    @Override
    public Iterator<song> iterator() {
        return aSongElements.iterator();
    }
}

