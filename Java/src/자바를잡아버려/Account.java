package 자바를잡아버려;

public class Account {
    long balance;

    public synchronized void deposit(long amount){
        balance += amount;
    }

    public void inquiry(){
        System.out.println("잔액 : " + balance);
    }
}
