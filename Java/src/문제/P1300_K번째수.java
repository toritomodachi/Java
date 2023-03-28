package 문제;

import java.util.Scanner;

public class P1300_K번째수 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 1,end = K;
        long ans = 0;
        //이진 탐색 수행하기
        while(start <= end){
            long middle = (start + end) /2;
            long cnt = 0;
            //중앙값보다 작은 수는 몇 개인지 계산하기
            for(int i = 1; i <= N; i++){
                cnt += Math.min(middle / i,N);
            }
            if(cnt < K){
                start = middle + 1;
            }
            else{
                ans = middle;
                end = middle - 1;
            }
        }
        System.out.println(ans);
    }
    
}
