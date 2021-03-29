package ga.veee.day16.Chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
    ServerSocket ss;
    BufferedReader br, in;
    PrintWriter out;
    Socket s;
    HashMap<SocketAddress, ThreadServer> pool = new HashMap<>();
    ExecutorService es;

    void handleConnection(Socket socket) throws IOException {
        ThreadServer threadServer = new ThreadServer(s, s.getRemoteSocketAddress());
        pool.put(s.getRemoteSocketAddress(), threadServer);
        System.out.println(pool.size());

    }

    public Server() throws Exception {
        es = Executors.newCachedThreadPool();


        es.execute(() -> {
            try {
                ss = new ServerSocket(2000);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Server ready.....");
            while (true) {
                try {
                    s = ss.accept();
                    if (s.isConnected()) {
                        handleConnection(s);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        es.execute(() -> {
            while (true) {
                try {
                    in = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter Message For Clients..:");
                    String msgToClient = in.readLine();
                    sendToAll(msgToClient);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        es.shutdown();


    }

    void sendToAll(String msg) {

        for (Map.Entry<SocketAddress, ThreadServer> ts : pool.entrySet()) {
            ts.getValue().sendMessage(msg);
        }
    }

    public static void main(String[] args) throws Exception {
        new Server();
    }
}

class ThreadServer {
    Socket socket;
    SocketAddress socketAddress;
    ExecutorService es;
    PrintWriter out;

    ThreadServer(Socket socket, SocketAddress socketAddress) throws IOException {
        System.out.println(socketAddress);
        this.socket = socket;
        this.socketAddress = socketAddress;
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.start();
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    void start() throws IOException {
        es = Executors.newCachedThreadPool();
        es.execute(() -> {
            while (true) {
                String msg = null;
                try {
                    msg = new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (msg == null) {
                    break;
                }
                System.out.printf("\nClient %s says %s", Thread.currentThread().getName(), msg);
            }
        });
        es.shutdown();
    }
}
