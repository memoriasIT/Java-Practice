
import java.util.concurrent.*;

import static java.lang.Thread.sleep;


public class Mesa {
    //0 - piedra, 1 - papel, 2 - tijera\par
    private int N;
    private short counter;

    // Array for decisions
    private int[] PlayerDecisions;

    // Semaphores
    private Semaphore[] playerCanPut;
    private Semaphore canPlay;

    private Semaphore mutex;

    // CONSTRUCTOR
    public Mesa (int Jugadores) {
        N=Jugadores;
        // Counter of already put elements
        counter = 0;

        // Mutex semaphore
        mutex = new Semaphore(1, true);

        // Semaphore for the players to see if they can put items
        playerCanPut = new Semaphore[N];
        for (int i = 0; i < N; i++){
            playerCanPut[i] = new Semaphore(1, true);
        }

        // Where players put their decisions
        PlayerDecisions = new int[N];

        // After all players have put their choices it can be computed
        canPlay = new Semaphore(0, true);
    }


    // CONCURRENCY OF THE ROCK PAPER SCISSORS GAME
    public int nuevaJugada(int jug,int juego) throws InterruptedException {
        // Player can put
        playerCanPut[jug].acquire();

        mutex.acquire();
        PlayerDecisions[jug] = juego;
        counter++;
        int n = counter;
        System.out.printf("P%d - played %d - %d/%d\n", jug, PlayerDecisions[jug], n, N);
        mutex.release();

        if (n == N){
           return computePlay();
        }

        return -1;
    }

    private int computePlay() throws InterruptedException {
        int winner = -1;
        for (int i = 0; i < N; i++){
            // Win with rocks
            // Win with paper
            // Win with scissors
            if (PlayerDecisions[i] == 0 && PlayerDecisions[(i+1)%2] == 2 && PlayerDecisions[(i+2)%2] == 2
                ||
                PlayerDecisions[i] == 1 && PlayerDecisions[(i+1)%2] == 0 && PlayerDecisions[(i+2)%2] == 0
                ||
                PlayerDecisions[i] == 2 && PlayerDecisions[(i+1)%2] == 1 && PlayerDecisions[(i+2)%2] == 1){

                // Winner found no need to continue
                winner = PlayerDecisions[i];
                break;
            }

        }

        if (winner == -1){
            System.out.printf("<========================>\n\tWINNER NOT FOUND!\n\t  This is a tie!\n<========================>\n", winner);
        } else {
            System.out.printf("<========================>\n\t WINNER FOUND!\n\t   P%d WON!\n<========================>\n", winner);
        }
        sleep(5000);

        for (int i = 0; i < N; i++){
            playerCanPut[i].release();
        }
        return winner;
    }


}


