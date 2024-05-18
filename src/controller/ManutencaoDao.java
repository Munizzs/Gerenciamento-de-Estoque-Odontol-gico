
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Dentistas;
import model.Manutencao;


public class ManutencaoDao extends ConectarDao {
    
     public void incluir(Manutencao obj) {
        sql = "INSERT INTO manuntencao VALUES (null,?, ?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, obj.getDtManutencao());
            ps.setString(2, obj.getManuDescri());
            ps.setString(3,obj.getFkSupri());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Incluído com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao incluir Manuntenção!" + err.getMessage());
        }
    }

    public ResultSet buscartodos() {
        sql = "SELECT * FROM manuntencao ORDER BY dtManutencao ";
        try {
            ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Manutenção!"
                    + err.getMessage());
            return null;
        }
    }

    public ResultSet buscar(Manutencao obj) {

        sql = "SELECT * FROM manuntencao WHERE dtManutencao = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, obj.getDtManutencao());
            ResultSet resul = ps.executeQuery();
           
            return resul;
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Manutenção!"
                    + err.getMessage());
            return null;
        }
    }

    public void excluir(String cro) {

        sql = "DELETE FROM DENTISTA WHERE dtManutencao = '" + cro + "'";
        try {
            ps = con.prepareStatement(sql);

            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Registro Excluido com Sucesso!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Manutenção!"
                    + err.getMessage());
        }
    }

   /* public void alterar(Dentistas obj) {
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
    }*/

}
