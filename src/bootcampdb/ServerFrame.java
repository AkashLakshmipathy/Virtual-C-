package bootcampdb;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFrame {
    static Socket s1;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server= new ServerSocket(4322);
        System.out.println("waiting");
        s1 = server.accept();
        System.out.println("connected");
        ObjectInputStream in = new ObjectInputStream(s1.getInputStream());
        while(true){
            new dumser(in);
        }
    }
}
