package Servlets;
import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Abilities.*;
import GameObject.*;
import MiscObjects.JsonHandler;

/**
 * Servlet implementation class CharacterCreator
 */
@WebServlet("/MonsterSpawner")
public class MonsterSpawner extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//Validate input stupid!!!
		JsonHandler handler = new JsonHandler();
		MonsterFactory factory = new MonsterFactory();
		request.getParameter("time");
		//return monster as a json object
		response.getWriter().println(handler.monsterToJson(factory.getMonster(180000)));
	}
		
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}

}