package com.javarush.quest;

import com.javarush.quest.model.Quest;
import com.javarush.quest.services.QuestService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/quest")
public class QuestServlet extends HttpServlet {

    QuestService questService = QuestService.QUEST_SERVICE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Quest> questOptional = questService.get(0L);
        if (questOptional.isPresent()) {
            Quest quest = questOptional.get();
            req.setAttribute("quest", quest);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/quest.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            // TODO: log error
        }
    }
}
