public class Injector {
    private boolean injectorOpen;

    public Injector(){
        injectorOpen = false;
    }

    public void Open(){
        injectorOpen = true;
    }

    public void Close(){
        injectorOpen = false;
    }

    public boolean isOpen(){
        return injectorOpen;
    }
}
