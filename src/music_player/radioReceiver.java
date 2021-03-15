package music_player;

/**
 * Basic RadioReceiver class
 */
public class radioReceiver implements controller {

    public radioReceiver(){};

    @Override
    public void play() {
        System.out.println("\nRadio playing!");
    }

    @Override
    public void next() {
        System.out.println("\nNext song!");
    }
}

