package randomlizationSampling;

import java.util.*;

public class Random1000FromRandom5 {
    private static Random random = new Random();

    public int random1000() {
        int result;
        do {
            result = 0; //bug
            for (int i = 0; i < 5; i++) {
                result = result * 5 + random5();
            }
        } while (result > 3000);
        return result % 1000;
    }

    private static int random5() {
        return random.nextInt(5);
    }
}