package com.bortni.exceptions;

import java.sql.SQLException;

public class ReadException extends Throwable {
    public ReadException(SQLException e) {

    }

    public ReadException(String s) {

    }
}
