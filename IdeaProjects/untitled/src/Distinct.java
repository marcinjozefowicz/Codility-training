/**
 * Created with IntelliJ IDEA.
 * User: mj
 * Date: 3/20/14
 * Time: 7:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Distinct {
    public static int solution(int[] A) {
        // write your code in Java SE 7



        Integer[] newArray = new Integer[A.length];
        int i = 0;
        for (int value : A) {
            newArray[i++] = Integer.valueOf(value);
        }

        sort(newArray);
        //System.out.println(isSorted(newArray,0,newArray.length-1));
        int counter = 0;

        if (newArray.length == 0) counter = 0;
        else counter = 1;

        for(i=1;i<newArray.length;i++){
            if(newArray[i].equals(newArray[i-1])) continue;
            else    counter++;
        }


        /*
        if(counter==1) return counter;

        for(i = (newArray.length - 1); i>0;i--) {
            if (newArray[i] == newArray[i - 1]) counter--;
        }
        */
        return counter;

    }

    private static boolean isSorted(Comparable[] newArray, int lo, int hi) {
        for(int i=lo+1;i<=hi;i++){
            if(less(newArray[i],newArray[i-1])) return false;

        }
        return true;
    }

    private static void sort(Comparable[] a){
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi<=lo) return;

        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);

    }
    private static int partition(Comparable[] a,int lo, int hi){
        int i=lo;
        int j=hi+1;
        Comparable v=a[lo];

        while(true){

            while(less(a[++i],v))   // setting index i on bigger value than a[lo]
                if(i==hi) break;    // secure out of Bound
            while(less(v,a[--j]))    // setting index j on smaller value than a[lo]
                if(j==lo) break;
            if(i>=j) break;         // indexes swap each other
            exch(a,i,j);            // swaping a[i] with a[j] val
        }
        exch(a,lo,j);               // put partitioning item on j index
        return j;
    }

    private static void exch(Object[] a,int x, int y){
        Object temporary = a[x];
        a[x] = a[y];
        a[y] = temporary;
    }

    private static boolean less(Comparable x,Comparable y){
        return (x.compareTo(y)<0);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1}));
        System.out.println(solution(new int[]{65536, 131072, 65536, 131072, 196608}));
        System.out.println(solution(new int[]{587, 362, 52, 651, 951, 593, 569, 746, 628, 620, 253, 151, 642, 85, 929, 436, 661, 353, 376, 925, 472, 254, 709, 462, 249, 622, 136, 794, 835, 163, 218, 939, 286, 801, 658, 314, 689, 24, 330, 823, 984, 727, 358, 940, 621, 916, 810, 535, 353, 495, 757, 271, 737, 799, 361, 764, 81, 888, 937, 447, 371, 826, 324, 380, 162, 187, 95, 196, 676, 64, 952, 198, 228, 44, 805, 892, 333, 78, 82, 739, 350, 592, 15, 870, 681, 13, 805, 419, 190, 852, 757, 638, 132, 129, 249, 913, 63, 76, 240, 884}));
        System.out.println(solution(new int[]{728, 500, 778, 564, 881, 885, 598, 1, 267, 513, 994, 52, 774, 878, 26, 15, 175, 397, 366, 515, 574, 397, 41, 539, 14, 350, 986, 848, 922, 596, 996, 788, 326, 261, 384, 441, 39, 289, 389, 476, 812, 83, 131, 172, 47, 658, 826, 146, 232, 558, 337, 270, 219, 65, 511, 811, 313, 321, 616, 0, 625, 543, 741, 713, 91, 725, 916, 914, 888, 461, 338, 616, 496, 411, 458, 388, 579, 739, 822, 362, 474, 828, 649, 1000, 899, 706, 370, 297, 233, 219, 820, 597, 1000, 702, 311, 413, 186, 165, 393, 896, 744, 564, 353, 156, 806, 231, 1, 169, 780, 344, 10, 703, 969, 871, 731, 989, 722, 363, 384, 140, 716, 42, 321, 859, 208, 934, 636, 639, 584, 589, 760, 832, 143, 998, 306, 368, 752, 268, 990, 542, 39, 913, 162, 925, 781, 982, 888, 490, 28, 820, 249, 976, 740, 347, 730, 157, 350, 979, 203, 806, 810, 798, 3, 246, 654, 990, 820, 843, 709, 944, 181, 33, 168, 2, 461, 227, 974, 524, 89, 81, 15, 759, 370, 855, 392, 647, 921, 131, 148, 632, 637, 733, 392, 478, 355, 164, 564, 295, 58, 863}));
    }





}
