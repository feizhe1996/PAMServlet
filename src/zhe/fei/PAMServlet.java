package zhe.fei;

import org.jvnet.libpam.PAM;
import org.jvnet.libpam.UnixUser;

import java.io.IOException;

public class PAMServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");


        String name = request.getParameter("name");
        String password = request.getParameter("password");
        // ***** PAM *********

        System.out.println(System.getProperty("password"));
        try {
            new PAM("sshd").authenticate(name, password);
            UnixUser user = new UnixUser(name);
            request.setAttribute("result", "Authentication Succeeded");
            request.setAttribute("dir", user.getDir());
            request.setAttribute("groups", user.getGroups());
            request.setAttribute("shell", user.getShell());
            request.setAttribute("uid", user.getUID());
//            UnixUser user = new UnixUser(name);
            System.out.println(user.getDir());
            System.out.println(user.getGroups());
            System.out.println(user.getShell());
            System.out.println(user.getUID());
            System.out.println("correct");
        } catch (Exception e) {
            System.out.println("fail");
            request.setAttribute("result", "Authentication Failed");
//            e.printStackTrace();
        }
        // **** End of PAM *****
        System.out.println("name->" + name + ",password->" + password);
        request.setAttribute("name", name);
        request.setAttribute("password", password);
        request.getRequestDispatcher("index.jsp").forward(request, response);
//        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
