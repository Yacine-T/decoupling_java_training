package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {

    String name;
    Logger log;
    public ContextualLogger(String name,Logger log)
    {
        this.name = name;
        this.log = log;
    }

    @Override
    public void log(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        log.log(LocalDateTime.now().format(formatter) +  " " + this.name + " " + message);
    }
}
