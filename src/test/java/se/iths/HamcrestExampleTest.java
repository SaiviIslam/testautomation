package se.iths;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class HamcrestExampleTest {
    @Test

    public void myFirstHamcrestTest() {
        String myMessage = "Apa!";
        assertThat(myMessage, is(equalTo("Apa!")));

    }

    @Test

    public void myFirstHamcrestListTest() {

        List<String> myAnimalList = Collections.singletonList("Apa");
        assertThat(myAnimalList,hasItem("Apa"));

    }

}