package com.ai.aso.common.webService.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.ai.aso.common.constants.BizConstants;
import com.ai.aso.common.param.GlobalParamSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * <p>
 * Description:
 * </p>
 *
 * @author liuwu
 * @date 2016年11月4日
 *
 */
@Component("OracleConnectionManager")
public class OracleConnectionManager {

	private static final Logger log = LoggerFactory.getLogger(OracleConnectionManager.class);
	private static ResourceBundle bundle;
	private Connection conn;

	/**
	 * 数据源连接
	 * 
	 * @return
	 */
	public Connection getOracleConnection() {
		try {
			bundle = ResourceBundle.getBundle(GlobalParamSet.getString(BizConstants.ORACLE_COFG_FILE));

		} catch (Exception e) {
			log.error("读取oracle配置文件异常", e.getMessage());
		}
		String driver = bundle.getString("oracledriver");

		String url = bundle.getString("oracleurl");

		String user = bundle.getString("oracleuser");

		String passwd = bundle.getString("oraclepassword");

		try {
			log.info("连接参数{},{},{}",url, user, passwd);
			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, passwd);
			log.info("数据库连接成功");

		} catch (SQLException ex) {
			log.error("数据库连接异常", ex.getMessage());

		} catch (ClassNotFoundException e) {

			log.error("oracle驱动不存在", e.getMessage());

		}

		return conn;

	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public void closeConnection(Connection conn) {

		try {

			if (conn != null) {

				/** 判断当前连接连接对象如果没有被关闭就调用关闭方法 */

				if (!conn.isClosed())

				{

					conn.close();

				}

			}

		} catch (Exception excp) {

			log.error("oracle连接关闭异常", excp.getMessage());

		}

	}

	public static void main(String[] args) {
		OracleConnectionManager connectionManager = new OracleConnectionManager();
		connectionManager.getOracleConnection();
	}
}
