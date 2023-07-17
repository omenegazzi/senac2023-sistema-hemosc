package Model;

public class Colaboradores {
    
    private int id;
    private String nome;
    private String Endereco;
    private String funcao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String nome() {
        return nome;
    }

    public void nome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return Endereco;
  
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getfuncao() {
        return funcao;
    }

    public void setfuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setNome(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setFuncao(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}