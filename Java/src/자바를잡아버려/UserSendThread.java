package 자바를잡아버려;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class UserSendThread extends Thread{
    Socket s;
    String name;

    public UserSendThread(Socket s, String ust){
        this.s = s;
        this.name = ust;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(name+"님이 입장하셨습니다.");
            bw.newLine();
            bw.flush();

            while(sc.hasNext()){
                String msg = sc.nextLine();
                bw.write(name+"> "+msg);
                bw.newLine();
                bw.flush();
            }
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
            bw.close();
            }
            catch(IOException e){
            e.printStackTrace();
            }
        }
      
    }
}
