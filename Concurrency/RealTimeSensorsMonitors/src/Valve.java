public class Valve {
    private boolean valveOpen;

    public Valve(){
        valveOpen = false;
    }

    public void Open(){
        valveOpen = true;
    }

    public void Close(){
        valveOpen = false;
    }

    public boolean isOpen(){
        return valveOpen;
    }

}
