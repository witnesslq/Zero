package com.zero.Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zero.util.UtilClass;

/** 
* <p>��  ����DBPool
* <p>��  �ã� ���ݿ����ӣ�����ʵ���û�����ģ��
*/
public class DBPool{
	
    private static DBPool instance = null;

	/** 
	* <br>��������getConnection
	* <br>��  �ã� �������ݿ�
	*/
    public static synchronized Connection getConnection() {
        if (instance == null){
            instance = new DBPool();
        }
        return instance._getConnection();
    }
	/** 
	* <br>��������DBPool
	* <br>��  �ã� ���캯��
	*/
    private DBPool(){
        super();
    }
	/** 
	* <br>��������_getConnection
	* <br>��  �ã� �������ݿ�
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
	* <br>��������dbClose
	* <br>��  �ã��ͷ����ӵ����ݿ�
	*/
    public static void dbClose(Connection conn,PreparedStatement ps,ResultSet rs)
    throws SQLException
    {
          rs.close();
          ps.close();
          conn.close();

      }
    }