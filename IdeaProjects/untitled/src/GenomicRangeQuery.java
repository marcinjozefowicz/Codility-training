import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: mj
 * Date: 3/5/14
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class GenomicRangeQuery {
    public static int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 7
        char[] charArray = S.toCharArray();
        int[][] sumSuffix = new int[4][charArray.length];


        switch(charArray[0]){
            case 'A': sumSuffix[0][0]=1;break;
            case 'C': sumSuffix[1][0]=1;break;
            case 'G': sumSuffix[2][0]=1;break;
            case 'T': sumSuffix[3][0]=1;break;
        }

        for(int i=1;i<charArray.length;i++){
            switch(charArray[i]){
                case 'A': sumSuffix[0][i]=sumSuffix[0][i-1]+1;
                    sumSuffix[1][i]=sumSuffix[1][i-1];
                    sumSuffix[2][i]=sumSuffix[2][i-1];
                    sumSuffix[3][i]=sumSuffix[3][i-1];
                    break;

                case 'C': sumSuffix[1][i]=sumSuffix[1][i-1]+1;
                    sumSuffix[0][i]=sumSuffix[0][i-1];
                    sumSuffix[2][i]=sumSuffix[2][i-1];
                    sumSuffix[3][i]=sumSuffix[3][i-1];
                    break;
                case 'G': sumSuffix[2][i]=sumSuffix[2][i-1]+1;
                    sumSuffix[1][i]=sumSuffix[1][i-1];
                    sumSuffix[0][i]=sumSuffix[0][i-1];
                    sumSuffix[3][i]=sumSuffix[3][i-1];
                    break;
                case 'T': sumSuffix[3][i]=sumSuffix[3][i-1]+1;
                    sumSuffix[1][i]=sumSuffix[1][i-1];
                    sumSuffix[2][i]=sumSuffix[2][i-1];
                    sumSuffix[0][i]=sumSuffix[0][i-1];
                    break;
            }
        }
        System.out.println(Arrays.deepToString(sumSuffix));

        int[] answerArray = new int[P.length];
        Arrays.fill(answerArray,0);

        for(int j=0;j<P.length;j++){



            for(int i=0;i<4;i++){
                if(sumSuffix[i][Q[j]]-sumSuffix[i][P[j]]>0) {answerArray[j]=i;break;}
            }

        }
    return answerArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(GenomicRangeQuery.solution(new String("GACACCATA"),new int[]{0, 0, 4, 7},new int[]{8, 2, 5, 7})));

    }
}
