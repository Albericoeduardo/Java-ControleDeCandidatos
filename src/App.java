import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"Felipe", "Marcia", "Paulo", "Augusto", "Julia"};
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    private static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("Contato realizado com sucesso");
            }
        } while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("Contatamos o "+candidato+" na "+tentativasRealizadas+" tentativa");
        }else{
            System.out.println("Não conseguimos contato com "+candidato+" em "+tentativasRealizadas+" tentativas");
        }
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatosSelecionados = {"Felipe", "Marcia", "Paulo", "Augusto", "Julia"};
        for(String i : candidatosSelecionados){
            System.out.println("O candidato selecionado foi "+i);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Felipe", "Marcia", "Paulo", "Augusto", "Julia", "Monica", "Fabricio"};
        
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato "+ candidato + " Solicitou este valor de salário "+salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato "+ candidato + " foi selecionado");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
        
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        } else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para com a contra proposta");
        } else{
            System.out.println("Aguardando resultado");
        }
    }
}
