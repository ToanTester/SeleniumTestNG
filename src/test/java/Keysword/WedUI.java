package Keysword;

public class WedUI {
    public static void sleep(double second){
        try
        {
            Thread.sleep((long) (1000 * second));
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

    }
}
