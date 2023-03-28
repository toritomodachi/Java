package 자바를잡아버려;

public class ToiletUserTest {
    public static void main(String[] args) {
        TwoToilets twoToilets = new TwoToilets();
        for(int i = 0; i <= 10; i++){
            Thread t = new Thread(new ToiletCompetitionThread(twoToilets, "사용자"+i));
            t.start();
        }
    }
}
