/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Juliana
 */
public class Support {

    private static int letterCounter = 0;
    private static int auxiliarCounter = 0;
    
    public static String getNextLetter() {
        if (auxiliarCounter == 0 && letterCounter < 26){
            char letter = (char) ('A' + letterCounter % 26);
            letterCounter++;
            String letterString = String.valueOf(letter);
            return letterString;
        }else if ((letterCounter % 26) == 0){
            char letter = (char) ('A' + letterCounter % 26);
            letterCounter++;
            auxiliarCounter++;
            int mod = auxiliarCounter % 26;
            String letterNumber = String.valueOf(mod);
            String compoundLetter = letter + letterNumber;
            return compoundLetter;
        }else{
            char letter = (char) ('A' + letterCounter % 26);
            letterCounter++;
            String letterNumber = String.valueOf(auxiliarCounter);
            String compoundLetter = letter + letterNumber;
            return compoundLetter;
        }
    }
    
    public static void insertClientsWithProbability(CircularSinglyLinkedList csl) {
        // Generar un número aleatorio entre 1 y 100
        Random random = new Random();
        int probability = random.nextInt(100) + 1;

        // Agregar un cliente con una probabilidad del 33%
        if (probability <= 33) {
            String letter = getNextLetter();
            int timeOfArrival = csl.getProcessTransactionscounter();
            int burstNumber = random.nextInt(20) + 1;
            csl.insertAtEnd(letter,  timeOfArrival,  burstNumber);
        } else {
            System.out.println("No client added in this step.");
        }
    }
    
    private static Timer timer = new Timer();
    // Delay of 2 seconds (2000 milliseconds)
    private static final int DELAY = 2000; 

    public static void processTransactionsWithDelay(CircularSinglyLinkedList csl) {

        if (csl.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                csl.processTransactions();
                if (!csl.isEmpty()) {
                    processTransactionsWithDelay(csl);
                    insertClientsWithProbability(csl);
                    csl.display();
                    System.out.println("////UwU////");
                }
            }
        };

        timer.schedule(task, DELAY);
    }
    
}
