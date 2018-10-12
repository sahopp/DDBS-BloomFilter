import java.util.Arrays;

public class BloomFilter {

    private boolean[] filter;
    private int length;
    private int k;
    private HashFunction[] f;


    public BloomFilter(int length, int n, int p){
        this.filter = new boolean[length];
        this.length = length;
        this.k = (int) (Math.log(2)*length/n);
        f = new HashFunction[]{new HashFunction(46, 27, p, length),
                new HashFunction(39, 11, p, length),
                new HashFunction(55, 20, p, length)};
    }


    public boolean[] getFilter() {
        return filter;
    }

    public int getK(){
        return this.k;
    }

    public int getLength() {
        return length;
    }

    public void add(int value){
        for (int i = 0; i < k; i++) {
            this.filter[f[i].compute(value)] = true;
        }
    }

    public boolean check(int value){
        for (int i = 0; i < k; i++) {
            if (!this.filter[f[i].compute(value)]) {return false;}
        }
        return true;
    }

    public void union(BloomFilter filter1){
        if (this.length == filter1.getLength()){
            for (int i = 0; i < length; i++) {
                filter[i] = filter[i] || filter1.getFilter()[i];
            }
        }
    }

    public void intersect(BloomFilter filter1){
        if (this.length == filter1.getLength()){
            for (int i = 0; i < length; i++) {
                this.filter[i] = filter[i] && filter1.getFilter()[i];
            }
        }
    }

    public void printArray(){
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            if (filter[i]) {a[i] = 1;}
        }
        System.out.println(Arrays.toString(a));
    }

    public void printBoolean(){
        System.out.println(Arrays.toString(filter));
    }
}
