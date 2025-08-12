package org.zerock.w1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet..." + this);
    }

    @Override
    public void destroy() {
        System.out.println("destroy...................");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init(ServletConfig).................");
    }
    // /sample 호출시 init()와 destroy()는 한 번씩만 호출, doGet() / doPost()는 여러 번 호출된다.
}
