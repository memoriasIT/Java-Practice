public class ProcessA extends Thread{
    private Room room;
    private int id;

    public ProcessA(Room room, int i){
        this.id = i;
        this.room = room;
    }

    @Override
    public void run(){
        while (true) try {
            room.enterA(id);
            sleep(room.rnd.nextInt(1000));
        } catch (Exception e) { e.printStackTrace(); }

    }
}
