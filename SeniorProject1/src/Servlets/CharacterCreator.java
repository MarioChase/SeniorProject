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
@WebServlet("/CharacterCreator")
public class CharacterCreator extends HttpServlet {
	private static final long serialVersionUID = -4751096228274971485L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//Validate input stupid!!!
		JsonHandler handler = new JsonHandler();
		Hashtable<String, Integer> stats = new Hashtable<String, Integer>();
		stats.put("str", Integer.parseInt(request.getParameter("str")));
		stats.put("dex", Integer.parseInt(request.getParameter("dex")));
		stats.put("con", Integer.parseInt(request.getParameter("con")));
		stats.put("int", Integer.parseInt(request.getParameter("int")));
		stats.put("wis", Integer.parseInt(request.getParameter("wis")));
		stats.put("chr", Integer.parseInt(request.getParameter("chr")));
		PlayerBuilder builder = new PlayerBuilder();
		IAbility a = new TestAbility();
		Player player = builder.execute(stats);
		response.getWriter().println(handler.playerToJson(player));
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
