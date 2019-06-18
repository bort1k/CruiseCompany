package com.bortni.web.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
