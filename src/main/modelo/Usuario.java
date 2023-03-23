package main.modelo;

import java.util.Objects;

public class Usuario {

    private String login;
    private String senha;


    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public boolean ehIgual(String login, String senha) {
        if(!this.login.equals(login)) return false;
        return this.senha.equals(senha);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;

        Usuario usuario = (Usuario) o;

        if (!login.equals(usuario.login)) return false;
        return senha.equals(usuario.senha);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + senha.hashCode();
        return result;
    }
}
