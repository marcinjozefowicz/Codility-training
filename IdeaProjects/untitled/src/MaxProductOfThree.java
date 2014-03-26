import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: mj
 * Date: 3/25/14
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaxProductOfThree {
    public static int solution(int[] A) {

        //Arrays.sort(A);
        Integer[] Awrapped = new Integer[A.length];
        copyArray(A,Awrapped);
        sort(Awrapped);
        int result =1;
        for(int i=1;i<4;i++){
            result*=Awrapped[Awrapped.length-i];
        }
        if(result<Awrapped[0]*Awrapped[1]*Awrapped[Awrapped.length-1]) result=Awrapped[0]*Awrapped[1]*Awrapped[Awrapped.length-1];

        return result;
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
    private static void sort(Comparable[] a,Comparable[] aux, int lo,int hi){
        if(hi<=lo) return;
        int mid = lo + (hi-lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }
    private static void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi){
        for(int i=lo;i<=hi;i++) aux[i] = a[i];

        //settings flags i & j
        int i=lo,j=mid+1;
        for(int k=lo; k<=hi;k++){
            if(i>mid)       a[k]=aux[j++]; // i flag is out of bound so copy from right subarray
            else if(j>hi)   a[k]=aux[i++]; // j flag is out of bound so copy from left subarray
            else if(less(aux[j],aux[i])) a[k] = aux[j++];
            else            a[k]=aux[i++];
        }
    }
    private static boolean less(Comparable first, Comparable second){
        return (first.compareTo(second)<0);
    }
    private static void copyArray(int[] srcArray, Integer[] dstArray){

        for(int i=0;i<srcArray.length;i++){
            dstArray[i]= new Integer(srcArray[i]);
        }

    }
}
