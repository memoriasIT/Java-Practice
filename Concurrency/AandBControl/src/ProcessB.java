public class ProcessB extends Thread{
    private int id;
    private Room room;

    public ProcessB(Room room, int i) {
        this.room = room;
        this.id = i;
    }

    @Override
    public void run(){
        while (true) try {
            room.enterB(id);
            sleep(room.rnd.nextInt(1000));
        } catch (Exception e) { e.printStackTrace(); }

    }
}
