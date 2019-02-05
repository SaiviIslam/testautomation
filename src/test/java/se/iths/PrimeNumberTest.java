package se.iths;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeNumberTest {

    @Test
    public void simplePrimeTest(){

       List<Integer> primes = new PrimeNumber().getPrimeNumbersBetween(10,20);

        assertThat(primes.get(0), is(11));
    }
}
