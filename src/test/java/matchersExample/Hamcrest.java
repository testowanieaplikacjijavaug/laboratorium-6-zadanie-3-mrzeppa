package matchersExample;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Hamcrest {

    @Test
    public void AddingTwoFractionTest() {
        assertThat(Fraction.of(1, 2)
                .add(Fraction.of(1, 2)), equalTo(Fraction.FULL));
    }

    @Test
    public void MultiplyValuesTest() {
        assertThat(Fraction.of(1, 1)
                .multiply(Fraction.of(1, 2)), equalTo(Fraction.HALF));
    }

    @Test
    public void MultiplyDeterminTest() {
        assertThat(Fraction.of(0, 0).multiply(Fraction.of(1, 2)), equalTo(Fraction.INDETERMINATE));
    }

    @Test
    public void TestFullFraction() {
        assertThat(Fraction.of(1, 1), equalTo(Fraction.FULL));
    }

    @Test
    public void TestHalfFraction() {
        assertThat(Fraction.of(1, 2), equalTo(Fraction.HALF));
    }

    @Test
    public void TestOneThirdFraction() {
        assertThat(Fraction.of(1, 3), equalTo(Fraction.ONE_THIRD));
    }

    @Test
    public void TestGetDenominator() {
        assertThat(Fraction.of(1, 3).getDenominator(), equalTo(3));
    }

    @Test
    public void TestGetNominator() {
        assertThat(Fraction.of(1, 3).getNominator(), equalTo(1));
    }

    @Test
    public void TestWithDoubleValue() {
        assertThat(Fraction.of(1, 3).doubleValue(), allOf(greaterThan(0.2), lessThan(0.4)));
    }


    @Test
    public void ExceptionShouldBeRaisedWhenDividingBy0() {
        try {
            Fraction.of(1, 0);
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
            return;
        }
        assertThat(true, is(false));

    }


    @Test
    public void TestToStringShouldReturnStringValue() {
        assertThat(Fraction.of(0, 0).toString(), is("0/0"));
    }

}