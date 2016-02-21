package com.zero.Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/** 
* <p>��  ����UserDAO
* <p>��  �ã��������ݿ������һЩ����
*/
public class UserDAO {
	/** 
	* <br>��������UserDAO
	* <br>��  �ã����캯��
	*/
    public UserDAO() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /** 
    * <br>��������jbInit
    * <br>��  �ã����ݿ����ӳ�ʼ��
    * <br>��  ������
    * <br>�������ͣ��� 
    */
    private void jbInit() throws Exception {
    }

  static Connection dbConn,conn;
  static PreparedStatement ps,ps1;
  static ResultSet rs,rs1;
  static ArrayList<Object> arr;



  /** 
  * <br>��������insert
  * <br>��  �ã����û����ݲ������ݱ���
  * <br>��  ����ArrayList list
  * <br>�������ͣ������� 
  */
  public static boolean insert(ArrayList<Object> list) {
         boolean bo = false;


      try {

          conn = DBPool.getConnection();
  
          String sql="insert into yonghu (username,password) values ('" + (String)list.get(1) + "','" + (String)list.get(2) + "')";
          
          ps = conn.prepareStatement(sql);
      
          ps.executeUpdate();
  
    
          System.out.println("��ӳɹ�!");
          ps.close();
          conn.close();

          bo= true;

      } catch(Exception e) {
          bo = false;
          System.out.println(e);}
     // finally {
       //   try {
//              ps.close();
         //     conn.close();
         // }catch (SQLException e) {System.out.println(e);}
      //}
      return bo;
  }

  /** 
   * <br>��������verify
   * <br>��  �ã���¼��֤
   * <br>��  ����String username, String password
   * <br>�������ͣ�ArrayList
   */
    public static ArrayList<Object> verify(String username, String password) {
        arr = new ArrayList<Object>();
//        boolean bo = false;
        try {
          conn = DBPool.getConnection();
          ps = conn.prepareStatement("select * from yonghu where username=?");
          ps.setString(1,username);
          rs=ps.executeQuery();
          if(rs.next()) {
        	  arr.add(rs.getString(1));
        	  arr.add(rs.getString(2));
        	  arr.add(rs.getString(3));
        	  arr.add(rs.getInt(4));
          }     
      	ps.close();
      	conn.close();
        } catch(Exception e) {
          System.out.println(e);
        }
        return arr;
    }
    
    /** 
     * <br>��������del
     * <br>��  �ã�ɾ���û�
     * <br>��  ����ID
     * <br>�������ͣ�boolean
     */
    public static boolean del(String ID)
    {
           boolean bool = false;
      // connect to the database
        try {
        conn = DBPool.getConnection();
        String sqlDel = "delete from yonghu where id=?";
        ps = conn.prepareStatement(sqlDel);
        ps.setInt(1, Integer.parseInt(ID));
        ps.executeUpdate();

        ps.close();
        conn.close();
        bool = true;
      } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        return bool;
    }

    /** 
     * <br>��������getAll
     * <br>��  �ã������ݿ�ȡ��card��Ϣ
     * <br>��  ������
     * <br>�������ͣ�ArrayList
     */
    public static ArrayList<Object> getAll(){

    		
    	     
    	        ArrayList<Object> result = new ArrayList<Object>();
    	          try {
    	           conn = DBPool.getConnection();
    	           System.out.println("getConnection() end!!");
    	          ps = conn.prepareStatement("select * from yonghu");
    	     	  System.out.println("ps execute!!");
    	          rs = ps.executeQuery();
    	          System.out.println("rs get!!");
    	         
    	          
    	            while(rs.next()){
    	            	   UserBean info = new UserBean();
       	                info.setId(rs.getInt(1));
    	            	info.setUsername(rs.getString(2));
    	            	info.setPassword(rs.getString(3));
    	            	info.setManager(rs.getInt(4));
    	            	result.add(info);    	            	
    	            	
    	            }
       	                rs.close();
    	                ps.close();
    	                conn.close();

    	          } catch (Exception e) {
    	            System.out.println(e.getMessage());
    	          }

    	          return result;
    		}

    /** 
     * <br>��������getUser
     * <br>��  �ã���ȡ���ݿ����û���Ϣ
     * <br>��  ����ID
     * <br>�������ͣ�UserBean
     */
    public static UserBean getUser(String ID){

        UserBean info = new UserBean();

          try {
           conn = DBPool.getConnection();
           ps = conn.prepareStatement("select * from yonghu where id=?");
           ps.setString(1,ID);
           rs = ps.executeQuery();

            while(rs.next()){

                info.setId(rs.getInt(1));
            	info.setUsername(rs.getString(2));
            	info.setPassword(rs.getString(3));
                info.setManager(rs.getInt(4));
            }
                rs.close();
                ps.close();
                conn.close();

          } catch (Exception e) {
            System.out.println(e.getMessage());
          }

          return info;
        }
    /** 
     * <br>��������update
     * <br>��  �ã��޸��û���Ϣ
     * <br>��  ����ArrayList list
     * <br>�������ͣ�boolean
     */
    public static boolean update(ArrayList<Object> list){
        boolean bool = false;

      try {

          conn = DBPool.getConnection();
          String sqlUp = "UPDATE yonghu SET  username = '" + ((String)list.get(1)).trim()
               +"',password  = '" + ((String)list.get(2)).trim()
               + "' WHERE id ="+Integer.parseInt((String) list.get(0));
          
          System.out.println(sqlUp);
     
             	ps = conn.prepareStatement(sqlUp);

                
                
                ps.executeUpdate();
                 ps.close();
                 conn.close();
         bool = true;

           } catch(Exception e)
        {
          System.out.println(e);
        }
        return bool;
    }

}