package server.clientserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class gestione extends Thread{
    Socket s0;
    public void run() {
        System.out.println("Un client si è collegato");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(s0.getInputStream()))) {
            DataOutputStream out = new DataOutputStream(s0.getOutputStream());                          //dati in uscita
            String StringaIn;
            do{
                StringaIn = in.readLine();                      //legge i dati in entrata
                System.out.println("Stringa ricevuta: "+ StringaIn);
                String sMaiuscola = StringaIn.toUpperCase();
                out.writeBytes(sMaiuscola + "\n");
            } while(!StringaIn.equals("!"));           //quando riceve "!" si chiude la socket
            s0.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public gestione(Socket s0){
        this.s0 = s0;
    }
}
