package kaua.vidal.dcx.ufpb.br;

import java.io.Serial;

public class UsuarioJaCadastradoException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;
    public UsuarioJaCadastradoException(String mensagem){
        super(mensagem);
    }
}
