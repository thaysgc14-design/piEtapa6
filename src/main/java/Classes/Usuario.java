
package Classes;


public class Usuario {
    
    String nomeUsu ,  DataNas ,Funcao , login ,Senha;

    public Usuario(String nomeUsu, String DataNas, String Funcao, String login, String Senha) {
        this.nomeUsu = nomeUsu;
        this.DataNas = DataNas;
        this.Funcao = Funcao;
        this.login = login;
        this.Senha = Senha;
    }

    public String getNomeUsu() {
        return nomeUsu;
    }

    public void setNomeUsu(String nomeUsu) {
        this.nomeUsu = nomeUsu;
    }

    public String getDataNas() {
        return DataNas;
    }

    public void setDataNas(String DataNas) {
        this.DataNas = DataNas;
    }

    public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String Funcao) {
        this.Funcao = Funcao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
        
    public Usuario() {
    
    
}
    
    
    
    
    
    
}
