package com.yaksha.demo.test1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {

      
        response.setContentType("text/html;charset=UTF-8");
      
        response.getWriter().println("<html>");
        response.getWriter().println("<h1>Hello Servlet</h1>");
        Optional.ofNullable(request.getParameter("user")).ifPresent((user) -> {
            try {
                response.getWriter().println("<h1>" + user + "</h1>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        response.getWriter().println("<h1>Testing done</h1>");
        response.getWriter().println("</br>");
        response.getWriter().println("session=" + request.getSession(true).getId());
        response.getWriter().println("</html>");

    }
}