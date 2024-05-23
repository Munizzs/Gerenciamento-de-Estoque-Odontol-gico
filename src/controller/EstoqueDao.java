package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Estoque;

public class EstoqueDao extends ConectarDao {

    public EstoqueDao() {
        super();
    }

    public void incluir(Estoque obj) {
        String sql = "INSERT INTO EstoqueMaterial (pk_idEquip, nomeEquip, quantidade, dtValidade, codLote, quantRemove) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdEquip());
            ps.setString(2, obj.getNomeEquip());
            ps.setInt(3, obj.getQuantidade());
            ps.setString(4, obj.getDtValidade());
            ps.setString(5, obj.getCodLote());
            ps.setInt(6, obj.getQuantRemove());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir Estoque!" + err.getMessage());
        }
    }

    public ResultSet buscartodos() {
        String sql = "SELECT * FROM EstoqueMaterial";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Estoque!" + err.getMessage());
            return null;
        }
    }

    public ResultSet buscar(Estoque obj) {
        String sql = "SELECT * FROM EstoqueMaterial WHERE nomeEquip = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNomeEquip());
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Estoque!" + err.getMessage());
            return null;
        }
    }

    public void excluir(String nome) {
        String sql = "DELETE FROM EstoqueMaterial WHERE nomeEquip = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Estoque!" + err.getMessage());
        }
    }

    // Comentado, mas deixado para referência futura
    /*
    public void alterar(Estoque obj) {
        sql = "UPDATE EstoqueMaterial SET nomeEquip = ?, Reutilizavel = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNomeEquip());
            ps.setBoolean(2, obj.isReutilizavel());
            ps.setString(3, obj.getDtCompra());
            ps.setString(4, obj.getCodLote());
            ps.setString(5, obj.getDtValidade());
            ps.setString(6, obj.getQuantidade());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao Alterar Estoque!" + err.getMessage());
        }
    }
    */
}
