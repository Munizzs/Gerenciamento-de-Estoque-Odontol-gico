package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.Suprimentos;

public class SuprimentosDao extends ConectarDao {
    
    public SuprimentosDao() {
        super();
    }

    public void incluir(Suprimentos obj) {
        String sql = "INSERT INTO Suprimentos (nomeEquip, reutilizavel, dtCompra, codLote, dtValidade, quantidade) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNomeEquip());
            ps.setBoolean(2, obj.isReutilizavel());
            ps.setString(3, obj.getDtCompra());
            ps.setString(4, obj.getCodLote());
            ps.setString(5, obj.getDtValidade());
            ps.setInt(6, Integer.parseInt(obj.getQuantidade())); // Convertendo a quantidade para int
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir Suprimento!" + err.getMessage());
        }
    }

    public ResultSet buscartodos() {
        String sql = "SELECT * FROM Suprimentos ORDER BY nomeEquip";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Suprimento!" + err.getMessage());
            return null;
        }
    }

    public ResultSet buscar(Suprimentos obj) {
        String sql = "SELECT * FROM Suprimentos WHERE nomeEquip = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNomeEquip());
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Suprimento!" + err.getMessage());
            return null;
        }
    }

    public void excluir(String nome) {
        String sql = "DELETE FROM Suprimentos WHERE nomeEquip = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Suprimento!" + err.getMessage());
        }
    }
    
    public void alterar(Suprimentos obj) {
        String sql = "UPDATE Suprimentos SET nomeEquip = ?, reutilizavel = ?, dtCompra = ?, codLote = ?, dtValidade = ?, quantidade = ? WHERE idEquip = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNomeEquip());
            ps.setBoolean(2, obj.isReutilizavel());
            ps.setString(3, obj.getDtCompra());
            ps.setString(4, obj.getCodLote());
            ps.setString(5, obj.getDtValidade());
            ps.setInt(6, Integer.parseInt(obj.getQuantidade())); // Convertendo a quantidade para int
            ps.setInt(7, obj.getIdEquip());
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar Suprimento!" + err.getMessage());
        }
    }

    public ResultSet buscarPorCodigo(Suprimentos sm) {
        String sql = "SELECT * FROM Suprimentos WHERE codLote = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sm.getCodigo());
            return ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Suprimento!" + e.getMessage());
            return null;
        }
    }

    public void removerQuantidade(String codigo, int quantidadeRemover) {
        String sql = "UPDATE Suprimentos SET quantidade = quantidade - ? WHERE codLote = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, quantidadeRemover);
            ps.setString(2, codigo);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao Remover Quantidade!" + e.getMessage());
        }
    }
}
