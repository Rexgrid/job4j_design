package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {


    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean isActive = true;
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        System.out.println(str);
                        if (str.contains("/?msg=Bye")) {
                            isActive = false;
                        }
                    }
                    if (isActive) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    } else {
                        out.write("HTTP/1.1 4700 BYE\r\n\r\n".getBytes());
                        server.close();
                    }

                }
            }
        }
    }
}