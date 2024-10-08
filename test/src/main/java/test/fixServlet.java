package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forms")
public class fixServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển tiếp đến form nếu phương thức GET được gọi
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xử lý dữ liệu form gửi bằng phương thức POST
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String gender = request.getParameter("gender");
        String job = request.getParameter("job");
        String[] deliveryMethods = request.getParameterValues("delivery");

        // Lưu dữ liệu vào đối tượng User
        US us = new US();
        us.setEmail(email);
        us.setName(name);
        us.setAddress(address);
        us.setCity(city);
        us.setGender("male".equals(gender));
        us.setJob(job);
        us.setDeliveryMethods(deliveryMethods);
        
        // Lưu đối tượng User vào request để truyền cho JSP
        request.setAttribute("us", us);
        
        // Chuyển tiếp đến JSP
        request.getRequestDispatcher("/submitForm.jsp").forward(request, response);
    }
}
