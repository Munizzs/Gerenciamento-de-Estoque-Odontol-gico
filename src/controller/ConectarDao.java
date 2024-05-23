package controller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ConectarDao {

    public Connection con = null;
    private String sql = null;
    private PreparedStatement ps;

    public ConectarDao() {
        try {
             //con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "Muniz", "Zinum1008@");
            this.criarBanco();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro de Conexão com o MySQL ...\n" + err.getMessage());
        }
    }

    public void criarBanco() {
        try {
            ps = con.prepareStatement("CREATE DATABASE IF NOT EXISTS bdodonto");
            ps.execute();

            ps = con.prepareStatement("USE bdodonto");
            ps.execute();

            sql = "CREATE TABLE IF NOT EXISTS DENTISTA ("
                    + "pk_idDentista INT UNSIGNED NOT NULL AUTO_INCREMENT ,"
                    + "nome VARCHAR(50) NOT NULL ,"
                    + "email varchar(50) not null ,"
                    + "especialidade VARCHAR(20) NOT NULL,"
                    + "cro INT(10) not null,"
                    + "senha varchar(50)  ,"
                    + "UNIQUE KEY (cro) ,"
                    + "primary key ( pk_idDentista) )";

            ps = con.prepareStatement(sql);
            ps.execute();

            sql = "CREATE TABLE IF NOT EXISTS EstoqueMaterial ("
                    + "pk_idMaterial INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                    + "pk_idEquip INT UNSIGNED NOT NULL,"
                    + "nomeEquip VARCHAR(15) NOT NULL,"
                    + "quantidade INT(100) NOT NULL,"
                    + "dtValidade varchar(10) NOT NULL,"
                    + "codLote varchar(100) NOT NULL,"
                    + "quantRemove int (100) default '0',"
                    + "reutilizavel boolean NOT NULL,"
                    + "PRIMARY KEY (pk_idMaterial) );";

            ps = con.prepareStatement(sql);
            ps.execute();

            sql = "CREATE TABLE IF NOT EXISTS Suprimentos ("
                    + "pk_idEquip INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                    + "nomeEquip VARCHAR(15)NOT NULL,"
                    + "reutilizavel boolean NOT NULL,"
                    + "dtCompra varchar(10) NOT NULL,"
                    + "codLote varchar(100) NOT NULL,"
                    + "dtValidade varchar(10) NOT NULL,"
                    + "quantidade int(100) NOT NULL,"
                    + "PRIMARY KEY ( pk_idEquip ) ); ";

            ps = con.prepareStatement(sql);
            ps.execute();

            sql = "CREATE TABLE IF NOT EXISTS manuntencao ("
                    + "pk_idManutencao INT UNSIGNED NOT NULL AUTO_INCREMENT,"
                    + "dtManutencao varchar(10) NOT NULL,"
                    + "descri varchar(50) NOT NULL,"
                    + "fk_idMaterial INT UNSIGNED NOT NULL,"
                    + "FOREIGN KEY(fk_idMaterial) REFERENCES Suprimentos (pk_idEquip),"
                    + "PRIMARY KEY (pk_idManutencao) )";

            ps = con.prepareStatement(sql);
            ps.execute();
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao criar banco de dados " + err.getMessage());
        }
    }

    public static Connection getConectar() {
        ConectarDao conectarDao = new ConectarDao();
        return conectarDao.con;
    }
}
