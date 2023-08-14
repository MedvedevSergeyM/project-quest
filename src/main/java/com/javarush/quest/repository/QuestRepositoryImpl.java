package com.javarush.quest.repository;

import com.javarush.quest.model.*;

import java.util.*;

public class QuestRepositoryImpl implements QuestRepository {

    private final Map<Long, Situation> situations = new HashMap<>();
    private final Map<Long, Option> options = new HashMap<>();

    public QuestRepositoryImpl() {
        options.put(11L, new OptionNext(11L, "Принять вызов", 2L));
        options.put(12L, new OptionLosing(12L, "Отклонить вызов", "Ты отклонил вызов."));
        situations.put(1L, new Situation(
                1L,
                "Ты потерял память. Принять вызов НЛО?",
                Arrays.asList(options.get(11L), options.get(12L))
        ));

        options.put(21L, new OptionNext(21L, "Подняться на мостик", 3L));
        options.put(22L, new OptionLosing(22L, "Отказаться подниматься на мостик", "Ты не пошел на переговоры."));
        situations.put(2L, new Situation(
                2L,
                "Ты принял вызов. Поднимаешься на мостик к капитану?",
                Arrays.asList(options.get(21L), options.get(22L))
        ));

        options.put(31L, new OptionWinning(31L, "Рассказать правду", "Ты вернулся домой."));
        options.put(32L, new OptionLosing(32L, "Солгать о себе", "Твою ложь разоблачили."));
        situations.put(3L, new Situation(
                3L,
                "Ты поднялся на мостик. Ты кто?",
                Arrays.asList(options.get(31L), options.get(32L))
        ));
    }

    @Override
    public Situation getSituation(long id) {
        return situations.get(id);
    }

    @Override
    public Option getOption(long id) {
        return options.get(id);
    }
}
