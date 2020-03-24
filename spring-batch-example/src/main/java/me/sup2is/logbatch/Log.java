package me.sup2is.logbatch;

import lombok.Data;

@Data
public class Log {

    private Status status;
    private String message;

}

enum Status{
    DEBUG, INFO, ERROR
}
