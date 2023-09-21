package ru.aston.morozov_aa.task4.work_with_db.util;

import java.util.UUID;

public class GeneratorId {

    public static String generateId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
