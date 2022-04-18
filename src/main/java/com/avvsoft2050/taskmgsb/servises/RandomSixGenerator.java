package com.avvsoft2050.taskmgsb.servises;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class RandomSixGenerator {

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

//    public static void main(String[] args) {
//        System.out.println("start");
//        RandomSixGenerator randomSixGenerator = new RandomSixGenerator();
//        PrimesGenerator primesGenerator = new PrimesGeneratorImpl();
//        ArrayList<Integer> primesList = primesGenerator.getFirstPrimes(100);
//        ArrayList<Integer> sixPrimes = randomSixGenerator.getSix(primesList);
//        System.out.println("generated");
//        System.out.println(sixPrimes.toString());
//        System.out.println("stop");
//    }
}
