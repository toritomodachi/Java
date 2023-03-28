package 자바를잡아버려;

public class EnumTest1 {
    

    enum Fruit{
        APPLE, BANANA, GRAPE, BLUEBERRY
    }

    public static void main(String[] args) {
        Fruit myFruit = Fruit.BANANA;
        switch(myFruit){
            case APPLE : System.out.println("사과 선택했냐?"); break;
            case BANANA : System.out.println("바나나 선택했냐고"); break;
            case GRAPE : System.out.println("사과를 선택했냐?"); break;
            case BLUEBERRY : System.out.println("사과를 선택했어요"); break;
            default : System.out.println("이것도 선택못하네 ㅋ"); break;
        }
        
    }
}
