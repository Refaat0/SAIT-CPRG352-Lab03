/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/arithmetic"})
public class ArithmeticCalculatorServlet extends HttpServlet {

    // Handles the GET request
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

    }

    // Handles the POST reqiests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(request);

        String message;

        // get the first and second numbers from the form
        String first = request.getParameter("first");
        String second = request.getParameter("second");

        // validation for non empty form
        if (first == "" || second == "") {
            // render the page with the error message
            message = "Invalid";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }

        // validate for correct data type
        try {
            // get the operator
            int result = 0;
            String operator = request.getParameter("operator");

            // convert first and second to integers
            int newFirst = Integer.parseInt(first);
            int newSecond = Integer.parseInt(second);

            // calculate the reust
            if (operator.equals("+")) {
                result = newFirst + newSecond;
            } else if (operator.equals("-")) {
                result = newFirst - newSecond;
            } else if (operator.equals("/")) {
                result = newFirst / newSecond;
            } else if (operator.equals("*")) {
                result = newFirst * newSecond;
            }
            
            // send the result to the JSP and rerender the page
            request.setAttribute("message", result);
            request.getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);

            //TODO: keep form data after post
            
        } catch (Exception e) {
            // rerender the page with the error message
            message = "Invalid";
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
