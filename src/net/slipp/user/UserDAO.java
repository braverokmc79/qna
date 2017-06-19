package net.slipp.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import net.slipp.jdbc.JdbcTemplate;
import net.slipp.jdbc.RowMapper;

public class UserDAO {

	public void addUser(User user)  {
		String sql = "insert into USERS values(?,?,?,?)";
		JdbcTemplate.getInstance().executeUpdate(sql, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());			
	}
	
	public User findByUserId(String userId)  {
		RowMapper<User> row = rowMap();		
		String sql = "select * from USERS where userId = ?";
		return JdbcTemplate.getInstance().executeQuery(sql, row , userId );		
	}
	

	public void removeUser(String userId)  {
		String sql = "delete from USERS where userId = ?";
		JdbcTemplate.getInstance().executeUpdate(sql,userId);
	}

	
	public void updateUser(User user)  {
		String sql = "update USERS set password = ?, name = ?, email = ? where userId = ?";
		JdbcTemplate.getInstance().executeUpdate(sql,user.getPassword(), user.getName(), user.getEmail(), user.getUserId());
	}


	public List<User> findUsers() {
		RowMapper<User> row = rowMap();		
		String sql = "select * from USERS ";
		return JdbcTemplate.getInstance().list(sql, row, null );	
	}


	private RowMapper<User> rowMap() {
		RowMapper<User> row =new RowMapper<User>() {	
			@Override
			public User mapRow(ResultSet rs) throws SQLException {
				return new User(
						rs.getString("userId"), 
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email"));
			}
		};
		return row;
	}
	
	
	
	
	
}


