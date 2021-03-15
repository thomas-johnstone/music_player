package music_player;

import java.util.*;

public class playlist implements Iterable<song> {
    private static String aName;
    private ArrayList<song> aPlaylist = new ArrayList<>();

    public playlist () { }

    /**
     * method to name the Playlist
     * @param pName the string to name the playlist
     * @pre aPlaylist != null && aPlaylist.size() != 0
     */
    public void namePlaylist(String pName) {
        assert aPlaylist != null && aPlaylist.size() != 0;
        aName = pName;
    }

    /**
     * Add pSongs to the hand.
     * @param pSong The song to add.
     * @pre pSong != null;
     */
    public void addSong(song pSong) {
        assert pSong != null;
        aPlaylist.add(pSong);
    }

    /**
     * Add contents of pPlaylist to aPlaylist.
     * @param pPlaylist The Playlist to add.
     * @pre pPlaylist != empty;
     */
    public void addPlaylist(playlist pPlaylist) {
        assert !pPlaylist.isEmpty();
        for (song playlistSong : pPlaylist){
            aPlaylist.add(playlistSong);
        }
    }

    /**
     * check whether the playlist is empty or not
     * @return True if there are no songs in this playlist.
     */
    public boolean isEmpty() { return aPlaylist.isEmpty(); }

    /**
     * traverse the songs in the playlist
     */
    public void getSongs(){
        int songCounter = 1;
        System.out.print("\nPlaylist initialized.. songs in this playlist are: \n");
        Iterator iterator = aPlaylist.iterator();
        while(iterator.hasNext()) {
            song entry = (song) iterator.next();
            System.out.print("Song " + songCounter + ": " + entry.getName() + "\n");
            songCounter++;
        }
    }

    /**
     * Iterator to go over the contents (Song) of aPlaylist
     */
    @Override
    public Iterator<song> iterator()
    {
        return aPlaylist.iterator();
    }
}

