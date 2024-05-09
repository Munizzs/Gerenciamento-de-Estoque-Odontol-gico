/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.DriverManager; // Driver para abrir Conexão
import java.sql.SQLException; // Tratamento de Erros SQL
import java.sql.Connection; // Armazena a Conexão Aberta
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ConectarDao {

    public Connection con = null;
    public String sql = null;
    public PreparedStatement ps;

    public ConectarDao() {

        try { 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            ps = con.prepareStatement("CREATE DATABASE IF NOT EXISTS bdodonto");
            ps.execute();
            ps.close();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdodonto", "root", "");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro de Conexão com o MySQL ...\n" + err.getMessage());
        }
    }

    public void criarBanco() {

        try {

            sql = "CREATE TABLE IF NOT EXISTS DENTISTA ("
                    + "pk_idDentista INT UNSIGNED NOT NULL AUTO_INCREMENT ,"
                    + "nome VARCHAR(50) NOT NULL ,"
                    + "email varchar(50) not null ,"
                    + "especialidade VARCHAR(20)NOT NULL,"
                    + "cro INT(10) not null,"
                    + "senha varchar(50)  ,"
                    + "UNIQUE KEY (cro) ,"
                    + "primary key (pk_idDentista) )";
            try {
                ps = con.prepareStatement(sql);
                ps.execute();
                ps.close();
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, "Erro ao criar tabela Dentista \n" + err.getMessage());
            }
            sql = "CREATE TABLE IF NOT EXISTS EstoqueMaterial ("
                    + "pk_idMaterial INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                    + "idEquip INT UNSIGNED ,"
                    + "nomeEquipamento VARCHAR(30) NOT NULL,"
                    + "qntdMateiral INT NOT NULL,"
                    + "PRIMARY KEY (pk_idMaterial), "
                    + "FOREIGN KEY (idEquip) REFERENCES Suprimentos(pk_idEquip) );";
            try {
                ps = con.prepareStatement(sql);
                ps.execute();
                ps.close();
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, "Erro ao criar tabela EstoqueMaterial \n" + err.getMessage());
            }
            sql = "CREATE TABLE IF NOT EXISTS Suprimentos ("
                    + "pk_idEquip INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                    + "nomeEquip VARCHAR(15)NOT NULL,"
                    + "reutilizavel boolean NOT NULL ,"
                    + "PRIMARY KEY (pk_idEquip)) ";
                    
            try {
                ps = con.prepareStatement(sql);
                ps.execute();
                ps.close();
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, "Erro ao criar tabela Suprimentos \n" + err.getMessage());
            }

            sql = "CREATE TABLE IF NOT EXISTS manuntencao ("
                    + "pk_idManutencao INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                    + "dtManutencao DATE NOT NULL,"
                    + "fk_idMaterial INT UNSIGNED  NOT NULL,"
                    + "PRIMARY KEY (pk_idManutencao),"
                    + "FOREIGN KEY (fk_idMaterial) REFERENCES suprimentos(pk_idEquip) )";
            try {
                ps = con.prepareStatement(sql);
                ps.execute();
                ps.close();
            } catch (SQLException err) {
                JOptionPane.showMessageDialog(null, "Erro ao criar tabela Manutenção \n" + err.getMessage());
            }

            ps.close(); // Fecha o objeto
            con.close(); // Fecha a conexão           
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao criar banco de dados " + err.getMessage());
        }
    }

}
