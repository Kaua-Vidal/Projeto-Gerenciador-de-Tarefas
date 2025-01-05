package kaua.vidal.dcx.ufpb.br;

import java.time.LocalDate;
import java.util.Objects;

public class Tarefa {

    private String tituloTarefa;
    private String descricaoTarefa;
    private LocalDate prazo;
    private String prioridade; // baixa - média - alta
    private boolean concluida;
    private Categoria categoria;


    public Tarefa(String tituloTarefa, String descricaoTarefa, String prioridade, Categoria categoria, LocalDate prazo) {
        this.tituloTarefa = tituloTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.prazo = prazo;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.concluida = false;
    }

    //Metodos
    public void marcarConcluida(){
        this.concluida = true;
    }

    public void editar(String novoTitulo, String novaDescricaoTarefa, LocalDate novoPrazo, String novaPrioridade){
        this.tituloTarefa = novoTitulo;
        this.descricaoTarefa = novaDescricaoTarefa;
        this.prazo = novoPrazo;
        this.prioridade = prioridade;
    }

    public String getTituloTarefa(){
        return tituloTarefa;
    }

    public LocalDate getPrazo(){
        return this.prazo;
    }

    public boolean isConcluida(){
        return concluida;
    }

    @Override
    public String toString() {
        return tituloTarefa + " (" + prioridade + ") - Prazo: " + prazo + " - Concluída: " + concluida;
    }
}
