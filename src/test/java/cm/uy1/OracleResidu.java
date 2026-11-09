package cm.uy1;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

public class OracleResidu {

    private static final double EPSILON = 1e-12;

    public static void verifier(
            double a,
            double b,
            double c,
            ArrayList<Double> racines) {

        Assertions.assertNotNull(
            racines,
            "La liste des racines ne doit pas être null"
        );

        for (double x : racines) {

            // Assertions.assertTrue(
            //     Double.isFinite(x),
            //     "La racine doit être un nombre fini"
            // );

            double residu = Math.abs(a * x * x + b * x + c);

            double echelle =
                Math.abs(a) * x * x
                + Math.abs(b * x)
                + Math.abs(c);

            double tol = 10e-6;

            System.out.println(residu);

            Assertions.assertTrue(
                residu <= tol,
                "Résidu trop élevé pour la racine : " + residu
            );
        
        }
    }
}