package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	
	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL = "jdbc:h2:file:/Users/katsubehiroshi/work/DB/docoTsubu";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Mutter> findAll() {
		
		Connection conn = null;
		List<Mutter> mutterList = new ArrayList<Mutter>();
		
		//データベース接続
		try {
			
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			//SQL文を用意
			String sql = "select id, name, content from docoTsubu";
			PreparedStatement pStmt = conn.prepareStatement(sql);
		
			//select 文を実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();
		
			// select 文の結果をArrayListに追加
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String context = rs.getString("Context");
			
				Mutter mutter = new Mutter(id, name, context);
				mutterList.add(mutter);
			}	
		
		
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		} finally {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
					return null;
				}
			}
		}
		return mutterList;
	}
	
	public boolean create(Mutter mutter) {
		
		Connection conn = null;
				
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
			
			//SQL文を用意
			String sql = "Insert into docoTsubu (name, context) value = (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mutter.getName());
			pStmt.setString(2, mutter.getContent());
			
			//SQLを実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
					return false;

				}
			}
			
		}
		return true;
	} 
	
}
