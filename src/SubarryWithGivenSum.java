
public class SubarryWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int K = 5;
        System.out.print(solve(arr,K));
    } 
    public static boolean solve(int[] A, int B) {
       for( int i =0; i<A.length; i++){
        int sum=0 ;
        for(int j=i; j<A.length; j++){
            sum += A[j];
            if(sum>B){
                break;
            }else{
                return true;
            }
        }
       }
        return false;
    }
}
