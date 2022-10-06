package ufersa.edu.br.model.dao;
import ufersa.edu.br.model.entities.Adicionais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdicionaisDAO <Adicionais>{
	
	public boolean insertAdicional(Adicionais adicional) {
		String sql = "INSERT INTO tb_pizzaria (name, value) VALUES (?,?); ";
		
		try {
		PreparedStatement pst = getConnection().prepareStatement(sql);
		pst.setString(1, adicional.getName());
		pst.setDouble(2, adicional.getValue());
		return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteAdicional(Adicionais adicional) {
		String sql = "DELETE FROM tb_pizzaria WHERE name=? ";
		
		try {
		PreparedStatement pst = getConnection().prepareStatement(sql);
		pst.setString(1, adicional.getName());
		return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateAdicional(Adicionais adicional) {
		String sql = "UPDATE tb_pizzaria SET name=?, value=? WHERE name=?;";
		
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, adicional.getName());
			pst.setDouble(2, adicional.getValue());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Adicionais findAdicional(Adicionais adicional) {
		String pst = "SELECT * FROM tb_pizzaria WHERE name=? ;";
		
		try {
			PreparedStatement pst = getConnection().prepareStatement(sql);
			pst.setString(1, adicional.getName());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return adicional;
			}
			else return null;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
