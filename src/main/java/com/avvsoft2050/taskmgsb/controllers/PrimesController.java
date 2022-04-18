package com.avvsoft2050.taskmgsb.controllers;

import com.avvsoft2050.taskmgsb.pojo.Primes;
import com.avvsoft2050.taskmgsb.pojo.PrimesCount;
import com.avvsoft2050.taskmgsb.servises.PrimesGeneratorImpl;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;

@Controller
public class PrimesController {

    private final PrimesGeneratorImpl primesGenerator;

    public PrimesController(PrimesGeneratorImpl primesGenerator) {
        this.primesGenerator = primesGenerator;
    }

    @MessageMapping("/generate")
    @SendTo("/topic/primes")
    public Primes generatePrimes(PrimesCount primesCount) {
        ArrayList<Integer> primesList = primesGenerator
                .getFirstPrimes(Integer.parseInt(HtmlUtils.htmlEscape(primesCount.getCount())));
        System.out.println(primesList.toString());
        return new Primes(primesList.toString());
    }

}
