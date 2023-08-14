package com.javarush.quest.controller;

import java.io.*;

import com.javarush.quest.model.User;
import com.javarush.quest.services.QuestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StartServlet", value = "/start")
public class StartServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(StartServlet.class);
    QuestService questService = QuestService.QUEST_SERVICE;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String userName = req.getParameter("user_name");

        if (userName == null || userName.isEmpty()) {
            logger.warn("UserName is empty");
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        User user = questService.registerUser(userName);
        logger.info("user = " + user);
        HttpSession session = req.getSession(true);
        session.setAttribute("user", user);
        resp.sendRedirect("/play");
    }
}
