/**
 * Created with IntelliJ IDEA.
 * User: mj
 * Date: 3/7/14
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinAvgTwoSlice {
    public static int solution(int[] A) {
        double minimal = 10000;
        int startingPosition   = 0;

        for(int i=0;i<A.length-2;i++){
            if((A[i]+A[i+1])/2.0<minimal){
                minimal = (A[i]+A[i+1])/2.0;
                startingPosition = i;
            }
        }

        for(int i=0;i<A.length-2;i++){
            if((A[i]+A[i+1]+A[i+2])/3.0<minimal){
                minimal = (A[i]+A[i+1]+A[i+2])/3.0;
                startingPosition = i;
            }
        }

        // comparing the last two elements

        if((A[A.length-2]+A[A.length-1])/2.0<minimal){
            minimal = (A[A.length-2]+A[A.length-1])/2.0;
            startingPosition = A.length-2;
        }

        return startingPosition;

    }

    public static void main(String[] args) {
        System.out.println(MinAvgTwoSlice.solution(new int[]{4, 2, 2, 5, 1, 5, 8}));
    }
}
