package se.iths;


import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class StringBeginsWithLowerCaseMatcher extends TypeSafeMatcher<String> {

    public static StringBeginsWithLowerCaseMatcher beginsWithLowerCase(){
        return new StringBeginsWithLowerCaseMatcher();
    }


    @Override
    protected boolean matchesSafely(String s) {
        return s.substring(0,1).toLowerCase().equals(s.substring(0,1));

    }

    @Override
    public void describeTo(Description description) {

        description.appendText("Expected a string starting with lower case");

    }
}
