package cm.uy1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

class EquationPairwiseTest {

              // Arrange : préparer le nom de la classe
        // String nomClasse = "cm.uy1.SolveurDemo";
            String nomClasse = "equation.Solveur";


        // Act : charger dynamiquement la classe



    @ParameterizedTest(name = "Cas {index} : a={0}, b={1}, c={2}")
    @MethodSource("cm.uy1.PairwiseGenerator#fournirCas")
    void testerCombinaisonPairwise(double a, double b, double c) {
        
         // Arrange : charger le solveur
    IEquation solveur;

    try {
        solveur = EquationLoader.charger(nomClasse);
    } catch (ReflectiveOperationException e) {
        throw new RuntimeException(
            "Impossible de charger le solveur", e
        );
    }

    // Cas invalide : a = 0
    if (a == 0.0) {

        assertThrows(
            IllegalArgumentException.class,
            () -> solveur.resoudre(a, b, c),
            "Le solveur doit refuser a = 0"
        );

    } else {

        // Act : résoudre l'équation
        ArrayList<Double> racines =
            solveur.resoudre(a, b, c);

        // Assert : vérifier les résultats
        OracleCompletude.verifier(a, b, c, racines);
        OracleResidu.verifier(a, b, c, racines);
    }
}

    
    }
