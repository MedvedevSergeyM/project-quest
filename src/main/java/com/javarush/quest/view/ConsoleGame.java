package com.javarush.quest.view;

import com.javarush.quest.model.*;
import com.javarush.quest.services.QuestService;

public class ConsoleGame {

    private final static QuestService questService = QuestService.QUEST_SERVICE;
    private static User user;

    public static void main(String[] args) {
        String nextGame = "Y";
        while("Y".equals(nextGame)) {
            System.out.print("Введите ваше имя: ");
            String userName = ConsoleHelper.readString();

            user = questService.registerUser(userName);
            System.out.printf("Игрок: %s, Побед: %d, Поражений: %d\n", user.getName(), user.getWinsCount(), user.getLossesCount());
            System.out.println("---------------------");

            processSituation(1L);

            System.out.print("Сыграть еще раз? (Y/N): ");
            nextGame = ConsoleHelper.readString().toUpperCase();
        }
    }

    private static void processSituation(long situationId) {
        Situation situation = questService.getSituation(situationId);
        System.out.println(situation.getText());
        situation.getOptions().forEach(o -> System.out.println(o.getId() + ": " + o.getText()));

        System.out.print("Ваш выбор: ");
        long optionId = ConsoleHelper.readLong();
        Option option = questService.selectOption(optionId, user);

        if (option instanceof OptionWinning) {
            System.out.println("Выигрыш! " + ((OptionWinning) option).getMessage());
        } else if (option instanceof OptionLosing) {
            System.out.println("Проигрыш! " + ((OptionLosing) option).getMessage());
        } else {
            situationId = ((OptionNext) option).getNextSituation();
            processSituation(situationId);
        }
    }

}