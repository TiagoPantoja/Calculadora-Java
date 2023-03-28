import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double valorUm;
        double valorDois;
        String operacao;
        boolean continuar;

        try {
            do {
                System.out.println("Usuário, digite o primeiro valor: ");
                valorUm = sc.nextDouble();

                System.out.println("Usuário, digite a operação: (+, -, *, /)");
                operacao = sc.next();

                System.out.println("Usuário, digite o segundo valor: ");
                valorDois = sc.nextDouble();

                System.out.println("O resultado da operação é: " + realizarCalculo(valorUm, valorDois, operacao));

                continuar = verificarNovaOperacao();
            } while (continuar);
        } catch (InputMismatchException ex) {
            System.out.println("Os valores para cálculo devem ser numéricos");
        }
    }


    public static boolean verificarNovaOperacao() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Deseja realizar outra operação? (S ou N?):");
        return !sc.nextLine().toUpperCase(Locale.ROOT).equals("N");
    }

    public static double realizarCalculo(double valorUm, double valorDois, String operacao) {
        double respostaCalculo = 0.0;

        switch (operacao) {
            case "+":
                respostaCalculo = valorUm + valorDois;
                break;
            case "-":
                respostaCalculo = valorUm - valorDois;
                break;
            case "*":
                respostaCalculo = valorUm * valorDois;
                break;
            case "/":
                respostaCalculo = valorUm / valorDois;
                break;
            default:
                System.out.println("Operação inválida");
        }

        return respostaCalculo;
    }
}
