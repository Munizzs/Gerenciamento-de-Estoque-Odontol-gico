/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import model.Suprimentos;


/**
 *
 * @author rober
 */
public class SuprimentosDao extends ConectarDao {
    String sql;
    PreparedStatement ps; // objeto para executar o sql

    public SuprimentosDao() {
        super();
    }


    public void incluir(Suprimentos obj) {
        sql = "INSERT INTO Suprimentos VALUES (null ,? , ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, obj.getNomeEquip());
            ps.setBoolean(2, obj.isReutilizavel());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir Suprimento!" + err.getMessage());
        }
    }

    public ResultSet buscartodos() {
        sql = "SELECT * FROM SUPRIMENTOS ORDER BY nomeEquip ";
        try {
            ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Suprimento!"
                    + err.getMessage());
            return null;
        }
    }

    public ResultSet buscar(Suprimentos obj) {

        sql = "SELECT * FROM SUPRIMENTOS WHERE nomeEquip = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, obj.getNomeEquip());
            ResultSet resul = ps.executeQuery();
           
            return resul;
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Suprimento!"
                    + err.getMessage());
            return null;
        }
    }

    public void excluir(String nome) {

        sql = "DELETE FROM SUPRIMENTOS WHERE nomeEquip = '" + nome + "'";
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
    
     public void alterar(Suprimentos obj) {
        sql = "UPDATE SUPRIMENTOS SET nomeEquip = ?, Reutilizavel = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNomeEquip());
            ps.setBoolean(2, obj.isReutilizavel());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Alterado com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao Alterar usuário!" + err.getMessage());
        }
    }

   
}
