package 문제;
import java.util.Scanner;

public class P1546_평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A[] = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for(int i = 0; i < N; i++){
            if (A[i] > max) max = A[i];
            sum = sum + A[i];
        }
        //한 과목과 관련된 수식을 총합한 후 관련된 수식으로 변환해 로직이 간단해짐
        System.out.println(sum * 100.0 / max / N);

    }
}
