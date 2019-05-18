package dataStructures.PriorityQueue;

//     ___      _            _ _           ____
//    / _ \_ __(_) ___  _ __(_) |_ _   _  /___ \_   _  ___ _   _  ___
//   / /_)/ '__| |/ _ \| '__| | __| | | |//  / / | | |/ _ \ | | |/ _ \
//  / ___/| |  | | (_) | |  | | |_| |_| / \_/ /| |_| |  __/ |_| |  __/
//  \/    |_|  |_|\___/|_|  |_|\__|\__, \___,_\ \__,_|\___|\__,_|\___|
//  Memorias de un informático     |___/

public class EmptyPriorityQueueException extends RuntimeException {

    public EmptyPriorityQueueException() {
        super();
    }

    public EmptyPriorityQueueException(String msg) {
        super(msg);
    }

}
