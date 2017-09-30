package com.apress.apachetomcat7.chapter13;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * @author aleksav
 */
@WebServlet(urlPatterns = {"/displayUsers.html"})
public class DisplayUsersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        StringBuffer sb = new StringBuffer("<HTML><BODY>");
        sb.append("<TABLE style=\"border-style: solid; border-width: 1px;\">");
        sb.append("<TR><TH>BOOKS</TH><TH>AUTHORS</TH><TH>CATEGORY</TH></TR>");
        try {
            conn = getDbConnectionOld();
            Statement statement = conn.createStatement();
            ResultSet users = statement.executeQuery("select * from books");
            while (users.next()) {
                sb.append("<TR>");
                sb.append("<TD style=\"border-style: solid; border-width: 1px;\">");
                String username = users.getString("title");
                sb.append(username);
                sb.append("</TD>");
                sb.append("<TD style=\"border-style: solid; border-width: 1px;\">");
                String author = users.getString("author");
                sb.append(author);
                sb.append("</TD>");
                sb.append("<TD style=\"border-style: solid; border-width: 1px;\">");
                String category = users.getString("category");
                sb.append(category);
                sb.append("</TD>");
                sb.append("</TR>");
            } //
        } catch (Exception e) {
            System.err.println("Error connecting to database server");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database connection terminated");
                }
                catch (Exception e) {
                    System.err.println("Error closing database connection");
                }
            }
        }
        sb.append("</TABLE>");
        sb.append("</BODY></HTML>");
        response.getOutputStream().write(sb.toString().getBytes());

    }

    private Connection getDbConnectionOld()
            throws SQLException,
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        String userName = "user_nordea";
        String password = "nordea2";
        String url = "jdbc:mysql://localhost/bookstore";
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        return DriverManager.getConnection(url, userName, password);
    }

    private Connection getDbConnection() throws NamingException {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        Connection connection = (Connection) envContext.lookup("jdbc/testDataSource");
        return connection;
    }
}
