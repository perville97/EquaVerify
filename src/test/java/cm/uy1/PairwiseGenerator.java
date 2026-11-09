package cm.uy1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;

import io.github.pavelicii.allpairs4j.AllPairs;
import io.github.pavelicii.allpairs4j.Case;
import io.github.pavelicii.allpairs4j.Parameter;


public class PairwiseGenerator {

    public static Stream<Arguments> fournirCas() {

        AllPairs allPairs = new AllPairs.AllPairsBuilder()
            .withParameters(Arrays.asList(
                new Parameter("a",
                    // "GRAND_POSITIF",
                    // "GRAND_NEGATIF",
                    // "NUL",
                    "NOMINAL_POSITIF",
                    "NOMINAL_NEGATIF"
                    // "PETIT_POSITIF",
                    // "PETIT_NEGATIF",
                    // "PROCHE_ZERO_NEGATIF",
                    // "PROCHE_ZERO_POSITIF"
                ),

                new Parameter("b",
                    // "GRAND_POSITIF",
                    // "GRAND_NEGATIF",
                    // "NUL",
                    "NOMINAL_POSITIF",
                    "NOMINAL_NEGATIF"
                    // "PETIT_POSITIF",
                    // "PETIT_NEGATIF",
                    // "PROCHE_ZERO_NEGATIF",
                    // "PROCHE_ZERO_POSITIF"
                ),

                new Parameter("c",
                    // "GRAND_POSITIF",
                    // "GRAND_NEGATIF",
                    // "NUL",
                    "NOMINAL_POSITIF",
                    "NOMINAL_NEGATIF"
                    // "PETIT_POSITIF",
                    // "PETIT_NEGATIF",
                    // "PROCHE_ZERO_NEGATIF",
                    // "PROCHE_ZERO_POSITIF"
                )
            ))
            .build();

        List<Case> cas = allPairs.getGeneratedCases();

        return cas.stream().map(testCase ->
            Arguments.of(
                valeur(testCase.get("a").toString()),
                valeur(testCase.get("b").toString()),
                valeur(testCase.get("c").toString())
            )
        );
    }

    private static double valeur(String classe) {

        return switch (classe) {
            case "GRAND_POSITIF" -> 1e10;
            case "GRAND_NEGATIF" -> -1e10;
            case "NUL" -> 0;
            case "NOMINAL_POSITIF" -> 1e2;
            case "NOMINAL_NEGATIF" -> -1e2;
            case "PETIT_POSITIF" -> 1e-3;
            case "PETIT_NEGATIF" -> -1e-3;
            case "PROCHE_ZERO_NEGATIF" -> -1e-8;
            case "PROCHE_ZERO_POSITIF" -> 1e-8;
            default -> throw new IllegalArgumentException(
                "Classe inconnue : " + classe
            );
        };
    }
}