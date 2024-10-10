package server.clientserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server in ascolto");
        ServerSocket sS0 = new ServerSocket(3000);            //porta dove il server aspetta la richiesta
        while(true){
            Socket s0 = sS0.accept();                                  //nuova porta del server dopo aver accettata la connessione
            gestione g = new gestione(s0);
            g.start();
        }
    }
}