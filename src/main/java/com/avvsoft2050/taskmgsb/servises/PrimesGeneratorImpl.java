package com.avvsoft2050.taskmgsb.servises;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Class generates primes
 * @author obtained on the internet
 * @version 1.0
 *
 */
@Service
public class PrimesGeneratorImpl implements PrimesGenerator{

    @Override
    public ArrayList<Integer> getFirstPrimes(int count) {
        ArrayList<Integer> primes = new ArrayList<>();
        if (count > 0) {
            primes.add(2);
        }
        for (int i = 3; primes.size() < count; i += 2) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private boolean isPrime(int n, List<Integer> primes) {
        double sqrt = Math.sqrt(n);
        for (int prime : primes) {
            if (prime > sqrt) {
                return true;
            }
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }
}
