// package cm.uy1;

// import java.util.ArrayList;

// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

// class EquationOracleTest {

//     private final IEquation solveur = new SolveurDemo();

//     @Test
//     void testerDeuxRacinesReelles() {

//         // Arrange
//         double a = 1;
//         double b = -3;
//         double c = 2;

//         // Act
//         ArrayList<Double> racines = solveur.resoudre(a, b, c);

//         // Assert
//         OracleCompletude.verifier(a, b, c, racines);
//         OracleResidu.verifier(a, b, c, racines);
//     }

//     @Test
//     void testerRacineDouble() {

//         // Arrange
//         double a = 1;
//         double b = -2;
//         double c = 1;

//         // Act
//         ArrayList<Double> racines = solveur.resoudre(a, b, c);

//         // Assert
//         OracleCompletude.verifier(a, b, c, racines);
//         OracleResidu.verifier(a, b, c, racines);
//     }

//     @Test
//     void testerAbsenceDeRacineReelle() {

//         // Arrange
//         double a = 1;
//         double b = 0;
//         double c = 1;

//         // Act
//         ArrayList<Double> racines = solveur.resoudre(a, b, c);

//         // Assert
//         OracleCompletude.verifier(a, b, c, racines);
//         OracleResidu.verifier(a, b, c, racines);
//     }

//     @Test
//     void testerCoefficientAZero() {

//         // Arrange
//         double a = 0;
//         double b = 2;
//         double c = 1;

//         // Act et Assert
//         assertThrows(
//             IllegalArgumentException.class,
//             () -> solveur.resoudre(a, b, c)
//         );
//     }
// }