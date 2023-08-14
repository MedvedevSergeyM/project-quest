package com.javarush.quest.model;

import lombok.*;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    @NonNull
    @Getter
    private final String name;

    @Getter
    @Setter
    private long winsCount = 0L;

    @Getter
    @Setter
    private long lossesCount = 0L;

}
