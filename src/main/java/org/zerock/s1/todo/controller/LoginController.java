package org.zerock.s1.todo.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.s1.todo.dto.MemberDTO;
import org.zerock.s1.todo.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Log4j2
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login get............");

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login post........");
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");
        String str = mid+mpw;
//        HttpSession session = req.getSession();
//
//        session.setAttribute("loginInfo", str);
//        resp.sendRedirect("/todo/list");
        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
        }
    }
}

