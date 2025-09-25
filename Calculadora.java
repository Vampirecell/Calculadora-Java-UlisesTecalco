import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("\n--- Calculadora ---");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");

            try {
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();

                if (opcion == 5) {
                    salir = true;
                    System.out.println("¡Hasta luego!");
                }

                if (opcion < 1 || opcion > 5) {
                    System.out.println("Error: Opción no válida. Inténtalo de nuevo.");
                    continue;
                }

                System.out.print("Ingresa el primer número: ");
                double num1 = scanner.nextDouble();
                System.out.print("Ingresa el segundo número: ");
                double num2 = scanner.nextDouble();

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado: " + Operaciones.sumar(num1, num2));
                        break;
                    case 2:
                        System.out.println("Resultado: " + Operaciones.restar(num1, num2));
                        break;
                    case 3:
                        System.out.println("Resultado: " + Operaciones.multiplicar(num1, num2));
                        break;
                    case 4:
                        try {
                            System.out.println("Resultado: " + Operaciones.dividir(num1, num2));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido. Inténtalo de nuevo.");
                scanner.next();
            }
        }
        scanner.close();
    }
}