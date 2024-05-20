import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        double salarioPretendido = 2000.0;

        Map<String, Double> salariosECandidatos = new HashMap<>();
        Map<String, Double> ligarCandidato = new HashMap<>();
        Map<String, Double> contraProposta = new HashMap<>();
        Map<String, Double> ultimoCaso = new HashMap<>();

        String[] candidatos = {"Alexandre", "Matheus", "Igor", "Oseias", "Guilherme", "Pedro", "Daniel", "Lucas"};


        for (String candidato : candidatos) {
            double salario = 1000.0 + (4000.0 - 1000.0) * random.nextDouble();
            salariosECandidatos.put(candidato, salario);
        }

        for (Map.Entry<String, Double> entry : salariosECandidatos.entrySet()) {
            if (ligarCandidato.size() >= 5) {
                break;
            }
            
            String candidato = entry.getKey();
            double salario = entry.getValue();

            if (salario < salarioPretendido) {
                ligarCandidato.put(candidato, salario);
            } else if (salario <= salarioPretendido + 500) {
                contraProposta.put(candidato, salario);
            } else {
                ultimoCaso.put(candidato, salario);
            }
        }

        if (ligarCandidato.size() >= 5) {
            System.out.println("Candidatos com salário pretendido dentro do proposto pela empresa:\n");
            for (Map.Entry<String, Double> entry : ligarCandidato.entrySet()) {
                System.out.println("Candidato: " + entry.getKey());
                System.out.println("Salário pretendido: R$ " + entry.getValue());
            }
        } else {
            if (ligarCandidato.isEmpty()) {
                System.out.println("Não há candidatos com salário dentro do pretendido");
            } else {
                System.out.println("Candidatos com salário pretendido dentro do proposto pela empresa:\n");
                for (Map.Entry<String, Double> entry : ligarCandidato.entrySet()) {
                    System.out.println("Candidato: " + entry.getKey());
                    System.out.println("Salário pretendido: R$ " + entry.getValue());
                }
            }

            if (contraProposta.isEmpty()) {
                System.out.println("Não há candidatos com salário muito próximo do pretendido");
            } else {
                System.out.println("Candidatos com salário pretendido no teto ou próximo do aceitável, ligar em segundo caso:\n");
                for (Map.Entry<String, Double> entry : contraProposta.entrySet()) {
                    System.out.println("Candidato: " + entry.getKey());
                    System.out.println("Salário pretendido: R$ " + entry.getValue());
                }
            }

            if (!ultimoCaso.isEmpty()) {
                System.out.println("Candidatos fora do proposto pela empresa, ligar de último caso:\n");
                for (Map.Entry<String, Double> entry : ultimoCaso.entrySet()) {
                    System.out.println("Candidato: " + entry.getKey());
                    System.out.println("Salário pretendido: R$ " + entry.getValue());
                }
            }
        }
    }
}
