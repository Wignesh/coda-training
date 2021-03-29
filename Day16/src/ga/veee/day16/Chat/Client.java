package ga.veee.day16.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    Socket s;
    BufferedReader br, in;
    PrintWriter out;
    ExecutorService es;


    public Client() throws Exception {
        s = new Socket("localhost", 2000);
        s.setKeepAlive(true);
        es = Executors.newCachedThreadPool();
        es.execute(() -> {
            while (true) {
                try {
                    out = new PrintWriter(s.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Type a message to server..:");
                    String msgToServer = in.readLine();
                    if (msgToServer.equalsIgnoreCase("exit")) {
                        break;
                    }
                    out.println(msgToServer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        es.execute(() -> {
            while (true) {
                try {
                    br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    String msg = br.readLine();
                    if (msg == null) {
                        break;
                    }
                    System.out.println("Message from server...:" + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        es.shutdown();
    }

    public static void main(String[] args) throws Exception {
        new Client();
    }
}
