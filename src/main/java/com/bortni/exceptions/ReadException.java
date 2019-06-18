package com.bortni.exceptions;

import java.sql.SQLException;

public class ReadException extends Throwable {
    public ReadException(SQLException e) {
        e.printStackTrace();
    }

    public ReadException(String s) {
        System.out.println(s);
    }
}
