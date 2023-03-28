package 자바를잡아버려;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer extends Thread{
    
    public static void main(String[] args) {
        ServerSocket ss;
        //수신스레드와 송신스레드가 공유하는 큐클래스
        ClientMessages cm = new ClientMessages();
        //송신스레드를 하나 생성한다. 알아서 큐의 메시지를 전체 클라이언트에 전송한다.
        MessageSendThread ts = new MessageSendThread(cm);
        ts.start();

        try{
            ss = new ServerSocket(9999);

            //메인스레드는 클라이언트 연결을 받아서
            //소켓배열에다가 추가하고,
            //수신스레드를 클라이언트별로 만들고
            //송신스레드의 소켓목록을 update하는 역할을 한다
            while(true){
                Socket s = ss.accept();
                ts.add(s); //송신스레드가 관리하는 클라이언트 소켓목록에 하나 추가.
                //클라이언트별 수신스레드를 하나씩 만들어서 시작하면
                //알아서 클라이언트가 보낸 메시지를 받아서 큐에 넣는 역할을 해준다.
                MessageReceiveThread t = new MessageReceiveThread(s, cm, ts);
                t.start();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
