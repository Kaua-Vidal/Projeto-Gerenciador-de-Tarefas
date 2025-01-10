package kaua.vidal.dcx.ufpb.br;

import java.time.LocalDate;
import java.util.*;

public class GerenciadorDeTarefas {

    private Map<String, Usuario> usuarios;
    private Map<String, Categoria> categorias;
    private Usuario usuarioLogado;

    public GerenciadorDeTarefas(){
        this.usuarios = new HashMap<>();
        this.categorias = new HashMap<>();
        this.usuarioLogado = null;
    }

    public boolean cadastraUsuario(Usuario u) throws UsuarioJaCadastradoException{
        if (!usuarios.containsKey(u.getEmail())){
            usuarios.put(u.getEmail(), u);
            return true;
        } else {
            throw new UsuarioJaCadastradoException("Usuário já cadastrado");
        }

    }

    public boolean login(String email, String senha){
        Usuario usuario = usuarios.get(email);

        if (usuario != null && usuario.autenticarSenha(senha)){
            usuarioLogado = usuario;
            return true;
        }

        return false;
    }

    public void logout(){
        usuarioLogado = null;
    }

    public boolean criarTarefa(String titulo, String descricao, String prioridade, Categoria nomeCategoria, LocalDate prazo){

        if(usuarioLogado == null){
            return false;
        }

        Tarefa tarefa = new Tarefa(titulo, descricao, prioridade, nomeCategoria, prazo);

        usuarioLogado.adicionarTarefa(tarefa);

        return true;
    }

    public List<Tarefa> listarTarefas(){
        if (usuarioLogado == null){
            return Collections.emptyList();
        }

        return usuarioLogado.getTarefas();
    }

    public void removerTarefa(Tarefa t){
        if (usuarioLogado == null){
            return;
        }

        usuarioLogado.removerTarefa(t);
    }

    /**
     * o Set<String> serve para criar uma lista sem que haja
     * elementos duplicados nela.
     * @return
     */
    public Set<String> listarCategorias(){
        return categorias.keySet();
    }

    public void salvarDados(){
        Persistencia.salvar("usuarios.json", usuarios);
    }

    public void carregarDados(){
        usuarios = Persistencia.carregar("usuarios.json");
    }
}
