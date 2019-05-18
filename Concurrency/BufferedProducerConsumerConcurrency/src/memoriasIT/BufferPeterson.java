package memoriasIT;

public class BufferPeterson {
    // For mutual exclusion
    private volatile int turn = 0;
    private volatile boolean[] f = {false,false};

    // Peterson Buffer private components
    // Elements in buffer
    int items[];
    // index for producer
    int p;
    // index for consumer
    int c;
    // Number of elements stored
    int nItem;
    // Size of array
    final int N;


    public BufferPeterson(int size) {
        items = new int[size];
        N = size;
        p = 0;
        c = 0;
        nItem = 0;

    }

    // Producer ID = 0
    // Consumer ID = 1
    private void preProtocol(int id) {
        int other = (id+1)%2;

        f[id] = true;
        turn = other;
        while(f[other] && turn == other){
            Thread.yield();
        }
    }

    // Producer ID = 0
    // Consumer ID = 1
    private void postProtocol(int id){
        f[id] = false;
    }

    public boolean inserts(int data) {
        preProtocol(0);
        boolean ret;

        // Buffer is full
        if (nItem == N){
            ret = false;
        } else {
            ret = true;
            items[p] = data;

            // Update pointer of buffer and num of items
            nItem++;
            p = (p+1)%N;

        }
        postProtocol(0);
        return ret;
    }

    public Integer extracts() {
        preProtocol(1);
        Integer data;

        // Buffer is empty
        if (nItem == 0){
            data = null;
        }
        // Save data and update statistics
        data = items[c];
        nItem--;
        c = (c+1)%N;


        postProtocol(1);
        return data;
    }
}
