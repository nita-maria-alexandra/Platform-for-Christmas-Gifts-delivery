package writeo;

import java.util.List;

public class AnnualChildren {
    private final java.util.List<Children> annualChildren = new java.util.ArrayList<>();

    /**
     *
     * @return returneaza @annualChildren
     */
    public java.util.List<Children> getAnnualChildren() {
        return annualChildren;
    }

    /**
     *
     * Suprascrie metoda toString()
     */
    @Override
    public String toString() {
        return "annualChildren{"
                + "annualChildren="
                + annualChildren
                + '}';
    }
}
