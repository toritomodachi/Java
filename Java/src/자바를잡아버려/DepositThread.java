package 자바를잡아버려;

public class DepositThread implements Runnable{
    Account myAccount;

    DepositThread(Account thisAccount){
        myAccount = thisAccount;
    }

    @Override
    public void run(){
        Account newKey = new Account(); //또는 Object newKey = new Object();

        synchronized(newKey){
        for(int i = 0; i<1000; i++){
            myAccount.deposit(1);
        }
        myAccount.inquiry();
        }
    }
}
