package 자바를잡아버려;

public class EnumTest6 {
    
    enum Fruit{APPLE, BANANA, GRAPE, BLUEBERRY}

    public static void main(String[] args) {
        int i = Fruit.BANANA.ordinal();
        System.out.println(i);
    }
}
