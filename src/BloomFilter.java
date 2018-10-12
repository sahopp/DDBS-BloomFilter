import java.util.Arrays;

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
        // construct random vectors a, b of length k and random prime p
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

    public void add(int x){
        for (int i = 0; i < k; i++) {
            this.filter[((a[i]*x + b[i]) % p) % m] = true;
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
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            if (filter[i]) {a[i] = 1;}
        }
        System.out.println(Arrays.toString(a));
    }

    public void printBoolean(){
        System.out.println(Arrays.toString(filter));
    }
}
