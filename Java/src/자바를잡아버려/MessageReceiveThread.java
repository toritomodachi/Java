package 자바를잡아버려;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MessageReceiveThread extends Thread{
    Socket s;
    ClientMessages cm;
    MessageSendThread ts;
    public MessageReceiveThread(Socket s, ClientMessages cm, MessageSendThread ts){
        this.s = s;
        this.cm = cm;
        this.ts = ts;
    }
    @Override
    public void run(){
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try{
            is = s.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            while(true){
                //클라이언트가 보내는 메시지를 한 줄 읽어온다.
                String msg = br.readLine();
                if(msg == null) throw new IOException();
                System.out.println(msg);
                cm.addMsg(msg); //cm큐에 메시지 저장
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            //클라이언트 연결 해제 시 정리처리
            System.out.println("Client 접속 끊어짐 : 소켓 연결 해제 처리");
            try{
                br.close();
                isr.close();
                is.close();
                ts.remove(s);
                s.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
