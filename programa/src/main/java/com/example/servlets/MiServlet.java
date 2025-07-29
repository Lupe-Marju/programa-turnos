package com.example.servlets;

import com.example.service.TurnoService;
import com.example.enums.EstadoTurno;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TurnoService turnoService = new TurnoService();
        EstadoTurno estado = turnoService.obtenerEstadoPorDescripcion("Ya atendido");

        System.out.println(estado); // YA_ATENDIDO

        response.getWriter().println("Estado: " + estado);
    }
}
