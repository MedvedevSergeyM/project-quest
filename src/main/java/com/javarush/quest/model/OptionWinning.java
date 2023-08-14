package com.javarush.quest.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

// Выигрышный вариант
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class OptionWinning extends Option {

    @Getter
    private final String message;

    public OptionWinning(long id, String text, String message) {
        super(id, text);
        this.message = message;
    }

}
