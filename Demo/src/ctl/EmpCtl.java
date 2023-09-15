package ctl;
import entity.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.EmployeeService;
@WebServlet("/EmpCtl")
public class EmpCtl extends HttpServlet {
    private static final long serialVersionUID=1L;
    EmployeeService es=new EmployeeService();
    RequestDispatcher rd;
    private HttpSession session;
   
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        String operation = request.getParameter("operation");
        String empId=request.getParameter("empId");
        String firstName=request.getParameter("firstname");
        String lastName=request.getParameter("lastname");
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        String isAdmin=request.getParameter("admin");
        String salary=request.getParameter("salary");
        PrintWriter out=response.getWriter();
        
        int id=Integer.parseInt(empId);
        double empSalary=Double.parseDouble(salary);
        boolean admin=Boolean.parseBoolean(isAdmin);
        Employee emp=es.employeeAdd(id,firstName,lastName,userName,password,admin,empSalary);
        rd=request.getRequestDispatcher("home.jsp");
        rd.forward(request,response);
    }
}