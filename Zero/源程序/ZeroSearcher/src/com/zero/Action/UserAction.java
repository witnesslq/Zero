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
* <p>��  ����UserAction
* <p>��  �ã������̨�������û�����ģ���һЩ����
*/
public class UserAction extends Action {
	/** 
	* <br>��������CONTENT_TYPE
	* <br>��  �ã� ����ҳ�����
	*/
	 private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	 String mark = new String();
	
		/** 
		* <br>��������execute
		* <br>��  �ã�Action ������ ��������Ķ���
		* <br>��  ���� ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response
		* <br>�������ͣ� ActionForward 
		*/
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
			UserForm userForm = (UserForm) form;
		    request.setCharacterEncoding("UTF-8"); //�趨����ı�������
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

	        //�Ѵ�������ȡ��ִ������
	        String command = userForm.getCommand();
	        command = command.trim();
	        boolean bool = false;
//	        final String success = "success.jsp";
//	        final String fail = "fail.jsp";
	        String pwd = new String();
	        
	          //��¼����
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
	                        out.println("<script language=javascript>alert('���벻��ȷ��')");
	                       out.println("location.href='BOSS/login/login.jsp'</script>");
	                     //  mark = "Login5";
	                        out.close();
	                        
	                        
	                    }
	                }
	                else {
	                    out.println("<script language=javascript>alert('�û������ڣ�')");
	                     out.println("location.href='BOSS/login/login.jsp'</script>");
	                //    mark = "Login5";
	                       out.close();
	                       
	                     

	                }
	             /*else {
	                out.println("<script language=javascript>alert('�������û�����')");
	                    out.println("location.href='login.jsp'</script>");
	                    out.close();
	            }
	            */
	        }

	        //����û���Ϣ
	        if (command.equals("insert")) {

	            bool = UserDAO.insert(list);

	            if (bool) {
	                out.println("<script language=javascript>alert('��ӳɹ���')");
	                out.println("window.close()</script>");
	                out.close();

	            } else {
	                out.println("<script language=javascript>alert('���ʧ�ܣ�')");
	                out.println("window.close()</script>");
	                out.close();

	            }
	        }
	        //ɾ���û�
	        if (command.equals("del")) {
	            if (check != null) {
	                int num = check.length;
	                for (int i = 0; i <= num - 1; i++) {
	            
	                   bool = UserDAO.del(check[i]);
	                    if (bool) {
	                        out.println("<script language=javascript>alert('ɾ���ɹ���')");
	                        out.println("location.href='BOSS/login/del.jsp'</script>");
	                        out.close();
	                    }
	                    else {
	                        out.println("<script language=javascript>alert('ɾ��ʧ�ܣ�')");
	                        out.println("location.href='BOSS/login/del.jsp'</script>");
	                        out.close();
	                    }

	                }
	            }
	        }
		//�޸��û�
	        if (command.equals("update")) {

	            bool = UserDAO.update(list);

	           if (bool) {
	                   out.println("<script language=javascript>alert('�޸ĳɹ���')");
	                   out.println("location.href='BOSS/Main.jsp'</script>");
	                   out.close();

	                   } else {
	                           out.println("<script language=javascript>alert('�����޸�δ�ɹ���')");
	                           out.println("location.href='BOSS/login/xiugai.jsp'</script>");
	                           out.close();

	                   }
	       }
		 
		 
		return null;
	}
}