package 자바를잡아버려;

public class ThreadTest2 {
    public static void main(String[] args) {
        //스레드를 만들어서 1 ~ 100까지 합계를 구하게 일을 시킨다.
        Runnable r = new MyThread2();
        //스레드에 시킬일이 포함된 runnable 구현 클래스
        Thread t = new Thread(r);
        // runnable 인터페이스를 이용해서 스레드를 만든다.
        t.start(); // start를 호출해서 스레드에 일을 시키다.

        //main 스레드에서는 1 ~ 10까지 곱해서 결과를 출력하는 일을 한다.
        long multiply = 1;
        for(long i = 1; i <= 10; i++){
            multiply = multiply * i;
            System.out.println(i + "곱하기 결과 : "+multiply);
        }
        System.out.println("--------------------------------");
        System.out.println("1 ~ 10 곱하기 : " + multiply);
    }
}
