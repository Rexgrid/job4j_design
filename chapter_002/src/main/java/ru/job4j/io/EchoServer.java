package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {


    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (str.contains("msg")) {
                            String[] splitStr = str.split(" ");
                            String[] param = splitStr[1].split("=");
                            String keyWord = param[1];
                            switch (keyWord) {
                                case ("Hello") -> out.write("Hello\r\n\r\n".getBytes());
                                case ("Exit") -> {
                                    out.write("Bye\r\n\r\n".getBytes());
                                    server.close();
                                }
                                default -> out.write("What?\r\n\r\n".getBytes());
                            }
                        }
                    }
                }
            }
        }
    }
}