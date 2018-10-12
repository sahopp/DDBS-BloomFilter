
// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

public class Main {

    public static void main(String[] args) {


        BloomFilter filter = new BloomFilter(16, 3, 71);
        filter.add(3);
        filter.add(37);
        filter.add(2);
        filter.printArray();

        for (int i = 0; i < 50; i++) {
            System.out.println(Integer.toString(i) + " " + filter.check(i));
        }
    }
}
