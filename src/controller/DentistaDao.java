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
            JOptionPane.showMessageDialog(null,"Registro Incluído com Sucesso!");
} catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir usuário!" + err.getMessage()); } }

}
