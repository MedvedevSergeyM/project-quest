package com.javarush.quest.services;


import com.javarush.quest.model.Option;
import com.javarush.quest.model.OptionLosing;
import com.javarush.quest.model.Situation;
import com.javarush.quest.model.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.javarush.quest.repository.QuestRepository;
import com.javarush.quest.repository.QuestRepositoryImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QuestServiceTest {

    private final static QuestService questService = QuestService.QUEST_SERVICE;

    @BeforeAll
    static void setUp() {
    }

    @Test
    void registerNewUser() {
        String userName = "Sergey";
        User expected = new User(userName);
        User actual = questService.registerUser(userName);
        assertEquals(expected, actual);
    }

    @Test
    void reRegisterNewUser() {
        String userName = "Sergey";
        User expected = new User(userName);
        questService.registerUser(userName);
        User actual = questService.registerUser(userName);
        assertEquals(expected, actual);
    }

    @Test
    void getSituation1() {
        QuestRepository questRepository = new QuestRepositoryImpl();
        Situation expected = questRepository.getSituation(1L);
        Situation actual = questService.getSituation(1L);
        assertEquals(expected, actual);
    }

    @Test
    void selectOptionGood() {
        String userName = "Sergey2";
        User user = questService.registerUser(userName);
        Option expected = new OptionLosing(32L, "Солгать о себе", "Твою ложь разоблачили.");
        Option actual = questService.selectOption(32L, user);
        assertEquals(expected, actual);
    }

    @Test
    void selectOptionBad() {
        String userName = "Sergey2";
        User user = questService.registerUser(userName);
        Option expected = new OptionLosing(32L, "Некорректный текст", "Некорректный текст");
        Option actual = questService.selectOption(32L, user);
        assertNotEquals(expected, actual);
    }
}