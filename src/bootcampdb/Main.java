package bootcampdb;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

public class Main extends JFrame{
    static Socket socket;
    public static void main(String[] args) throws IOException {
        socket=new Socket("127.0.0.1",4322);
        JFrame f=new JFrame();
        f.setVisible(true);
        f.setSize(1000,1000);
        JButton b2=new JButton("OPEN");
        b2.setBounds(500,300,100,100);
        f.add(b2);
        b2.setVisible(true);
        JButton b3=new JButton("CLOSE");
        b3.setBounds(500,500,100,100);
        f.add(b3);
        b3.setVisible(true);
        f.setLayout(null);
        openCamera c1=new openCamera();
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new openCamera().openCamera1(socket,true);
                } catch (IOException | InterruptedException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new openCamera().openCamera1(socket,false);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
    }
}
