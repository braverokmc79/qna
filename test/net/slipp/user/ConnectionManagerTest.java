package net.slipp.user;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import net.slipp.jdbc.ConnectionManager;

public class ConnectionManagerTest {


	@Test
	public void connection() {
		Connection con = ConnectionManager.getConnection();
		assertNotNull(con);
	}
}
