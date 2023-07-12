/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import Connection.conexaoMysql;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import static net.sf.dynamicreports.report.builder.expression.Expressions.dataSource;
import net.sf.dynamicreports.report.exception.DRException;
import java.sql.Connection;

/**
 *
 * @author MuriloComim
 */
public class RelatorioDAO {

    private Connection conn = conexaoMysql.conexao();
    
    public void buildCidades(String Cidade,int DataInicial, int DataFinal) {
        if(Cidade.equals("Todas"))
           Cidade = "";
        else
            Cidade = "cidades.descricao = '"+Cidade+"' and";
        String SQL = ("select doacoes.id_doacao,doadores.nome as Doador,tipos_sanguineos.descricao as TipoSanguineo,tipos_sanguineos.fator_rh as FatorRh,cidades.descricao as Cidade,doacoes.data from doacoes inner join doadores inner join cidades  inner join tipos_sanguineos on doacoes.fk_doadores_id_doador = id_doador and doadores.fk_cidades_id_cidade = id_cidade and doacoes.fk_tipos_sanguineos_id_tipo_sanguineo = tipos_sanguineos.id_tipo_sanguineo where "+Cidade+" data >= '"+DataInicial+"' and data <= '"+DataFinal+"';");
        
     try {
       report()
        .columns(
            col.column("Id", "id_doacao", type.integerType()),
            col.column("Doador", "Doador", type.stringType()),
            col.column("Tipo Sanguineo", "TipoSanguineo", type.stringType()),
            col.column("Fator Rh", "FatorRh", type.stringType()),
            col.column("Cidade", "Cidade", type.stringType()),
            col.column("Data", "data", type.dateType()))
        .title(cmp.text("Relatorio por Cidade                      Cidade:"))
        .setDataSource(SQL,conn)
        .show();
         
     } catch (DRException e) {
       e.printStackTrace();
     }
   }
}
