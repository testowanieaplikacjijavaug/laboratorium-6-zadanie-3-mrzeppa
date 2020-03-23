package matchersExample;

import java.io.Serializable;

import org.assertj.core.util.VisibleForTesting;

public final class Fraction implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Fraction of(final int nominator, final int denominator) {
        if (denominator == 0) {
            if (nominator == 0)
                return INDETERMINATE;
            throw new IllegalArgumentException("Fraction denominator cannot be equal to 0");
        }
        if (denominator == 1) {
            switch (nominator) {
                case 1:
                    return FULL;
                case 2:
                    return HALF;
                case 3:
                    return ONE_THIRD;
            }
        }
        return new Fraction(nominator, denominator);
    }

    public int getNominator() {
        return nominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public double doubleValue() {
        return (double) nominator / (double) denominator;
    }

    public Fraction add(Fraction a) {
        int denominator = this.denominator * a.denominator;
        int nominator = (this.nominator * a.denominator) + (this.denominator * a.nominator);
        if (nominator % denominator == 0) {
            nominator /= denominator;
            denominator = 1;
        }
        return of(nominator, denominator);
    }

    public Fraction multiply(Fraction a) {
        return new Fraction(nominator * a.nominator, denominator * a.denominator);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(nominator)
                .append('/')
                .append(denominator)
                .toString();
    }

    private Fraction(final int nominator, final int denominator) {
        this.denominator = denominator;
        this.nominator = nominator;
    }

    public static final Fraction INDETERMINATE = new Fraction(0, 0);
    @VisibleForTesting
    static final Fraction FULL = new Fraction(1, 1);
    @VisibleForTesting
    static final Fraction HALF = new Fraction(1, 2);
    @VisibleForTesting
    static final Fraction ONE_THIRD = new Fraction(1, 3);
    private final int nominator;
    private final int denominator;
}