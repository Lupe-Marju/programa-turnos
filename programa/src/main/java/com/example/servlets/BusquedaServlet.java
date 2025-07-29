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
import java.util.stream.Collectors;

@WebServlet("/buscarTurnos")
public class BusquedaServlet extends HttpServlet {

    private TurnoControler turnoControler = new TurnoControler();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String estadoParam = request.getParameter("estado");
        String fechaParam = request.getParameter("fecha");

        List<Turno> turnos;

        try {
            if ((estadoParam == null || estadoParam.isEmpty()) && (fechaParam == null || fechaParam.isEmpty())) {
                // Sin filtro, listar todos
                turnos = turnoControler.listarTodos();
            } else if (estadoParam != null && !estadoParam.isEmpty() && (fechaParam == null || fechaParam.isEmpty())) {
                // Filtrar solo por estado
                EstadoTurno estado = EstadoTurno.fromDescripcion(estadoParam);
                turnos = turnoControler.filtrarPorEstado(estado);
            } else if ((estadoParam == null || estadoParam.isEmpty()) && fechaParam != null && !fechaParam.isEmpty()) {
                // Filtrar solo por fecha
                LocalDate fecha = LocalDate.parse(fechaParam);
                turnos = turnoControler.filtrarPorFecha(fecha);
            } else {
                // Filtrar por ambos
                EstadoTurno estado = EstadoTurno.fromDescripcion(estadoParam);
                LocalDate fecha = LocalDate.parse(fechaParam);
                turnos = turnoControler.listarTodos()
                        .stream()
                        .filter(t -> t.getEstadoTurno() == estado && t.getFecha().equals(fecha))
                        .collect(Collectors.toList());
            }

            request.setAttribute("turnos", turnos);
            request.getRequestDispatcher("turnos.jsp").forward(request, response);

        } catch (IllegalArgumentException | DateTimeParseException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parámetros de filtro inválidos");
        }
    }
}

