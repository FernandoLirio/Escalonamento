import java.util.ArrayList;
import java.util.List;

class Tarefas{
    private String nome;//Atributos para armazenar o nome da tarefa
    private int prioridades;//Atributos para armazenar a prioridade das tarefas

    public Tarefas(String nome, int prioridades){///Aqui fica os construtores
        this.nome = nome;
        this.prioridades = prioridades;
    }

    public String getNome(){
        return nome;
    }

    public int getPrioridades() {
        return prioridades;
    }
}
/////////////////////////Nessa parte é a classe tarefa//////////////////////
class Escalador{
    private List<Tarefas>tarefas;

    public Escalador(){
        tarefas = new ArrayList<>();
    }
    public void adicionaTarefa(Tarefas tarefa){
        tarefas.add(tarefa);
    }

    public void executaTarefa() {
        while (!tarefas.isEmpty()) {
            Tarefas tarefaPrioridade = encontraTarefa();
            System.out.println("Executando tarefa" + tarefaPrioridade.getNome());
            tarefas.remove(tarefaPrioridade);
        }
    }

    public Tarefas encontraTarefa(){
        if (tarefas.isEmpty()) {
            return null;
        }

        Tarefas tarefaPrioridade = tarefas.get(0);
        for (Tarefas tarefa : tarefas){
            if (tarefa.getPrioridades() > tarefaPrioridade.getPrioridades()){
                tarefaPrioridade = tarefa;
            }

        }
        return tarefaPrioridade;
    }
}
///////////////////////AQUI A CLASSE ESCALADOR


public class Main {
    public static void main(String[] args){
        Escalador escalador = new Escalador();

        escalador.adicionaTarefa(new Tarefas("Tarefa 1", 3));
        escalador.adicionaTarefa(new Tarefas("Tarefa 2", 1));
        escalador.adicionaTarefa(new Tarefas("Tarefa 3", 1));
        escalador.adicionaTarefa(new Tarefas("Tarefa 4", 2));
        escalador.adicionaTarefa(new Tarefas("Tarefa 5", 2));

        escalador.executaTarefa();
    }
}
