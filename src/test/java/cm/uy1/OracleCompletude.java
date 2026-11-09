package cm.uy1;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

public class OracleCompletude {

    public static void verifier(
            double a,
            double b,
            double c,
            ArrayList<Double> racines) {

        // Vérifier que les coefficients sont valides
        Assertions.assertTrue(
            Double.isFinite(a) && Double.isFinite(b)
                && Double.isFinite(c),
            "Les coefficients doivent être des nombres finis"
        );

        Assertions.assertNotEquals(
            0.0, a,
            "Le coefficient a doit être différent de zéro"
        );

        Assertions.assertNotNull(
            racines,
            "La liste des racines ne doit pas être null"
        );

        // Calculer le discriminant avec BigDecimal
        BigDecimal A = BigDecimal.valueOf(a);
        BigDecimal B = BigDecimal.valueOf(b);
        BigDecimal C = BigDecimal.valueOf(c);

        BigDecimal delta = B.multiply(B)
            .subtract(BigDecimal.valueOf(4)
            .multiply(A)
            .multiply(C));

        // Déterminer le nombre de racines attendu
        int nombreAttendu;

        if (delta.signum() > 0) {
            nombreAttendu = 2;
        } else if (delta.signum() == 0) {
            nombreAttendu = 1;
        } else {
            nombreAttendu = 0;
        }

        // Comparer avec le nombre de racines retournées
        Assertions.assertEquals(
            nombreAttendu,
            racines.size(),
            "Nombre de racines incorrect. Discriminant = " + delta
        );

        // Vérifier que les racines retournées sont finies
        for (Double racine : racines) {
            Assertions.assertNotNull(racine, "Une racine ne doit pas être null");
            Assertions.assertTrue(
                Double.isFinite(racine),
                "Une racine doit être un nombre fini"
            );
        }
    }
}