package se.iths;

import org.junit.Test;
import junit.homwork.StringUtility;
import org.junit.Assert;

public class StringUtilityTest {
    @Test
    public void camelCase() {

        StringUtility st = new StringUtility();
        String result = st.camelCase("Hej jag heter Johan");
        Assert.assertEquals(
                "HejJagHeterJohan",
                result
        );
    }

    @Test
    public void reverse() {
        StringUtility st = new StringUtility();
        String result = st.reverse("Johan");
        Assert.assertEquals(
                "nahoJ",
                result
        );
    }

    @Test
    public void isValidEmailAddress() {
        StringUtility st = new StringUtility();
        boolean result = st.isValidEmailAddress("saivi_islam@hotmail.com");
        Assert.assertEquals(
                true,
                result
        );


    }

    @Test
    public void isValidEmailAddressWithInvalidMailAddress() {
        StringUtility st = new StringUtility();
        boolean result1 = st.isValidEmailAddress("saivi_islam@hotmail");
        Assert.assertEquals(
                false,
                result1
        );
    }
}