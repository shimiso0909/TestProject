package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DictionaryDao {
	//単語の検索
	public static WordBean search(String english){
		
		WordBean word=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/javadic");
			con=ds.getConnection();
			
			String sql="select * from ejdic where english=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,english);
			rs=ps.executeQuery();
			
			String japanese;
			if(rs.next()) {
				japanese=rs.getString("japanese");
				word=new WordBean(english,japanese);
			}
			
			
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
		catch(NamingException e) {
			System.err.println(e.getMessage());
			return null;
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return word;
		
		
		
	}
	
	
	//単語の追加
	public static boolean insert(WordBean word) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/javadic");
			con=ds.getConnection();
			//重複単語を確認
			String sql="select * from ejdic where english=? and japanese=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,word.getEnglish());
			ps.setString(2,word.getJapanese());
			rs=ps.executeQuery();
			if(rs.next()) {
				return false;//重複する単語があった場合
			}
			rs.close();
			ps.close();
			
			//追加
			sql="insert into ejdic values(?,?)";//valueかも
			ps=con.prepareStatement(sql);
			ps.setString(1,word.getEnglish());
			ps.setString(2,word.getJapanese());
			int cnt=ps.executeUpdate();
			if(cnt==1) {
				return true;
			}
			return false;
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		catch(NamingException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		
	}
	public static boolean delete(String english) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/javadic");
			con=ds.getConnection();
			
			String sql="delete from ejdic where english=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,english);
			
			int cnt=ps.executeUpdate();
			if(cnt>=1) {
				return true;
			}
			return false;
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		catch(NamingException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				return false;
			}
		}
		
	}
	public static boolean delete(WordBean word) {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			
			Context context=new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/javadic");
			con=ds.getConnection();
			
			String sql="delete from ejdic where japanese=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,word.getJapanese());
			
			int cnt=ps.executeUpdate();
			if(cnt>=1) {
				return true;
			}
			return false;
			
		}
		catch(SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		catch(NamingException e) {
			System.err.println(e.getMessage());
			return false;
		}
		finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}
			catch(SQLException e) {
				System.err.println(e.getMessage());
				return false;
			}
		}
		
	}
	
	 
}
