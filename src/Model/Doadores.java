/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author murilo.comim
 */
public class Doadores {
    
    private int Id;
    private int CidadeId;
    private int TipoSanguineoId;
    private String Nome;
    private String Endereco;
    private int DataNascimento;
    private String Telefone;
    private String Email;
    private String Cpf;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCidadeId() {
        return CidadeId;
    }

    public void setCidadeId(int CidadeId) {
        this.CidadeId = CidadeId;
    }

    public int getTipoSanguineoId() {
        return TipoSanguineoId;
    }

    public void setTipoSanguineoId(int TipoSanguineoId) {
        this.TipoSanguineoId = TipoSanguineoId;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public int getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(int DataNascimento) {
        this.DataNascimento = DataNascimento;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }
    
    
}
