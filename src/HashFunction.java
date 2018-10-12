public class HashFunction {

    private int a;
    private int b;
    private int p;
    private int m;

    public HashFunction(int a, int b, int p, int m){
        this.a = a;
        this.b = b;
        this.p = p;
        this.m = m;
    }

    public int compute(int x){
        return ( (a*x + b) % p) % m;
    }
}
