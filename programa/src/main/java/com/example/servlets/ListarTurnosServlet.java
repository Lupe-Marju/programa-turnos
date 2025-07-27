package com.example.servlets;

import com.example.controlers.TurnoControler;
import com.example.entities.Turno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/listarTurnos")
public class ListarTurnosServlet extends HttpServlet {

    private TurnoControler turnoControler = new TurnoControler();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Turno> turnos = turnoControler.listarTodos();
        request.setAttribute("turnos", turnos);
        request.getRequestDispatcher("turnos.jsp").forward(request, response);
    }
}
