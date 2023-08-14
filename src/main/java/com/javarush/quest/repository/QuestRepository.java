package com.javarush.quest.repository;

import com.javarush.quest.model.Option;
import com.javarush.quest.model.Situation;

public interface QuestRepository {
    Situation getSituation(long id);
    Option getOption(long id);
}
