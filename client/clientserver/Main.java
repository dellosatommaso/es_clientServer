package client.clientserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client partito");
        Socket s0 = new Socket("localhost", 3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s0.getInputStream()));     //dati in entrata
        DataOutputStream out = new DataOutputStream(s0.getOutputStream());                      //dati in uscita

        Scanner input = new Scanner(System.in);    //input da tastiera
        String s;                                  

        do {
            System.out.println("Inserire una stringa o ! per uscire\n");
            s = input.nextLine();           //la stringa diventa ciò che è stato preso con lo scanner 
            out.writeBytes(s + "\n");       //invio la stringa     
            String sM = in.readLine();                        
            System.out.println("Stringa convertita in maiuscole: " + sM);
        } while (!s.equals("!"));   //quando riceve "!" si chiude
    
        input.close();
        s0.close();
        System.out.println("Client chiuso");   
    
    }
}