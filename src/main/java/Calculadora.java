import java.util.Collections;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Calculadora {

    private static IntBinaryOperator suma = (a,b) -> a + b;

    private static IntBinaryOperator resta = (a,b) -> a - b;

    private static IntBinaryOperator multiplicacion = (a,b) -> {
        return Collections.nCopies(Math.abs(a), Math.abs(b))
                .stream()
                .reduce(Integer::sum)
                .get();
    };

    //Si el denominador es cero, devualve cero
    // Si el denominador es mayor que el numerador arroja cero
    private static IntBinaryOperator divisionEntera = (a,b) -> {
        return b==0 ? 0 : a>=b ? (int) IntStream.iterate(a, i -> i >= 0, i -> i - b).count() -1 : 0;

    };

    public static void main(String[] args) {

        System.out.println(suma.applyAsInt(7,2));
        System.out.println(resta.applyAsInt(7,8));
        System.out.println(multiplicacion.applyAsInt(7,2));
        System.out.println(divisionEntera.applyAsInt(5,2));


    }
}
