package valard.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public final class DataSource {
	
	public static final boolean DEBUG = true;
	
	private static HikariConfig config = new HikariConfig();
	public static HikariDataSource ds;
	
	private static final String CONNECTION_STRING = "jdbc:mysql://localhost/";
	private static final String USER_NAME = "nick";
	private static final String PASSWORD = "Nick292019";
	
	static {
		config.setJdbcUrl(CONNECTION_STRING);
        config.setUsername(USER_NAME);
        config.setPassword(PASSWORD);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource( config );
	}
	
	private DataSource() {}
	
	public static final void executeUpdate(final String query) throws SQLException {
		Connection connection = DataSource.ds.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.executeUpdate();
		
		if(DataSource.DEBUG)
			System.out.println("DataBase UPDATED!");
		
		connection.close();
		preparedStatement.close();
	}
	
}












