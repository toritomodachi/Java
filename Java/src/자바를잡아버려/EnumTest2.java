package 자바를잡아버려;

public class EnumTest2 {
    /*
     * APPLE : 1
     * BANANA : 2
     * GRAPE : 3
     * BLUEBERRY : 4
     */

     public static void main(String[] args) {
        int myFruit = 2;

        switch(myFruit){
            case 1 : System.out.println("사과 ㅋ"); break;
            case 2 : System.out.println("바나나 ㅋ"); break;
            case 3 : System.out.println("사과라고 ㅋ"); break;
            case 4 : System.out.println("사과라니까 ㅋ"); break;
            default : System.out.println("이걸 잘못선택하네 ㅋㅋ"); break;
        }
     }
}
