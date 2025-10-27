package com.manuel.proyecto;

/**
 * Clase de ejemplo en un único archivo que demuestra:
 * - Implementación anónima de la interfaz funcional.
 * - Uso de expresiones lambda.
 * - Uso de métodos estáticos de fábrica definidos en la interfaz.
 *
 * Este archivo es adecuado como ejemplo para formación.
 */
public class Main {
    public static void main(String[] args) {
        // Implementación anónima clásica (suma)
        Operacion operacion = new Operacion() {
            @Override
            public int operador(int a, int b) {
                return a + b;
            }
        };
        int result = operacion.operador(5, 3);
        System.out.println("El resultado de la suma: " + result);

        // Lambda para multiplicación
        Operacion multiplicacion = (a, b) -> a * b;
        System.out.println("El resultado de la multiplicación: " + multiplicacion.operador(5, 3));

        // Lambda para división (nota: división entera)
        Operacion division = (a, b) -> a / b;
        System.out.println("El resultado de la división: " + division.operador(10, 2));

        // Uso del método default de la interfaz
        System.out.println(operacion.descripcion());

        // Uso de métodos estáticos de fábrica en la interfaz
        Operacion resta = Operacion.resta();
        System.out.println("Resta 10 - 4 = " + resta.operador(10, 4));

        Operacion modulo = Operacion.modulo();
        System.out.println("Módulo 10 % 3 = " + modulo.operador(10, 3));
    }
}

/**
 * Interfaz funcional que representa una operación entre dos enteros.
 *
 * Está en el mismo archivo por simplicidad en ejemplos de formación.
 */
@FunctionalInterface
interface Operacion {

    /**
     * Ejecuta la operación sobre dos operandos enteros.
     *
     * @param a primer operando
     * @param b segundo operando
     * @return resultado de la operación
     */
    int operador(int a, int b);

    /**
     * Descripción por defecto de la interfaz (en español).
     *
     * @return texto descriptivo
     */
    default String descripcion() {
        return "Interfaz funcional para operaciones matemáticas (ejemplo formativo).";
    }

    /**
     * Fábrica que devuelve una implementación de resta (a - b).
     *
     * @return instancia de Operacion que realiza la resta
     */
    static Operacion resta() {
        return (a, b) -> a - b;
    }

    /**
     * Fábrica que devuelve una implementación de módulo (a % b).
     *
     * @return instancia de Operacion que calcula el módulo
     */
    static Operacion modulo() {
        return (a, b) -> a % b;
    }
}