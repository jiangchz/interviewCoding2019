package randomlizationSampling;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneralizedReservoirSampling {
    private final int k;
    private int currentSize;
    private List<Integer> samples = null;
    private static Random random;
    public GeneralizedReservoirSampling(int k) {
        this.k = k;
        this.currentSize = 0;
        this.samples = new ArrayList<>();
    }

    public void read(int value) {
        currentSize++;
        int randomIndex = random.nextInt(currentSize);
        if (currentSize <= k) { //bug
            samples.add(value);
        } else if (randomIndex < k) {
            samples.set(randomIndex, value);
        }
    }

    public List<Integer> sample() {
        return samples;
    }
}

/*
Corner case: Without any number should return null
For selected number can use random.nextInt(currentSize) == 0  as 1/n possibility
 */