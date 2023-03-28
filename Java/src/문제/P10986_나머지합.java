package 문제;
import java.io.IOException;
import java.util.Scanner;

public class P10986_나머지합 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;
        S[0] = sc.nextInt();
        for(int i = 1; i < N; i++){
            S[i] = S[i - 1] + sc.nextInt();
        }
        for(int i = 0; i < N; i++){ //합 배열의 모든 값에 % 연산 수행하기
            int remainder = (int) (S[i] % M);
            // 0 ~ i까지의 구간 합 자체가 0일 때 정답에 더하기
            if(remainder == 0) answer++;
            //나머지가 같은 인덱스의 개수 카운팅하기
            C[remainder]++;
        }
        for(int i = 0; i < M; i++){
            if(C[i] > 1){
                //나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
                answer = answer + (C[i] * (C[i - 1]) / 2);
            }
        }
        System.out.println(answer);
    }
}
