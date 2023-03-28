package 자바를잡아버려;

import java.util.LinkedList;

public class ClientMessages {
    LinkedList<String> messageQueue;

    public ClientMessages(){
        messageQueue = new LinkedList<>();
    }

    public synchronized void addMsg(String msg){
        messageQueue.add(msg);
        notifyAll(); //메세지 추가하고 스레드에 알려준다
    }

    public synchronized String getOldestMsg(){
        while(messageQueue.isEmpty()){
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        String broadcastMsg = messageQueue.remove();
        return broadcastMsg;
    }
}
