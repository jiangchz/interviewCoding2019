package randomlizationSampling;

import java.util.Random;

public class ReservoirSampling {
    private int currentSize;
    private int currentSample;
    private static Random random;
    public ReservoirSampling() {
        this.currentSize = 0;
        random = new Random();
    }

    public void read(int value) {
        currentSize++;
        currentSample = random.nextInt(currentSize) == 0 ? value : currentSample;
    }

    public Integer sample() {
        if (currentSize == 0) {
            return null;
        }
        return currentSample;
    }
}

/*
Corner case: Without any number should return null
For selected number can use random.nextInt(currentSize) == 0  as 1/n possibility
 */