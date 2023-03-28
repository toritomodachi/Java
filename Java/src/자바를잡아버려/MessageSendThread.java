package 자바를잡아버려;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

// 큐에 있는 메시지를 하나씩 꺼내서 접속한 클라이언트들에게 전송하는 역할
public class MessageSendThread extends Thread{
    ArrayList<Socket> arrayOfSocket;
    ClientMessages cm;
    ArrayList<BufferedWriter> aobw;
    
    public MessageSendThread(ClientMessages cm){
        arrayOfSocket = new ArrayList<>();
        this.cm = cm; //클라이언트 메시지가 들어있는 큐
        aobw = new ArrayList<>();
    }
    public void add(Socket s){
        arrayOfSocket.add(s);
        try{
            OutputStream os = s.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            aobw.add(bw);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try{
            while(true){
                //메시지를 하나 꺼낸다.
                String msg = cm.getOldestMsg();
                System.out.println("수신 메시지 하나 꺼내왔음");
                //연결된 클라이언트들에 모두 송신한다.
                for(BufferedWriter bw : aobw){
                    System.out.println("클라이언트 전송 : "+msg);
                    bw.write(msg); //메시지 전송
                    bw.newLine();
                    bw.flush();
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public void remove(Socket s) {
    }
}
