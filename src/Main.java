import java.util.Random;
// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int m = 19000000;
        int n = 1000000;

        BloomFilter filter = new BloomFilter(m, n);
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            filter.add(ran.nextInt(1000000000));
        }
        //filter.printArray();
        long stopTime = System.nanoTime();
        System.out.println("Running time: " + (stopTime - startTime)/1000000000.0);
        filter.printConfig();
    }
}
