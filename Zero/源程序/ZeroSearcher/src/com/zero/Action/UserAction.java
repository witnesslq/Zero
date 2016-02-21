package com.zero.Action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zero.Sql.UserDAO;

/** 
* <p>类  名：UserAction
* <p>作  用：处理后台管理中用户管理模块的一些动作
*/
public class UserAction extends Action {
	/** 
	* <br>常量名：CONTENT_TYPE
	* <br>作  用： 处理页面编码
	*/
	 private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	 String mark = new String();
	
		/** 
		* <br>函数名：execute
		* <br>作  用：Action 主方法 处理请求的动作
		* <br>参  数： ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response
		* <br>返回类型： ActionForward 
		*/
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			UserForm userForm = (UserForm) form;
		    request.setCharacterEncoding("UTF-8"); //设定请求的编码类型
	        response.setContentType(CONTENT_TYPE);
	        PrintWriter out = response.getWriter();
	        HttpSession session = request.getSession();
	        ArrayList<Object> list = new ArrayList<Object>();
	        String ID=userForm.getID();
	        String username = userForm.getUsername();
	        String password = userForm.getPassword();
	        String Manager=userForm.getManager();
	        if(username!=null){
//	        	username = username;  //new String(username.getBytes("iso8859_1"), "UTF-8");
		    }else{
	        	username = "";
	        }
	       // if(password != null)
	      //  password = new String(password.getBytes("iso8859_1"), "UTF-8");
	        //password = password.trim();
	        String[] check = request.getParameterValues("check");
	        list.add(ID);
	        list.add(username);
	        list.add(password);
            list.add(Manager);
	        session.setAttribute("name",username);

	        //把从请求中取得执行类型
	        String command = userForm.getCommand();
	        command = command.trim();
	        boolean bool = false;
//	        final String success = "success.jsp";
//	        final String fail = "fail.jsp";
	        String pwd = new String();
	        
	          //登录操作
	        if (command.equals("login")) {
	       

	                ArrayList<Object> arr = UserDAO.verify(username, password);
	                session.setAttribute("username", username);

	                if(arr.size()>1)  {
	                    pwd = (String) arr.get(2);                    
	                    pwd = pwd.trim();

	                   if (pwd.equals(password)) {


	                                session.removeAttribute("logon");
	                                session.setAttribute("logon", arr);
	         
	                                
	    	                  out.println("<script language=javascript>");
	    		               out.println("location.href='BOSS/OA.jsp'</script>");
	                               
	                               
	                    } else {
	                        out.println("<script language=javascript>alert('密码不正确！')");
	                       out.println("location.href='BOSS/login/login.jsp'</script>");
	                     //  mark = "Login5";
	                        out.close();
	                        
	                        
	                    }
	                }
	                else {
	                    out.println("<script language=javascript>alert('用户不存在！')");
	                     out.println("location.href='BOSS/login/login.jsp'</script>");
	                //    mark = "Login5";
	                       out.close();
	                       
	                     

	                }
	             /*else {
	                out.println("<script language=javascript>alert('请输入用户名！')");
	                    out.println("location.href='login.jsp'</script>");
	                    out.close();
	            }
	            */
	        }

	        //添加用户信息
	        if (command.equals("insert")) {

	            bool = UserDAO.insert(list);

	            if (bool) {
	                out.println("<script language=javascript>alert('添加成功！')");
	                out.println("window.close()</script>");
	                out.close();

	            } else {
	                out.println("<script language=javascript>alert('添加失败！')");
	                out.println("window.close()</script>");
	                out.close();

	            }
	        }
	        //删除用户
	        if (command.equals("del")) {
	            if (check != null) {
	                int num = check.length;
	                for (int i = 0; i <= num - 1; i++) {
	            
	                   bool = UserDAO.del(check[i]);
	                    if (bool) {
	                        out.println("<script language=javascript>alert('删除成功！')");
	                        out.println("location.href='BOSS/login/del.jsp'</script>");
	                        out.close();
	                    }
	                    else {
	                        out.println("<script language=javascript>alert('删除失败！')");
	                        out.println("location.href='BOSS/login/del.jsp'</script>");
	                        out.close();
	                    }

	                }
	            }
	        }
		//修改用户
	        if (command.equals("update")) {

	            bool = UserDAO.update(list);

	           if (bool) {
	                   out.println("<script language=javascript>alert('修改成功！')");
	                   out.println("location.href='BOSS/Main.jsp'</script>");
	                   out.close();

	                   } else {
	                           out.println("<script language=javascript>alert('错误！修改未成功！')");
	                           out.println("location.href='BOSS/login/xiugai.jsp'</script>");
	                           out.close();

	                   }
	       }
		 
		 
		return null;
	}
}