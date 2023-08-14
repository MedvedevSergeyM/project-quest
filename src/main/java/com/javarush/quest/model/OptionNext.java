package com.javarush.quest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

// Вариант = следующая ситуация
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OptionNext extends Option {

    @Getter
    private final long nextSituation;

    public OptionNext(long id, String text, long nextSituation) {
        super(id, text);
        this.nextSituation = nextSituation;
    }

}
