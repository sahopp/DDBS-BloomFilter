import java.util.Random;

public class Main {

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        int m = 19000000;
        int n = 1000000;
        int testNr = 189246;
        int testNr2 = 49295;
        BloomFilter filter = new BloomFilter(m, n);
        Random ran = new Random();
        for (int i = 0; i < n; i++) {
            int nr = ran.nextInt(1000000000);
            if (!(nr == testNr)) {filter.add(nr);}
        }

        filter.add(testNr2);
        //filter.printArray();
        long stopTime = System.nanoTime();
        System.out.println("Running time: " + (stopTime - startTime)/1000000000.0);
        filter.printConfig();

        System.out.println("False element: " + filter.check(testNr));
        System.out.println("Right element: " + filter.check(testNr2));
    }
}
