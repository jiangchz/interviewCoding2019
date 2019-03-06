package randomlizationSampling;

import java.util.Random;

public class Random7FromRandom5 {
    private static Random randon = new Random();
    public int random7() {
        int result;
        do {
            result = random5() * 5 + random5();
        } while (result > 20);
        return result / 3;
    }
    private static int random5() {
        return randon.nextInt(5);
    }
}