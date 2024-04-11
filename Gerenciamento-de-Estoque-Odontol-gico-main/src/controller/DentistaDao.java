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

    String sql;
    PreparedStatement ps; // objeto para executar o sql

    public DentistaDao() {
        super();
    }

    public ResultSet validarLogin(String login, String senha) {
        sql = "Select * from usuarios where email='" + login + "'"
                + " and senha = '" + senha + "'";
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet resul = ps.executeQuery();
            return resul;
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
            return null;
        }
    }

    public void incluir(Dentistas obj) {
        sql = "INSERT INTO USUARIOS VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, obj.getCro());
            ps.setString(2, obj.getNome());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getEspecialidade());
            ps.setString(6, obj.getSenha());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null,"Registro Incluído com Sucesso!");
} catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir usuário!" + err.getMessage()); } }

}
