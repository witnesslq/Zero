package com.zero.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zero.util.UtilClass;

/** 
* <p>类  名：DBPool
* <p>作  用： 数据库连接，用来实现用户管理模块
*/
public class DBPool{
	
    private static DBPool instance = null;

	/** 
	* <br>函数名：getConnection
	* <br>作  用： 连接数据库
	*/
    public static synchronized Connection getConnection() {
        if (instance == null){
            instance = new DBPool();
        }
        return instance._getConnection();
    }
	/** 
	* <br>函数名：DBPool
	* <br>作  用： 构造函数
	*/
    private DBPool(){
        super();
    }
	/** 
	* <br>函数名：_getConnection
	* <br>作  用： 连接数据库
	*/
    private  Connection _getConnection(){
        try{
        
            
        String dbUrl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)}; DBQ=" + UtilClass.realPath + "SQL\\Yonghu.mdb";  
		String user="";   
		String password="";   
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
   
            return DriverManager.getConnection(dbUrl,user,password);
            
        }
        catch(Exception se){
            System.out.println(se);
            return null;
        }
    }

	/** 
	* <br>函数名：dbClose
	* <br>作  用：释放连接的数据库
	*/
    public static void dbClose(Connection conn,PreparedStatement ps,ResultSet rs)
    throws SQLException
    {
          rs.close();
          ps.close();
          conn.close();

      }
    }