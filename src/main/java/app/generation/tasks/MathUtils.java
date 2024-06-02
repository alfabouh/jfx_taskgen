package app.generation.tasks;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;

public class MathUtils {
    public static double laplace(double x) {
        int i = x < 0 ? -1 : 1;
        UnivariateFunction integrand = z -> Math.exp(-z * z / 2);
        SimpsonIntegrator integrator = new SimpsonIntegrator();
        double integral = integrator.integrate(3000, integrand, 0, x * i);
        double sqrt2pi = Math.sqrt(2 * Math.PI);
        return (1 / sqrt2pi * integral) * i;
    }

    public static double factorial(int n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
