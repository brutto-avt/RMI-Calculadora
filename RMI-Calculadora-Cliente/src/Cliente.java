
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.rmi.Naming;

public class Cliente implements Serializable {
    static class Expressao {
        public long a;
        public long b;
        public String op;
    }

    public static void main(String args[]) {
        while (true) {
            try {
                CalculadoraInterface c = (CalculadoraInterface) Naming.lookup("calculadora");
                while (true) {
                    System.out.println("Expressão: ");
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    Expressao e = getExpressao(br.readLine());
                    if (e != null) {
                        if (e.op.equals("+")) {
                            System.out.println(c.somar(e.a, e.b));
                        } else if (e.op.equals("-")) {
                            System.out.println(c.subtrair(e.a, e.b));
                        } else if (e.op.equals("*")) {
                            System.out.println(c.multiplicar(e.a, e.b));
                        } else if (e.op.equals("/")) {
                            System.out.println(c.dividir(e.a, e.b));
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
    private static Expressao getExpressao(String exp) {
        try {
            Expressao e = new Expressao();
            if (exp.contains("+")) {
                e.a = Long.parseLong(exp.split("\\+")[0].trim());
                e.b = Long.parseLong(exp.split("\\+")[1].trim());
                e.op = "+";
                return e;
            } else if (exp.contains("-")) {
                e.a = Long.parseLong(exp.split("\\-")[0].trim());
                e.b = Long.parseLong(exp.split("\\-")[1].trim());
                e.op = "-";
                return e;
            } else if (exp.contains("*")) {
                e.a = Long.parseLong(exp.split("\\*")[0].trim());
                e.b = Long.parseLong(exp.split("\\*")[1].trim());
                e.op = "*";
                return e;
            } else if (exp.contains("/")) {
                e.a = Long.parseLong(exp.split("\\/")[0].trim());
                e.b = Long.parseLong(exp.split("\\/")[1].trim());
                e.op = "/";
                return e;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return null;
    }
    
}

