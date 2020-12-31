package algorithm.Heap;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq; //基于堆的完全二叉树
    private int N = 0;    //pq[0]不使用，why？

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
        N = maxN + 1;
    }
    public MaxPQ(Key[] var){
        pq=var;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
    public void insert(Key v){
        pq[++N]=v;
        swim(N);
    }
    public Key delMax(){
        Key max = pq[1];
        exchange(1,N--);
        pq[N+1]=null;
        sink(1);
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    //上浮,k位置元素的父节点为k/2
    //另节点与不比自己大的父节点交换位置，repeat
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k, k / 2);
            k /= 2;
        }
    }

    //下沉,k位置元素的子节点为，2k和2k=1（不使用数组第一个位置）
    // 在使用数组的第一个位置的情况下， 节点i的左子树为2*i+1，右子树为2*i+2

    //另元素与其子节点中较大的交换位置，，repeat
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exchange(k,j);
            k=j;
        }
    }

}
