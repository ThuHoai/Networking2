package com.example.hoaiktt.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by hoaiktt on 7/25/2017.
 */

public class SocketUntils {
    public static BufferedReader getReader(Socket socket) throws IOException {
        return (new BufferedReader(new InputStreamReader(socket.getInputStream())));
    }

    public static PrintWriter getWriter(Socket s) throws IOException {
        return (new PrintWriter(s.getOutputStream(), true));
    }

}
