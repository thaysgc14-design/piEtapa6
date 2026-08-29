
package Classes;


public class Cliente {
    
    private String nome , CPF , DataNasc , TelefoneCli;
   

    public Cliente(String nome, String CPF, String DataNasc, String TelefoneCli) {
        this.nome = nome;
        this.CPF = CPF;
        this.DataNasc = DataNasc;
        this.TelefoneCli = TelefoneCli;
       
    }
    public Cliente(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNasc() {
        return DataNasc;
    }

    public void setDataNasc(String DataNasc) {
        this.DataNasc = DataNasc;
    }

    public String getTelefoneCli() {
        return TelefoneCli;
    }

    public void setTelefoneCli(String TelefoneCli) {
        this.TelefoneCli = TelefoneCli;
    }

  

    
    
    
    
    
    
}
