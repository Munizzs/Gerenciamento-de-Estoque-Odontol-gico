package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.Dentistas;

public class DentistaDao extends ConectarDao {

    public DentistaDao() {
        super();
    }

    public ResultSet validarLogin(String login, String senha) {
        String sql = "SELECT * FROM DENTISTA WHERE email = ? AND senha = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
        }
    }

    public void incluir(Dentistas obj) {
        String sql = "INSERT INTO DENTISTA (nome, email, especialidade, cro, senha) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getEspecialidade());
            ps.setString(4, obj.getCro());
            ps.setString(5, obj.getSenha());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir usuário!" + err.getMessage());
        }
    }

    public ResultSet buscartodos() {
        String sql = "SELECT * FROM DENTISTA ORDER BY nome";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!" + err.getMessage());
            return null;
        }
    }

    public ResultSet buscar(Dentistas obj) {
        String sql = "SELECT * FROM DENTISTA WHERE CRO = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getCro());
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!" + err.getMessage());
            return null;
        }
    }

    public void excluir(String cro) {
        String sql = "DELETE FROM DENTISTA WHERE cro = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cro);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Excluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir usuário!" + err.getMessage());
        }
    }

    public void alterar(Dentistas obj) {
        String sql = "UPDATE DENTISTA SET nome = ?, email = ?, especialidade = ?, senha = ? WHERE cro = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getEspecialidade());
            ps.setString(4, obj.getSenha());
            ps.setString(5, obj.getCro());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Alterar usuário!" + err.getMessage());
        }
    }
}
