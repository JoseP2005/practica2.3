package mates;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Clase principal para calcular una aproximación de PI mediante el método de Montecarlo.
 * Permite al usuario especificar el número de puntos a utilizar para la simulación.
 */
public class MatematicasL {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de puntos para la simulación: ");
        final int NUM_PUNTOS = scanner.nextInt();

        Random random = new Random();

        long puntosDentroDelCirculo = IntStream.range(0, NUM_PUNTOS)
                .parallel()
                .filter(i -> {
                    double x = random.nextDouble() * 2 - 1;
                    double y = random.nextDouble() * 2 - 1;
                    return x * x + y * y <= 1;
                })
                .count();

        double piAproximado = 4.0 * puntosDentroDelCirculo / NUM_PUNTOS;

        System.out.println("Aproximación de PI usando simulación de Montecarlo: " + piAproximado);
    }
}
