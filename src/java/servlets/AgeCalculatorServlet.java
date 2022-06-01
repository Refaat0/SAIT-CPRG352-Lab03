package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/age"})
public class AgeCalculatorServlet extends HttpServlet {

    // GET request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // render agecalculator.jsp
        request.getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

    // POST request
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = "";

        // validate for a non-empty form
        String age = request.getParameter("age");

        if (age == "") {
            // render the page with the error message
            message = "You must give your current age";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }

        // validate for correct data type
        try {
            // rerender the page with the new age
            int newAge = Integer.parseInt(age);
            newAge++;
            message = String.format("Your age next birthday will be %d", newAge);
            request.setAttribute("message", message);

            request.getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);

        } catch (Exception e) {
            // rerender the page with the error message
            message = "You must enter a number";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }

    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
