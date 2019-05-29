public class Driver {
    public static void main(String[] args){
        Room room = new Room();

        ProcessA[] pA = new ProcessA[room.NUMPA];
        for (int i = 0; i < room.NUMPA; i++){
            pA[i] = new ProcessA(room, i);
            pA[i].start();
        }

        ProcessB[] pB = new ProcessB[room.NUMPB];
        for (int i = 0; i < room.NUMPB; i++){
            pB[i] = new ProcessB(room, i);
            pB[i].start();
        }

    }

}
