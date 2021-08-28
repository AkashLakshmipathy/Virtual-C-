package bootcampdb;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;

public class dumser {
    dumser(ObjectInputStream in) throws IOException, ClassNotFoundException {
        final JLabel l1=new JLabel();
        final JLabel l2=new JLabel();
        final JFrame f1=new JFrame();
        l1.setSize(640,360);
        l1.setVisible(true);
        f1.add(l1);
        f1.setSize(640,360);
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);

        f1.setVisible(true);
        ImageIcon fp=new ImageIcon();
        f1.setVisible(true);
        while(true){
                l1.setIcon((ImageIcon)in.readObject());

        }
    }
}
