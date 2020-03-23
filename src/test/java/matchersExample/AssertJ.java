package matchersExample;
import matchersExample.Fraction;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class AssertJ {

    @Test
    public void AddingTwoFractionTest() {
        assertThat(Fraction.of(1,2)
                .add(Fraction.of(1,2)))
                .isEqualTo(Fraction.FULL);
    }
    @Test
    public void MultiplyValuesTest() {
        assertThat(Fraction.of(1,1)
                .multiply(Fraction.of(1,2)))
                .isEqualTo(Fraction.HALF);
    }
    @Test
    public void MultiplyDeterminTest() {
        assertThat(Fraction.of(0,0)
                .multiply(Fraction.of(1,2)))
                .isEqualTo(Fraction.INDETERMINATE);
    }

    @Test
    public void TestFullFraction() {
        assertThat(Fraction.of(1,1))
                .isEqualTo(Fraction.FULL);
    }
    @Test
    public void TestHalfFraction() {
        assertThat(Fraction.of(1,2))
                .isEqualTo(Fraction.HALF);
    }
    @Test
    public void TestOneThirdFraction() {
        assertThat(Fraction.of(1,3))
                .isEqualTo(Fraction.ONE_THIRD);
    }
    @Test
    public void TestGetDenominator() {
        assertThat(Fraction.of(1,3)
                .getDenominator()).isEqualTo(3);
    }
    @Test
    public void TestGetNominator() {
        assertThat(Fraction.of(1,3)
                .getNominator()).isEqualTo(1);
    }

    @Test
    public void TestWithDoubleValue() {
        assertThat(Fraction.of(1,3)
                .doubleValue()).isGreaterThan(0.3).isLessThan(0.4);
    }
    @Test
    public void ExceptionShouldBeRaisedWhenDividingBy0() {

        try {
            Fraction.of(1, 0);
            failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Test
    public void TestToStringShouldReturnStringValue() {
        assertThat(Fraction.of(0,0).toString())
                .contains("0/0");
    }

}