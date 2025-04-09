package negocio.entidades;

import java.io.Serial;
import java.io.Serializable;

public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = -4009776605163947716L;

    private String nome;
    private boolean isVIP;
    private String login;
    private String senha;

    public Cliente(String nome,String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.isVIP = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getIsVIP() {
        return isVIP;
    }

    public void setIsVIP(boolean isVIP) {
        this.isVIP = isVIP;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
