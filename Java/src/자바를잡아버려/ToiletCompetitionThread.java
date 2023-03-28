package 자바를잡아버려;

public class ToiletCompetitionThread implements Runnable{
    TwoToilets twoToilets;
    String User;

    public ToiletCompetitionThread(TwoToilets thisToilets, String UserName){
        twoToilets = thisToilets;
        User = UserName;
    }

    @Override
    public void run(){
        try{
            twoToilets.use(User);
            Thread.sleep(5000);
            twoToilets.use(User);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
