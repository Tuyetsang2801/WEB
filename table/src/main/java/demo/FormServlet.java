package demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/form")//link chạy sẻvelet
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String gender = request.getParameter("gender");
        String job = request.getParameter("job");
        String[] deliveryMethods = request.getParameterValues("delivery");

        // Lưu dữ liệu vào đối tượng User
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setAddress(address);
        user.setCity(city);
        user.setGender("male".equals(gender));
        user.setJob(job);
        user.setDeliveryMethods(deliveryMethods);
        
        // Lưu đối tượng User vào request để truyền cho JSP
        request.setAttribute("user", user);
        
        // Chuyển tiếp đến JSP
        request.getRequestDispatcher("/submitForm.jsp").forward(request, response);
    }
}
