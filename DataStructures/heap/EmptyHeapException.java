package dataStructures.heap;

//   /\  /\___  __ _ _ __
//  / /_/ / _ \/ _` | '_ \
// / __  /  __/ (_| | |_) |
// \/ /_/ \___|\__,_| .__/
// MemoriasIT - 2019|_|

public class EmptyHeapException extends RuntimeException {

    public EmptyHeapException(){
        super();
    }

    public EmptyHeapException(String msg){
        super(msg);
    }
}
