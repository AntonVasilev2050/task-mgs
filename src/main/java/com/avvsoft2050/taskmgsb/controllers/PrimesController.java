package com.avvsoft2050.taskmgsb.controllers;

import com.avvsoft2050.taskmgsb.pojo.Primes;
import com.avvsoft2050.taskmgsb.pojo.PrimesCount;
import com.avvsoft2050.taskmgsb.servises.PrimesGeneratorImpl;
import com.avvsoft2050.taskmgsb.servises.RandomSixGenerator;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;

@Controller
public class PrimesController {

    private final PrimesGeneratorImpl primesGenerator;
    private final RandomSixGenerator randomSixGenerator;

    public PrimesController(PrimesGeneratorImpl primesGenerator, RandomSixGenerator randomSixGenerator) {
        this.primesGenerator = primesGenerator;
        this.randomSixGenerator = randomSixGenerator;
    }

    @MessageMapping("/generate")
    @SendTo("/topic/primes")
    public Primes generatePrimes(PrimesCount primesCount) {
        StringBuilder fiveSequences = new StringBuilder();
        int count = Integer.parseInt(HtmlUtils.htmlEscape(primesCount.getCount()));
        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> primesList = primesGenerator
                    .getFirstPrimes(count);
            ArrayList<Integer> sixPrimes = randomSixGenerator.getSix(primesList);
            String sixPrimesStr = sixPrimes.toString();
            System.out.println("six: " + sixPrimesStr);
            fiveSequences.append("Sequence #").append(i).append(" ").append(sixPrimes).append(" \n");

        }
        return new Primes(fiveSequences);


    }

}
