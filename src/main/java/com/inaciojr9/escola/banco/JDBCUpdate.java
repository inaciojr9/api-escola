package com.inaciojr9.escola.banco;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class JDBCUpdate {
 
 
	public static void update(Long id, String novoNome) {
 
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
 
		String updateTableSQL = "UPDATE aluno SET nome = ? WHERE id = ?";
 
		try {
			dbConnection = Conexao.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(updateTableSQL);
			
			
		    pstmt.setString(1, novoNome);
		    pstmt.setLong(2, id);
			pstmt.execute();
 
			System.out.println("Registro foi atualizado na tabela!");
 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
 
		} finally {
 
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
 
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
 
		}
 
	}
 
}
