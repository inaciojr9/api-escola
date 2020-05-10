package com.inaciojr9.escola.banco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.inaciojr9.escola.model.Aluno;

public class JDBCSelect {
   
   public static List<Aluno> getAll() {
	   
	   Connection conn = null;
	   Statement stmt = null;
	   try{
		  conn = Conexao.getDBConnection();
	      stmt = conn.createStatement();
	      String sql;
	      
	      sql = "SELECT id, nome FROM aluno";
	      
	      ResultSet rs = stmt.executeQuery(sql);
	      List<Aluno> alunos = new ArrayList<>();
	      while(rs.next()){
				
	    	  String nome = rs.getString("nome"); 
	    	  Long id =	rs.getLong("id");
	    	  Aluno aluno = new Aluno(id, nome);
	    	  alunos.add(aluno);
				 
	      }
	      
	      rs.close();
	      stmt.close();
	      conn.close();
	      
	      return alunos;
	      
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
	   getAll();
   }
}