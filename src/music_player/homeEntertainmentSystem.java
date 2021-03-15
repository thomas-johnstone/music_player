package music_player;

public class homeEntertainmentSystem {
    public static void main(String[] args) {

        /**
         * demo initializing the system
         */
        musicPlayer testPlayer = musicPlayer.instance();
        song songOne = new song("The Magic Flute", "Wolfgang Amadeus Mozart ", 120);
        song songTwo = new song("Toccata and Fugue in D minor", "Johann Sebastian Bach", 25);
        song songThree = new song("Symphony No. 9","Ludwig van Beethoven", 45);
        song songFour = new song("Hallelujah","Leonard Cohen", 5);

        /**
         * demo adding songs and traversing the pool
         */
        testPlayer.addItem(songOne);
        testPlayer.addItem(songTwo);
        testPlayer.addItem(songThree);
        testPlayer.addItem(songFour);
        testPlayer.getPoolSongs();

        /**
         * demo adding songs from the pool to playlists
         */
        testPlayer.addPlaylistItem(songOne);
        testPlayer.addPlaylistItem(songTwo);
        testPlayer.addPlaylistItem(songThree);
        playlist testPlaylist1 = new playlist(); // new playlist to nest within the other
        testPlaylist1.addSong(songFour);
        testPlayer.nestPlaylist(testPlaylist1);
        testPlayer.getPlaylistSongs();

        /**
         * demo adding from playlist to queue, then ordered and shuffle play
         */
        testPlayer.addItemToQueue(songOne.getName());
        testPlayer.addPlaylistToQueue();
        testPlayer.orderPlay();
        testPlayer.shufflePlay();

        /**
         * demo manipulating the queue
         */
        testPlayer.removeItemFromQueue(songOne.getName());
        testPlayer.orderPlay();

        /**
         * demo using the controller interface with the MusicPlayer and the RadioReceiver
         */
        testPlayer.play();
        testPlayer.next();
        radioReceiver radio = new radioReceiver();
        radio.play();
        radio.next();

    }
}
