package kaua.vidal.dcx.ufpb.br;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String email;
    private String senha;  //Para autenticação
    private List<Tarefa> tarefas;   // Lista de tarefas do usuário

    private Usuario (String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
    }

    public void removerTarefa(Tarefa tarefa){
        tarefas.remove(tarefa);
    }

    public List<Tarefa> getTarefas(){
        return tarefas;
    }

    public String getNome(){
        return this.nome;
    }

    public boolean autenticarSenha(String senhaDigitada){
        return this.senha.equals(senhaDigitada);
    }
}
