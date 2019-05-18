package dataStructures.hashTable;

// MemoriasIT -2019   _    _____      _     _
//     /\  /\__ _ ___| |__/__   \__ _| |__ | | ___
//    / /_/ / _` / __| '_ \ / /\/ _` | '_ \| |/ _ \
//   / __  / (_| \__ \ | | / / | (_| | |_) | |  __/
//   \/ /_/ \__,_|___/_| |_\/   \__,_|_.__/|_|\___|

// Generate size of arrays as prime numbers
public class HashPrimes {
    private static int primes[] =
            new int[] { 53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593
                    , 49157,	98317, 196613, 393241, 786433, 1572869, 3145739
                    , 6291469, 12582917,	25165843,	50331653,	100663319
                    , 201326611,	402653189, 805306457, 1610612741
            };

    // Returns a prime number from the list given a n
    public static int primeGreaterThan(int n) {
        int i = 0;
        while((i<primes.length) && (primes[i] <= n))
            i++;

        if(i>=primes.length)
            throw new RuntimeException("HashPrime.upperPrime: argument "+n+" too large");
        else
            return primes[i];
    }

    // Returns prime number greater than 2*n
    public static int primeDoubleThan(int n) {
        return primeGreaterThan(n+1);
    }


}
