package 자바를잡아버려;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class UserReceiveThread extends Thread{
    Socket s;
    UserSendThread ust;

    public UserReceiveThread(Socket s, UserSendThread ust){
        this.s = s;
        this.ust = ust;
    }

    public void run(){
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while(true){
                String rcvMsg = br.readLine();
                System.out.println(rcvMsg);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            //서버접속 해제 처리
            System.out.println("서버접속 해제 처리");
            try{
                br.close();
                s.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
}
