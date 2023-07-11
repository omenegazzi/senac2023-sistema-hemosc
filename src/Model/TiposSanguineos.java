package Model;

public class TiposSanguineos {

    public int getEstoque() {
        return Estoque;
    }

    public void setEstoque(int Estoque) {
        this.Estoque = Estoque;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getFator_rh() {
        return Fator_rh;
    }

    public void setFator_rh(String fator_rh) {
        this.Fator_rh = Fator_rh;
    }
    private int Estoque;
    private String Descricao, Fator_rh;
}
