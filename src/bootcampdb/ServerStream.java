package bootcampdb;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//import org.apache.commons.io.output.ByteArrayOutputStream;


public class ServerStream {
    private OutgoingSoudnListener osl = new OutgoingSoudnListener();
    boolean outVoice = true;
    AudioFormat format = getAudioFormat();
    private ServerSocket serverSocket;
    Socket server;


    private AudioFormat getAudioFormat() {
        float sampleRate = 16000.0F;
        int sampleSizeBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;

        return new AudioFormat(sampleRate, sampleSizeBits, channels, signed, bigEndian);
    }
    public ServerStream() throws IOException{
        try{
            System.out.println("Creating Socket...");
            serverSocket = new ServerSocket(2018);
            osl.runSender();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    class OutgoingSoudnListener{
        public void runSender(){
            try{
                server = serverSocket.accept();
                System.out.println("Listening from mic.");
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                DataLine.Info micInfo = new DataLine.Info(TargetDataLine.class,format);
                TargetDataLine mic = (TargetDataLine) AudioSystem.getLine(micInfo);
                mic.open(format);
                System.out.println("Mic open.");
                byte tmpBuff[] = new byte[mic.getBufferSize()/5];
                mic.start();
                while(outVoice) {
                    System.out.println("Reading from mic.");
                    int count = mic.read(tmpBuff,0,tmpBuff.length);
                    if (count > 0){
                        System.out.println("Writing buffer to server.");
                        out.write(tmpBuff, 0, count);
                    }
                }
                mic.drain();
                mic.close();
                System.out.println("Stopped listening from mic.");
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public static void main (String args[]) throws IOException{
        new ServerStream();

    }


}