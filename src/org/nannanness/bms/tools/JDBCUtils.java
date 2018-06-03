package org.nannanness.bms.tools;


import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class JDBCUtils {
//	public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	public static final String DRIVER_CLASS_NAME = "oracle.jdbc.driver.OracleDriver";
//	public static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false";
	public static final String URL = "jdbc:oracle:thin:@WIN-HG51S2NMN2S:1521:orcl";
	public static final String USERNAME = "scott";
	public static final String PASSWORD = "tiger";
	
	private static final int MAX_IDLE = 3;
	private static final long MAX_WAIT = 5000;
	private static final int MAX_ACTIVE = 5;
	private static final int INITIAL_SIZE = 10;
	
	private static BasicDataSource dataSource = new BasicDataSource();
	static {
		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
			
		dataSource.setMaxActive(MAX_IDLE);
		dataSource.setMaxWait(MAX_WAIT);
		dataSource.setMaxActive(MAX_ACTIVE);
		dataSource.setInitialSize(INITIAL_SIZE);
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}

	public static String PagenationSql(String sql, int currentPage, int pageSize){
		String pageSql = "select * from ( select \"temp\".*, ROWNUM \"rn\" from ("
				+ sql + ") \"temp\" where ROWNUM <= " + currentPage + " * " + pageSize + " ) where \"rn\" > ("+ currentPage + " - 1) * "+ pageSize;
		return pageSql;
	}
}

