package com.javarush.quest.controller;

import com.javarush.quest.model.*;
import com.javarush.quest.services.QuestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PlayServlet", value = "/play")
public class PlayServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(PlayServlet.class);
    QuestService questService = QuestService.QUEST_SERVICE;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        User user = (User) session.getAttribute("user");
        logger.info("user = " + user);

        String ipAddress = req.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = req.getRemoteAddr();
        }
        logger.info("ipAddress = " + ipAddress);
        session.setAttribute("ipAddress", ipAddress);

        String optionParameter = req.getParameter("option");

        if (optionParameter == null || optionParameter.isEmpty()) {
            logger.warn("option is empty");
            Situation situation = questService.getSituation(1L);
            session.setAttribute("situation", situation);
            logger.info("situation = " + situation);
            getServletContext().getRequestDispatcher("/play.jsp").forward(req, resp);
            return;
        }

        long optionId = Long.parseLong(optionParameter);
        Option option = questService.selectOption(optionId, user);
        logger.info("option = " + option);

        if (option instanceof OptionWinning) {
            session.setAttribute("message", ((OptionWinning) option).getMessage());
            getServletContext().getRequestDispatcher("/winning.jsp").forward(req, resp);
        } else if (option instanceof OptionLosing) {
            session.setAttribute("message", ((OptionLosing) option).getMessage());
            getServletContext().getRequestDispatcher("/loosing.jsp").forward(req, resp);
        } else {
            long situationId = ((OptionNext) option).getNextSituation();
            Situation situation = questService.getSituation(situationId);
            session.setAttribute("situation", situation);
            logger.info("situation = " + situation);
            getServletContext().getRequestDispatcher("/play.jsp").forward(req, resp);
        }
    }

}
