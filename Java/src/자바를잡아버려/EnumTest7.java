package 자바를잡아버려;

public class EnumTest7 {
    
    enum Fruit {APPLE, BANANA, GRAPE, BLUEBERRY}

    public static void main(String[] args) {
        Fruit[] fs = Fruit.values(); // Fruit의 배열을 리턴
        for(Fruit f : fs){
            System.out.println(f);
        }

        System.out.println();

        for(Fruit f : Fruit.values()){ //2줄을 한줄로 줄여서 사용
            System.out.println(f);
        }
    }
}
