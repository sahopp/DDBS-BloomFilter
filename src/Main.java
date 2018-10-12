
// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] a = new int[]{12, 5, 1, 15};
        int[] b = new int[]{8, 12, 10, 6};
        int m = 16;
        int p = 23;
        BloomFilter filter = new BloomFilter(16, 3);
        filter.add(43);
        filter.add(14);
        filter.add(26);
        filter.printArray();

        for (int i = 0; i < 50; i++) {
            System.out.println(Integer.toString(i) + " " + filter.check(i));
        }
        System.out.println(filter.getK());
    }
}
