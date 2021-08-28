package bootcampdb;

import com.github.sarxos.webcam.Webcam;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class openCamera {
    static  Webcam webcam = Webcam.getDefault();

    public void openCamera1(Socket socket, boolean open) throws IOException, InterruptedException {
        Thread t1 = new Thread() {
            public void run() {
                if(open) {
                    webcam.open();
                    BufferedImage bi = webcam.getImage();
                    ObjectOutputStream outp = null;
                    try {
                        outp = new ObjectOutputStream(socket.getOutputStream());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ImageIcon in = null;
                    synchronized (this) {
                        while (open) {
                            if (open) {
                                System.out.println("Hii");
                                bi = webcam.getImage();
                                in = new ImageIcon(bi);
                                try {
                                    outp.writeObject(in);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }
                }
                else{
                    webcam.close();
                    ObjectOutputStream outp = null;

                        while (!open) {
                            if (!open) {
                                System.out.println("Hello");

                                try {
                                    outp.writeObject(null);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        }
                    }
                }
            };

        if(!t1.isAlive())
            t1.start();

    }
}