


public class Mesa {
    //0 - piedra, 1 - papel, 2 - tijera\par
    private int N;
    private short counter;

    // Array for decisions
    private int[] PlayerDecisions;

    // CONSTRUCTOR
    public Mesa (int Jugadores) {
        N=Jugadores;
        // Counter of already put elements
        counter = 0;

        // Where players put their decisions
        PlayerDecisions = new int[N];

    }


    // CONCURRENCY OF THE ROCK PAPER SCISSORS GAME
    public synchronized int nuevaJugada(int jug,int juego) throws InterruptedException {
        PlayerDecisions[jug] = juego;
        counter++;
        System.out.printf("P%d - played %d - %d/%d\n", jug, PlayerDecisions[jug], counter, N);

        if (counter == N){
            return computePlay();
        }

        return -1;
    }

    private synchronized int computePlay() throws InterruptedException {
        int winner = -1;


        /*
        TESTING PURPOSES
        int i2 = 2;
        PlayerDecisions[i2] = 0;
        PlayerDecisions[(i2+1)%3] = 2;
        PlayerDecisions[(i2+2)%3] = 2;

        if (PlayerDecisions[i2] == 0 && PlayerDecisions[(i2+1)%3] == 2 && PlayerDecisions[(i2+2)%3] == 2){
            System.out.printf("\n\n[OK] - i2 = %d ; i2+1 = %d ; i2+2 = %d\n", i2, ((i2+1)%3), ((i2+2)%3));
            System.out.printf("[OK] - PD[i2] = %d ; PD[i2+1] = %d ; PD[i2+2] = %d\n\n\n", PlayerDecisions[i2], (PlayerDecisions[(i2+1)%3]), (PlayerDecisions[(i2+2)%3]));
        } else {
            System.out.printf("\n\n[NO] - i2 = %d ; i2+1 = %d ; i2+2 = %d\n", i2, ((i2+1)%3), ((i2+2)%3));
            System.out.printf("[NO] - PD[i2] = %d ; PD[i2+1] = %d ; PD[i2+2] = %d\n\n\n", PlayerDecisions[i2], (PlayerDecisions[(i2+1)%3]), (PlayerDecisions[(i2+2)%3]));
        }
        */


        for (int i = 0; i < N; i++){
            // Win with rocks
            // Win with paper
            // Win with scissors
            if (PlayerDecisions[i] == 0 && PlayerDecisions[(i+1)%N] == 2 && PlayerDecisions[(i+2)%N] == 2
                    ||
                    PlayerDecisions[i] == 1 && PlayerDecisions[(i+1)%N] == 0 && PlayerDecisions[(i+2)%N] == 0
                    ||
                    PlayerDecisions[i] == 2 && PlayerDecisions[(i+1)%N] == 1 && PlayerDecisions[(i+2)%N] == 1){

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

        return winner;
    }


}


