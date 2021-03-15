package music_player;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

/**
 * A class representing a Music Player App.
 * It contains a pool of songs that allow the user to traverse and add to the queue to play.
 */
public class musicPlayer implements controller {
    private Map<String, song> aItems; // Make sure a predictable iteration order.
    private queue aQueue = queue.instance(); //singleton instance of the Queue
    private playlist aPlaylist = new playlist();
    private static final musicPlayer INSTANCE = new musicPlayer(); //singleton instance of the MusicPlayer
    public static musicPlayer instance(){ return INSTANCE;}

    musicPlayer() { aItems = new LinkedHashMap<>(); }

    /**
     * Add a single song to the music pool if a song with the same name is not already in the pool.
     * @param pItem the song to be added in the pool
     * @pre pItem !=null
     */
    public void addItem(song pItem) {
        assert pItem != null;
        aItems.putIfAbsent(pItem.getName(), pItem);
    }

    /**
     * Add a single song to the playlist if a song with the same name is not already in the pool.
     * @param pItem the song to be added in the pool
     * @pre pItem !=null
     */
    public void addPlaylistItem(song pItem) {
        assert pItem != null;
        aPlaylist.addSong(pItem);
    }

    /**
     * Add a single playlist to the queue
     * @param pPlaylist the playlist to be added to the Queue
     * @pre pPlaylist !=null
     */
    public void nestPlaylist(playlist pPlaylist){
        assert pPlaylist != null;
        aPlaylist.addPlaylist(pPlaylist);
    }

    /**
     * Add a single song to the queue if that song can be found in the music pool.
     * @param pItemName the name of the song
     * @pre pItemName !=null
     */
    public void addItemToQueue(String pItemName) {
        assert pItemName != null;
        if (aItems.containsKey(pItemName))
            aQueue.add(aItems.get(pItemName));
    }

    /**
     * remove a single song from the queue if that song can be found in the music pool.
     * @param pItemName the name of the song
     * @pre pItemName !=null
     */
    public void removeItemFromQueue(String pItemName) {
        assert pItemName != null;
        if (aItems.containsKey(pItemName))
            aQueue.remove(aItems.get(pItemName));
    }

    /**
     * Add a playlist to the queue if that song can be found in the music pool.
     * @pre aPlaylist !=null
     */
    public void addPlaylistToQueue() {
        assert aPlaylist != null;
        aQueue.addToQueue(aPlaylist);
    }

    /**
     * Play the queue with ordered play
     * @pre aQueue != null
     */
    public void orderPlay(){
        assert aQueue != null;
        aQueue.orderedPlay();
    }

    /**
     * Play the queue with shuffled play
     * @pre aQueue != null
     */
    public void shufflePlay(){
        assert aQueue != null;
        aQueue.shufflePlay();
    }

    /**
     * Obtain the number of songs in the queue
     * @return the number of songs in the queue
     */
    public int queueSize() {
        return aQueue.size();
    }

    /**
     * Obtain the number of songs in the pool
     * @return the number of songs in the pool
     */
    public int poolSize() {
        return aItems.size();
    }

    /**
     * traverse the songs in the pool
     */
    public void getPoolSongs(){
        int songCounter = 1;
        System.out.print("\nMusicPlayer initialized.. songs in pool are: \n");
        Set set = aItems.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.print("Song " + songCounter + ": " + entry.getKey() + "\n");
            songCounter++;
        }
    }

    /**
     * traverse the songs in the playlist
     */
    public void getPlaylistSongs(){
        aPlaylist.getSongs();
    }

    /**
     * Override methods to implement the Controller interface
     */
    @Override
    public void play() {
        aQueue.getQueueSongs();
    }

    @Override
    public void next() {
        aQueue.nextSong();
        aQueue.getQueueSongs();
    }

}

