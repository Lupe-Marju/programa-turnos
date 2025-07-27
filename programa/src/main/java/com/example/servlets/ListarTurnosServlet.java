package com.example.servlets;

import com.example.controlers.TurnoControler;
import com.example.entities.Turno;
import com.example.enums.EstadoTurno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@WebServlet("/turnos")
public class ListarTurnosServlet extends HttpServlet {
    private final TurnoControler turnoControler = new TurnoControler();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estadoParam = request.getParameter("estado");
        String fechaParam = request.getParameter("fecha");

        List<Turno> listadoTurnos;

        if (estadoParam != null && !estadoParam.isEmpty()) {
            try {
                EstadoTurno estado = EstadoTurno.valueOf(estadoParam);
                listadoTurnos = turnoControler.filtrarPorEstado(estado);
            } catch (IllegalArgumentException e) {
                listadoTurnos = turnoControler.listarTodos();
                request.setAttribute("error", "Estado inválido.");
            }
        } else if (fechaParam != null && !fechaParam.isEmpty()) {
            try {
                LocalDate fecha = LocalDate.parse(fechaParam);
                listadoTurnos = turnoControler.filtrarPorFecha(fecha);
            } catch (DateTimeParseException e) {
                listadoTurnos = turnoControler.listarTodos();
                request.setAttribute("error", "Formato de fecha inválido (yyyy-MM-dd).");
            }
        } else {
            listadoTurnos = turnoControler.listarTodos();
        }

        request.setAttribute("listadoTurnos", listadoTurnos);
        request.getRequestDispatcher("turnos.jsp").forward(request, response);
    }

    private List<Turno> filtrarPorEstado(HttpServletRequest request, String estadoParam) {
        try {
            EstadoTurno estado = EstadoTurno.valueOf(estadoParam);
            return turnoControler.filtrarPorEstado(estado);
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "Estado inválido.");
            return turnoControler.listarTodos();
        }
    }

    private List<Turno> filtrarPorFecha(HttpServletRequest request, String fechaParam) {
        try {
            LocalDate fecha = LocalDate.parse(fechaParam);
            return turnoControler.filtrarPorFecha(fecha);
        } catch (DateTimeParseException e) {
            request.setAttribute("error", "Formato de fecha inválido (yyyy-MM-dd).");
            return turnoControler.listarTodos();
        }
    }
}


