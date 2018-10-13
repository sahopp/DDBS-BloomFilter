import java.util.Arrays;
import java.util.Random;

public class BloomFilter {

    private boolean[] filter;
    private int m;
    private int k;
    private int[] a;
    private int[] b;
    private int p;


    public BloomFilter(int m, int n){
        this.filter = new boolean[m];
        this.m = m;
        this.k = (int) (Math.log(2)*m/n);
        RandomPrime randomPrime = new RandomPrime();
        this.p = randomPrime.generate(m);
        this.a = new int[k];
        this.b = new int[k];
        Random ran = new Random();
        for (int i = 0; i < k; i++) {
            a[i] = ran.nextInt(p+1)+1;
            b[i] = ran.nextInt(p+1);
        }
    }

    public BloomFilter(int m, int[] a, int[] b, int p){
        this.a = a;
        this.b = b;
        this.p = p;
        this.k = a.length;
        this.m = m;
        this.filter = new boolean[m];
    }

    public boolean[] getFilter() {
        return this.filter;
    }

    public int getK(){
        return this.k;
    }

    public int getM() {
        return this.m;
    }

    public int getP() {
        return this.p;
    }

    public void add(int x){
        for (int i = 0; i < k; i++) {
            this.filter[(int) (((long) a[i]*x + b[i]) % p) % m] = true;
        }
    }

    public boolean check(int x){
        for (int i = 0; i < k; i++) {
            if (!this.filter[((a[i]*x + b[i]) % p) % m]) {return false;}
        }
        return true;
    }

    public void union(BloomFilter filter1){
        if (this.m == filter1.getM()){
            for (int i = 0; i < m; i++) {
                filter[i] = filter[i] || filter1.getFilter()[i];
            }
        }
    }

    public void intersect(BloomFilter filter1){
        if (this.m == filter1.getM()){
            for (int i = 0; i < m; i++) {
                this.filter[i] = filter[i] && filter1.getFilter()[i];
            }
        }
    }

    public void printArray(){
        int[] q = new int[m];
        for (int i = 0; i < m; i++) {
            if (filter[i]) {q[i] = 1;}
        }
        System.out.println(Arrays.toString(q));
        System.out.println(Arrays.toString(a));
        System.out.println((Arrays.toString(b)));
    }

    public void printBoolean(){
        System.out.println(Arrays.toString(filter));
    }
}
