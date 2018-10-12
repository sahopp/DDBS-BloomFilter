
// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

public class Main {

    public static void main(String[] args) {

        int[] a = new int[]{12, 5, 1, 15};
        int[] b = new int[]{8, 12, 10, 6};
        int m = 16;
        int p = 23;
        BloomFilter filter = new BloomFilter(m, a, b, p);
        filter.add(43);
        filter.add(14);
        filter.add(26);
        filter.printArray();

        for (int i = 0; i < 50; i++) {
            System.out.println(Integer.toString(i) + " " + filter.check(i));
        }
    }
}
