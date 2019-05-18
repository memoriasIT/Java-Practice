package dataStructures.queue;

public class EmptyDoubleEndedQueueException extends RuntimeException {
    public EmptyDoubleEndedQueueException() {
        super();
    }

    public EmptyDoubleEndedQueueException(String msg) {
        super(msg);
    }
}
