package Client;

import java.net.*;
import java.io.*;


/**
 * Created by simon on 4/18/17.
 */
public class Client {

    public void go(){
        try{
            Socket socket = new Socket("127.0.0.1", 1337);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String advise = reader.readLine();
            System.out.println("Today you should "+advise);
            reader.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args){
        Client client = new Client();
        client.go();
    }

}
