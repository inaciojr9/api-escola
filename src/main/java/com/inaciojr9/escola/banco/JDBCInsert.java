package com.inaciojr9.escola.banco;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inaciojr9.escola.model.Aluno;
 
public class JDBCInsert {
	
	
	public static Aluno insert(String nome) {
		 
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
		
		String insertTableSQL = "INSERT INTO aluno (nome) VALUES (?)";
 
		try{
			dbConnection = Conexao.getDBConnection();
			
			// o seundo atributo é para obter o id do registro inserido
			pstmt = dbConnection.prepareStatement(insertTableSQL, PreparedStatement.RETURN_GENERATED_KEYS);
		    pstmt.setString(1, nome);
			
		    int affectedRows = pstmt.executeUpdate();
		    
	        if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        // para obter o id do registro inserido
	        long id;
	        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                id = generatedKeys.getLong(1);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
 
			System.out.println("Registro foi inserido na tabela!");
			Aluno aluno = new Aluno(id, nome);
			return aluno;
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
