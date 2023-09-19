package org.ipan.concurrency.notThreadSafeController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

// Solution 1: make it thread safe by adding synchronized keyword to the method
// Solution 2: Make this controller stateless
@RestController
public class NotThreadSafeController {
    private BigInteger result;

    @GetMapping("/factorial")
    public BigInteger getFactorial(@RequestParam Integer factorial) throws InterruptedException {
        this.result = calc(BigInteger.valueOf(factorial));
        Thread.sleep(200);
        return this.result;
    }

    BigInteger calc(BigInteger factorial) {
        if (BigInteger.ZERO.equals(factorial)) {
            return BigInteger.ONE;
        }
        return factorial.multiply(calc(factorial.subtract(BigInteger.ONE)));
    }

}
