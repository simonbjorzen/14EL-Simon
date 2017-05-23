package Client;

import java.net.*;
import java.io.*;
import java.util.*;


public class Client {
    public void go(String ip, Integer port){
        try{
            Socket socket = new Socket(ip, port);
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
        String ip;
        Integer port;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the IP: ");
        ip = reader.next();
        System.out.println("Enter the port: ");
        port = reader.nextInt();
        client.go(ip, port);
    }

}
