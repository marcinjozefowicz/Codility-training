/**
 * Created with IntelliJ IDEA.
 * User: mj
 * Date: 3/5/14
 * Time: 5:10 PM
 * To change this template use File | Settings | File Templates.
 */
class PassingCars {
    public static int solution(int[] A) {
        // write your code in Java SE 7
        int TotalSum = 0;
        int[] Sum = new int[A.length];
        Sum[0]=A[0];
        for(int i=1;i<A.length;i++){
            Sum[i]=Sum[i-1]+A[i];
        }

        for (int i=0;i<A.length;i++){
            if(A[i]==0){

                TotalSum=TotalSum+Sum[A.length-1]-Sum[i];
                if(TotalSum> 1000000000) return -1;
            }
        }

        return TotalSum;
    }

    public static void main(String[] args) {
        System.out.println(PassingCars.solution(new int[]{0}));
        System.out.println(PassingCars.solution(new int[]{0, 1, 0, 1, 1}));
        System.out.println(PassingCars.solution(new int[]{0, 1, 1, 1, 1}));
        System.out.println(PassingCars.solution(new int[]{0, 1, 0, 1, 0}));
        System.out.println(PassingCars.solution(new int[]{1}));
    }
}
