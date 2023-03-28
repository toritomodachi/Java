package 자바를잡아버려;

public class EnumTest8 {
    
    enum Fruit{
        //각각의 열거형 상수값에 값을 할당할 수 있다
        APPLE(1,"상큼하다","빨강"),
        BANANA(2,"달다","노랑"),
        GRAPE(3,"시다","초록"),
        BLUEBERRY(4,"맛있다","파랑");

        int num;
        String taste;
        String color;

        //private 생성자 가능. 상수에 할당한 인자와 동일한 생성자를 정의해야 함
        private Fruit(int n,String t, String c){
            num = n;
            taste = t;
            color = c;
        }
        public int getNum() { return num; }
        public String getTaste() { return taste; }
        public String getColor() { return color; }

        //to String() 메소드 오버라이딩도 가능
        public String toString() { return "num : "+num+", taste : "+taste+", color : "+color;}
    }
    public static void main(String[] args) {
        Fruit f = Fruit.BANANA;
        switch(f){
            case APPLE : System.out.println(f); break;
            case BANANA : System.out.println(f); break;
            case GRAPE : System.out.println(f); break;
            default : System.out.println("잘못 선택했습니다."); break;
        }
    }
}
