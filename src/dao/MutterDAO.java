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
	
	public List<Mutter> findAll() {
		
		Connection conn = null;
		List<Mutter> mutterList = new ArrayList<Mutter>();
		
		//データベース接続
		try {
			conn = DriverManager.getConnection("jdbc:h2:file:/Users/katsubehiroshi/work/DB/docoTsubu", "sa", "");
			
		//SQL文を用意
		String sql = "select id, name, content from docoTsubu";
		PreparedStatement pStmt = conn.prepareStatement(sql);
		
		//select 文を実行し、結果を取得
		ResultSet rs = pStmt.executeQuery();
		
		String id = rs.getString("ID");
		String name = rs.getString("NAME");
		String context = rs.getString("Context")
		
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		return mutterList;
	}
}
