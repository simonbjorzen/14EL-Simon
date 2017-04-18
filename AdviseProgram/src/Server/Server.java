package Server;
import java.io.*;
import java.net.*;


/**
 * Created by simon on 4/18/17.
 */
public class Server {
    String[] adviceList = {"go home", "sleep", "code shitty java"};
    public void go(){
        try {
            ServerSocket serverSocket = new ServerSocket(1337);
            while(true){
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }

    private String getAdvice(){
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args){
        Server server = new Server();
        server.go();
    }
}
