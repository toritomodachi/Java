package 자바를잡아버려;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChattingClient {
    public static void main(String[] args) {
        //서버와 연결
        Socket s;
        try{
            s = new Socket("localhost",9999);
            
            System.out.println("채팅명을 입력하세요");
            Scanner sc = new Scanner(System.in);
            String name = sc.next();

            //송신 전용스레드와 수신 전용스레드 2개를 생성하여 start시킨다.
            UserSendThread ust = new UserSendThread(s,name);
            ust.start();

            UserReceiveThread urt = new UserReceiveThread(s,ust);
            urt.start();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
