package com.com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class DBUtil {
	//1.获得配置参数
	private static String driverClassName;
	private static String url;
	private static String userName;
	private static String password;

	private static int initialSize;
	private static int maxActive;
	private static int minIdle;
	public static DruidDataSource dds=null;

	static{
		Properties cfg=new Properties();
		InputStream inStream=DBUtil.class
				.getClassLoader()
				.getResourceAsStream("db.properties");
		try {
			cfg.load(inStream);
			driverClassName=cfg.getProperty("jdbc.driver");
			url=cfg.getProperty("jdbc.url");
			userName=cfg.getProperty("jdbc.username");
			password=cfg.getProperty("jdbc.password");
			initialSize=Integer.parseInt(cfg.getProperty("InitialSize"));
			maxActive=Integer.parseInt(cfg.getProperty("MaxActive"));
			minIdle=Integer.parseInt(cfg.getProperty("MinIdle"));

			dds=new DruidDataSource();
			dds.setDriverClassName(driverClassName);
			dds.setUrl(url);
			dds.setUsername(userName);
			dds.setPassword(password);
			dds.setInitialSize(initialSize);
			dds.setMaxActive(maxActive);
			dds.setMinIdle(minIdle);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//2.获得连接对象的方法
	public static Connection getConnection() throws SQLException{
		Connection conn=dds.getConnection();
		return conn;
	}
	//3.归还连接对象
	public static void closeConnection(Connection conn){
		if (conn!=null) {
			try {
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//4.rollback方法
	public static void rollBack(Connection conn){
		if (conn!=null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}