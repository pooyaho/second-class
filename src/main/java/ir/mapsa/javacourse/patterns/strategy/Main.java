package ir.mapsa.javacourse.patterns.strategy;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<LoggerTypes, Logger> loggerMap = new HashMap<>();
        loggerMap.put(LoggerTypes.FILE, new FileLogger());
        loggerMap.put(LoggerTypes.MONGO, new MongoLogger());


    }
}

enum LoggerTypes{
    FILE,MONGO
}
