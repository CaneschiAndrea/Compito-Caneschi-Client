package com.example;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 3000);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            Scanner scanner = new Scanner(System.in);

            String domanda = new String();
            String risposta = new String();
            Integer counter = 0;

            do{
                System.out.println("Scegliere una delle tre opzioni: Aggiungere una nota ( 0 ), Lista note ( 1 ),  Uscita (clicclare invio senza scrivere nulla)");
                domanda = scanner.nextLine();

                System.out.println("sono qui 0");
                //risposta = in.readLine();

                System.out.println("sono qui 1");

                Integer domandaClient = Integer.parseInt(domanda);
                //Integer sceltaServer = Integer.parseInt(risposta);

                System.out.println("sono qui 2");

                if (domandaClient == 0) {
                    counter ++;
                    System.out.println("sono qui 3");
                    System.out.println("scrivere l'elemento che si vuole aggiungere: ");
                    String elementi = scanner.nextLine();
                    out.writeBytes(elementi + "\n");
                    System.out.println("nota aggiunta");
                    System.out.println("numero di note aggiunte: " + counter);
                }

                
                else if (domandaClient == 1) {
                    System.out.println("sono qui 4");
                    risposta = in.readLine();
                    System.out.println(risposta);
                }
            }while (Integer.parseInt(domanda) != -1);
            scanner.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Qualcosa è andato storto, chiusura del client...");
            System.exit(1);
        }
    }
}