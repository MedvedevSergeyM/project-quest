package com.javarush.quest.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
public abstract class BaseEntity {

    @Getter
    private final long id;

    @Getter
    private final String text;

}