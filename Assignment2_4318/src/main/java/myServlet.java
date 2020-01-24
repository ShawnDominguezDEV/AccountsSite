import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "myServlet")
public class myServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "";

        String action = request.getParameter("fromPage");

        if (action.equals("startPage")){

            String fn = request.getParameter("fn");
            String ln = request.getParameter("ln");
            String un = request.getParameter("un");
            String pw = request.getParameter("pw");

            DatabaseTools.insert(fn,ln,un,pw);
            ArrayList<User> myData = DatabaseTools.selectAllUsers();
            request.setAttribute("asdf", myData);

            url = "/page2.jsp";
        }

        if(action.equals("page2")){
            if (request.getParameter("update") != null) {
                Integer id = Integer.parseInt(request.getParameter("userid"));
                String fn = request.getParameter("userfn");
                String ln = request.getParameter("userln");
                String un = request.getParameter("userun");
                String pw = request.getParameter("userpw");

                DatabaseTools.update(id, fn, ln, un, pw);
                ArrayList<User> myData = DatabaseTools.selectAllUsers();
                request.setAttribute("asdf", myData);
                url = "/page2.jsp";
            } else if (request.getParameter("delete") != null) {
                Integer id = Integer.parseInt(request.getParameter("userid"));

                DatabaseTools.delete(id);
                ArrayList<User> myData = DatabaseTools.selectAllUsers();
                request.setAttribute("asdf", myData);
                url = "/page2.jsp";
            }
        }

        getServletContext().getRequestDispatcher(url).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
