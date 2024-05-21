
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Estoque;


public class EstoqueDao extends ConectarDao {
    public void incluir(Estoque obj) {
        sql = "INSERT INTO EstoqueMaterial VALUES (null ,null , null, null, null, null, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, obj.getQtdMaterial());
            
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir Suprimento!" + err.getMessage());
        }
    }

    public ResultSet buscartodos() {
        sql = "SELECT * FROM EstoqueMaterial";
        try {
            ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar estoquetodos!"
                    + err.getMessage());
            return null;
        }
    }

    public ResultSet buscar(Estoque obj) {

        sql = "SELECT * FROM EstoqueMaterial WHERE nomeEquip = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, obj.getNomeEquip());
            ResultSet resul = ps.executeQuery();
           
            return resul;
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar EstouqeBuscar!"
                    + err.getMessage());
            return null;
        }
    }

    public void excluir(String nome) {

        sql = "DELETE FROM EstoqueMaterial WHERE nomeEquip = '" + nome + "'";
        try {
            ps = con.prepareStatement(sql);

            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir usuário!"
                    + err.getMessage());
        }
    }
    
    /* public void alterar(Estoque obj) {
        sql = "UPDATE SUPRIMENTOS SET nomeEquip = ?, Reutilizavel = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNomeEquip());
            ps.setBoolean(2, obj.isReutilizavel());
            ps.setString(3, obj.getDtCompra());
            ps.setString(4, obj.getCodLote());
            ps.setString(5, obj.getDtValidade());
            ps.setString(6, obj.getQuantidade());
            ps.execute();
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao Alterar usuário!" + err.getMessage());
        }
    }*/

}
