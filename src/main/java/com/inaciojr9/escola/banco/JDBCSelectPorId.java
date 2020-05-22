package com.inaciojr9.escola.banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inaciojr9.escola.model.Aluno;

public class JDBCSelectPorId {
   
   public static Aluno getById(Long idAluno) {
	   
	   Connection conn = null;
	   PreparedStatement stmt = null;
	   try{
		  conn = Conexao.getDBConnection();
	      
	      String sql;
	      sql = "SELECT id, nome FROM aluno where id = ?";
	      stmt = conn.prepareStatement(sql);
	      stmt.setLong(1, idAluno);
	      
	      ResultSet rs = stmt.executeQuery();
	      Aluno aluno = null;
	      if(rs.next()){
				
	    	  String nome = rs.getString("nome"); 
	    	  Long id =	rs.getLong("id");
	    	  aluno = new Aluno(id, nome);
	    	  
	      }
	      
	      rs.close();
	      stmt.close();
	      conn.close();
	      return aluno;
	   } catch (SQLException e) {
		   throw new RuntimeException(e.getMessage());
	   }finally{
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
   }
   
   public static void main(String[] args) throws SQLException {
	   getById(9l);
   }
}