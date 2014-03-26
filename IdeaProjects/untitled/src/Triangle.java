import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: mj
 * Date: 3/26/14
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class Triangle {
    public static int solution(int[] A){
 //       System.out.println(Arrays.toString(A));
        Arrays.sort(A);
        for(int i=2;i<A.length;i++){

            if((long)A[i-2]+(long)A[i-1]>(long)A[i]){           //long casting to prevent overflow in adding two maxInt
                if((long)A[i-2]+(long)A[i]>(long)A[i-1]){
                    if((long)A[i]+(long)A[i-1]>(long)A[i-2]){
                        return 1;
                    }
                    else continue;
                }
                else continue;
            }
            else continue;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 2, 5, 1, 8, 20}));
        System.out.println(solution(new int[]{10, 5, 50, 1}));
    }
}
