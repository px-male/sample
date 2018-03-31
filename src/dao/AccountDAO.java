package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	
	public Account findByLogin(Login login) {
		
		// login からパラメータ取得
		String userId = login.getUserId();
		String pass = login.getPassWord();
		
		Connection conn = null;
		
		Account account = null;
		
		try {

			//JDBCドライバーを読み込む
			Class.forName("org.h2.Driver");
			
			// 接続
			conn = DriverManager.getConnection("jdbc:h2:file:~/docoTsubu","sa","" );
			
			//sql文を作成する。
			String sql = "select * from ACCOUNT where USER_ID = ? and PASS = ?";
			
			//PreparedStatementの作成
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			pStmt.setString(2, pass);
			
			//select文を実行
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				//ACCOUNTデータを取得
				String t_user_id = rs.getString("user_id");
				String t_pass = rs.getString("pass");
				String t_mail = rs.getString("mail");
				String t_name =rs.getString("name");
				int t_age = rs.getInt("age");
			
				account = new Account(t_user_id, t_pass, t_mail, t_name, t_age);
			}
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
					return null;
				}
			}
		}
		
		//Account　オブジェクトを戻す
		return account;
	}
	
}
