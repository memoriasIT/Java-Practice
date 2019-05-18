package dataStructures.queue;

//     ____
//    /___ \_   _  ___ _   _  ___
//   //  / / | | |/ _ \ | | |/ _ \
//  / \_/ /| |_| |  __/ |_| |  __/
//  \___,_\ \__,_|\___|\__,_|\___|
// Memorias de un informático - 2018

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super();
    }

    public EmptyQueueException(String msg) {
        super(msg);
    }

}
