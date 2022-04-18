package com.avvsoft2050.taskmgsb.controllers;

import com.avvsoft2050.taskmgsb.pojo.Primes;
import com.avvsoft2050.taskmgsb.pojo.PrimesCount;
import com.avvsoft2050.taskmgsb.servises.PrimesGeneratorImpl;
import com.avvsoft2050.taskmgsb.servises.RandomSixGenerator;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

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
        int count = Integer.parseInt(HtmlUtils.htmlEscape(primesCount.getCount()));
        StringBuilder fiveSequences = randomSixGenerator.getSixFiveTimes(count);
        return new Primes(fiveSequences);
    }
}
