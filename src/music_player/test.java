package music_player;

import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit test on the shufflePlay method
 */
public class test {

    /*
     * Helper method to reflectively invoke the private method
     * shufflePlay() and return the result of the invocation
     */
    private void invokeShufflePlay(queue pQueue)
    {
        try
        {
            Method method = queue.class.getDeclaredMethod("shufflePlay");
            method.setAccessible(true);
            method.invoke(pQueue);
        }

        catch(ReflectiveOperationException e)
        {
            e.printStackTrace();
            System.out.println("error e\n");
        }
    }

    /*
     * tests to see that the Queue cannot be empty
     */
    @Test
    public void testNotEmpty(){
        song testerSong = new song("test", "by test", 99);
        queue testerQueue = new queue();
        testerQueue.add(testerSong);
        invokeShufflePlay(testerQueue);
    }

    /*
     * tests to see that the Queue order is randomized
     */
    @Test
    public boolean testShuffleOrder(){
        queue testerQueue = new queue();
        for (int i = 0; i < 99; i++){
            testerQueue.add(new song("test", "by test", i));
        }
        queue testerQueue2 = new queue();
        for (int i = 0; i < 99; i++){
            testerQueue.add(new song("test2", "by test2", i));
        }

        invokeShufflePlay(testerQueue);
        invokeShufflePlay(testerQueue2);
        boolean check = true;

        for (int i = 0; i < 99; i++){
            check = testerQueue.get(i) != testerQueue2.get(i);
        }

        return check;
    }

}
