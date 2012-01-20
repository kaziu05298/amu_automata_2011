package pl.edu.amu.wmi.daut.re;

import java.util.List;

import pl.edu.amu.wmi.daut.base.AutomataOperations;
import pl.edu.amu.wmi.daut.base.AutomatonSpecification;

/**
 * Klasa reprezentująca operator '^' z wyrażeń regularnych
 * (dowolna liczba wystąpień, w szczególności brak).
 */
public class NegationOperator extends UnaryRegexpOperator {

    @Override
    public final AutomatonSpecification createAutomatonFromOneAutomaton(
            AutomatonSpecification subautomaton) {
        return AutomataOperations.reverseLanguageAutomaton(subautomaton);
    }

    /**
     * Fabryka operatora.
     */
    public static class Factory extends UnaryRegexpOperatorFactory {

        @Override
        public int numberOfParams() {
            return 0;
        }

        protected RegexpOperator doCreateOperator(List<String> params) {
            return new NegationOperator();
        }
    }

    /**
     * Metoda toString().
     */
    @Override
    public String toString() {
        return "NEGATION";
    }

}
