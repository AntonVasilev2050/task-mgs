package com.avvsoft2050.taskmgsb.servises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
@Service
public class RandomSixGenerator {
    @Autowired
    PrimesGenerator primesGenerator;

    /**
     *
     * @param primesList list of primes
     * @return return 6 random numbers from primesList
     */
    public ArrayList<Integer> getSix(ArrayList<Integer> primesList) {
        int howManyGenerate = 6;
        ArrayList<Integer> sixPrimes = new ArrayList<>(howManyGenerate);
        Random random = new Random();
        while (sixPrimes.size() < howManyGenerate) {
            int nextIndex = random.nextInt(primesList.size());
            if (!(sixPrimes.contains(primesList.get(nextIndex)))) {
                sixPrimes.add(primesList.get(nextIndex));
            }
        }
        return sixPrimes;
    }

    /**
     *
     * @param count quantity of primes in the base sequence
     * @return return five sequences; six random numbers in each;
     */
    public StringBuilder getSixFiveTimes(int count){
        StringBuilder fiveSequences = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> primesList = primesGenerator
                    .getFirstPrimes(count);
            ArrayList<Integer> sixPrimes = getSix(primesList);
            fiveSequences.append("Sequence #").append(i).append(" ").append(sixPrimes).append(System.lineSeparator());
        }
        return fiveSequences;
    }
}
