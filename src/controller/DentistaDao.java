package controller;

import controller.DentistaDao;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import model.Dentistas;

public class DentistaDao extends ConectarDao {

   

    public DentistaDao() {
        super();
    }

    public ResultSet validarLogin(String login, String senha) {
        sql = "Select * from dentista where email='" + login + "'"
                + " and senha = '" + senha + "'";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet resul = ps.executeQuery();
            return resul;
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
        }
    }

    public void incluir(Dentistas obj) {
        sql = "INSERT INTO DENTISTA VALUES (null,?, ?, ?, ?, ?)";
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
        sql = "SELECT * FROM DENTISTA ORDER BY nome ";
        try {
            ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!"
                    + err.getMessage());
            return null;
        }
    }

    public ResultSet buscar(Dentistas obj) {

        sql = "SELECT * FROM DENTISTA WHERE CRO = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, obj.getCro());
            ResultSet resul = ps.executeQuery();
           
            return resul;
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuário!"
                    + err.getMessage());
            return null;
        }
    }

    public void excluir(String cro) {

        sql = "DELETE FROM DENTISTA WHERE cro = '" + cro + "'";
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

    public void alterar(Dentistas obj) {
        sql = "UPDATE DENTISTA SET nome = ?, email = ?, especialidade = ? "
                + ", senha = ? WHERE cro = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setString(3, obj.getEspecialidade());
            ps.setString(4, obj.getSenha());
            ps.setString(5, obj.getCro());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao Alterar usuário!" + err.getMessage());
        }
    }

}
