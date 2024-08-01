package ru.rsreu.antonushkinaosipova.action.command;

import java.sql.SQLException;

import jakarta.servlet.http.HttpServletRequest;

public interface ActionCommand {
	String execute(HttpServletRequest request) throws SQLException, ClassNotFoundException;
}
