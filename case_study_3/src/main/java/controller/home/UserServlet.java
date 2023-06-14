package controller.home;

import dao.UserDAO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import model.User;
import utils.ValidateUtils;

@WebServlet(name="UserServlet",value = "/user")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                showLogin(req, resp);
                break;
//            case "signup":
////                showSignup(req, resp);
//                break;
//            case "logout":
//                showLogout(req, resp);
//                break;
//            case "myAccount":
//                showMyAccount(req, resp);
//                break;
//            case "showDetail":
//                showBillDetail(req, resp);
//                break;
            default:
                showLogin(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "checkLogin":
                try {
                    checkLogin(request, response);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            case "updateInfo":
                updateInfo(request, response);
                break;
            case "register":
                try {
                    register(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showLogin(request, response);
                break;
        }
    }

    private void showLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/home/login.jsp").forward(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String user_email = request.getParameter("user_email_re");
        if (!ValidateUtils.isEmail(user_email)) {
            request.setAttribute("error_email", "Email không hợp lệ. Hãy nhập lại...");
            request.getRequestDispatcher("/home/login.jsp").forward(request, response);
        }
        String user_pass = request.getParameter("user_pass_re");
        String re_pass = request.getParameter("re_pass_re");
        if (!user_pass.equals(re_pass)) {
            request.setAttribute("error_pass", "Mật khẩu không trùng khớp. Hãy nhập lại...");
            request.getRequestDispatcher("/home/login.jsp").forward(request, response);
        } else {
            User a = userDAO.checkAcc(user_email);
            if (a == null) {
                userDAO.signup(user_email, user_pass);
                request.setAttribute("message", "Đăng ký thành công");
                request.getRequestDispatcher("/home/login.jsp").forward(request, response);
            } else {
                request.setAttribute("emailavailable", "Email đã tồn tại!");
                request.getRequestDispatcher("/home/login.jsp").forward(request, response);
            }
        }
    }

    private void updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if (user == null) {
                response.sendRedirect("user?action=login");
            } else {
                String user_name = request.getParameter("user_name");
                if (!ValidateUtils.isFullName(user_name)) {
                    request.setAttribute("error_name", "Tên của bạn không hợp lệ. Hãy nhập lại...");
                    request.getRequestDispatcher("/my-account.jsp").forward(request, response);
                }
                String user_pass = request.getParameter("user_pass");
                int user_id = user.getUser_id();
                userDAO.UpdateUser(user_id, user_name, user_pass);
                User user1 = new User(user.getUser_id(), user_name, user.getUser_email(), user_pass, user.getRole());
                session.setAttribute("user", user1);
                request.setAttribute("message", "Đã cập nhật thành công");
                request.getRequestDispatcher("/my-account.jsp").forward(request, response);

            }
        } catch (Exception e) {
//            response.sendRedirect("user?action=login");
            e.printStackTrace();
        }
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String user_email = request.getParameter("user_email");
        String user_pass = request.getParameter("user_pass");
        String remember = request.getParameter("remember");
        User user = userDAO.checkUser(user_email, user_pass);
        if (user == null) {
            request.setAttribute("error", "Tài khoản không tồn tại hoặc mật khẩu không đúng !");
            request.getRequestDispatcher("/home/login.jsp").forward(request, response);
//            response.sendRedirect("user?action=login");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            Cookie email = new Cookie("email", user_email);
            Cookie pass = new Cookie("pass", user_pass);
            Cookie rem = new Cookie("remember", remember);
            if (remember != null) {
                email.setMaxAge(60 * 60 * 24 * 30);
                pass.setMaxAge(60 * 60 * 24 * 3);
                rem.setMaxAge(60 * 60 * 24 * 30);
            } else {
                email.setMaxAge(0);
                pass.setMaxAge(0);
                rem.setMaxAge(0);
            }
            response.addCookie(email);
            response.addCookie(pass);
            response.addCookie(rem);
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public void destroy() {
    }


}
