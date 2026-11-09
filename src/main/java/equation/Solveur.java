
package equation;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;

import cm.uy1.IEquation;

public class Solveur implements IEquation {

    private static final MathContext MC = MathContext.DECIMAL128;

    @Override
    public ArrayList<Double> resoudre(double a, double b, double c) {

        // 1. Vérification des coefficients
        if (!Double.isFinite(a)
                || !Double.isFinite(b)
                || !Double.isFinite(c)) {
            throw new IllegalArgumentException(
                "Les coefficients doivent être des nombres finis."
            );
        }

        if (a == 0.0) {
            throw new IllegalArgumentException(
                "Le coefficient a doit être différent de zéro."
            );
        }

        // 2. Conversion en BigDecimal
        BigDecimal A = BigDecimal.valueOf(a);
        BigDecimal B = BigDecimal.valueOf(b);
        BigDecimal C = BigDecimal.valueOf(c);

        // 3. Calcul précis du discriminant
        BigDecimal delta = B.multiply(B)
                .subtract(A.multiply(C).multiply(BigDecimal.valueOf(4)));

        ArrayList<Double> resultats = new ArrayList<>();

        // 4. Aucun résultat réel
        if (delta.signum() < 0) {
            return resultats;
        }

        // 5. Racine double
        if (delta.signum() == 0) {
            BigDecimal x = B.negate()
                    .divide(A.multiply(BigDecimal.valueOf(2)), MC);

            ajouterRacine(resultats, x);
            return resultats;
        }

        // 6. Deux racines réelles distinctes
        BigDecimal racineDelta = delta.sqrt(MC);

        BigDecimal signe = B.signum() < 0
                ? BigDecimal.valueOf(-1)
                : BigDecimal.ONE;

        // Formule stable pour éviter les pertes de précision
        BigDecimal q = B.add(signe.multiply(racineDelta))
                .multiply(BigDecimal.valueOf(-0.5));

        BigDecimal x1 = q.divide(A, MC);
        BigDecimal x2 = C.divide(q, MC);

        ajouterRacine(resultats, x1);
        ajouterRacine(resultats, x2);

        Collections.sort(resultats);

        return resultats;
    }

    private void ajouterRacine(
            ArrayList<Double> resultats,
            BigDecimal racine) {

        double valeur = racine.doubleValue();

        if (!Double.isFinite(valeur)) {
            throw new ArithmeticException(
                "Une racine dépasse la capacité du type Double."
            );
        }

        resultats.add(valeur);
    }
}
