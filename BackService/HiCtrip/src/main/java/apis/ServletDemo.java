package apis;

import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class apis.ServletDemo
 */
public class ServletDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String parserResult =  "";

    public ServletDemo() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("jsonData", parserResult);
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String action = request.getParameter("action");
        if("login".equals(action)) {
            String words = request.getParameter("words");
            parserResult = words;
            System.out.println(ToAnalysis.parse(words));
        }
    }

}