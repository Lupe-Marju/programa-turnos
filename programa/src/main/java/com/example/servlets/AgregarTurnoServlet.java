package com.example.servlets;

import com.example.controlers.CiudadanoControler;
import com.example.controlers.TurnoControler;
import com.example.entities.Ciudadano;
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

@WebServlet("/agregarturno")
public class AgregarTurnoServlet extends HttpServlet {

    private TurnoControler turnoControler = new TurnoControler();
    private CiudadanoControler ciudadanoControler = new CiudadanoControler();

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           /* TurnoControler turnoControler = new TurnoControler();
            EstadoTurno estadoTurno;
            try
                {estadoTurno = EstadoTurno.valueOf(request.getParameter("estado"));
                } catch (IllegalArgumentException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Estado invalido");
                return;
            }
            LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
            Long ciudadanoId = Long.parseLong(request.getParameter("ciudadanoId"));

            //Validamos si parametros estan vacios o mal formateados
            if (estadoTurno == null || fecha == null || ciudadanoId == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Faltan parametros Requeridos.");
                return;


            //Llamar el metodo crearturno del controlador de turnos
            turnoControler.agregarTurno(estadoTurno, fecha, ciudadanoId);

            // Redirigir a la lista de turnos para que se vea el nuevo turno
            response.sendRedirect("turnos.jsp"); //
        }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            CiudadanoControler ciudadanoControler = new CiudadanoControler();
            // Buscar cuidadanos para mostrar al usuario
            List<Ciudadano> cuidadanos = ciudadanoControler.listarCiudadanos();
            request.setAttribute("listado", cuidadanos);

            request.getRequestDispatcher("turnoformulario.jsp").forward(request, response);

        }*/

            EstadoTurno estadoTurno;
            LocalDate fecha;
            Long ciudadanoId;

            // Validar estado
            try {
                estadoTurno = EstadoTurno.valueOf(request.getParameter("estado"));
            } catch (IllegalArgumentException | NullPointerException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Estado inválido");
                return;
            }

            // Validar fecha
            try {
                fecha = LocalDate.parse(request.getParameter("fecha"));
            } catch (DateTimeParseException | NullPointerException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Fecha inválida");
                return;
            }

            // Validar ciudadanoId
            try {
                ciudadanoId = Long.parseLong(request.getParameter("ciudadanoId"));
            } catch (NumberFormatException | NullPointerException e) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de ciudadano inválido");
                return;
            }

            // Crear turno
            turnoControler.agregarTurno(estadoTurno, fecha, ciudadanoId);

            // Redirigir a la lista de turnos
            response.sendRedirect("turnos.jsp");
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ciudadano> ciudadanos = ciudadanoControler.listarCiudadanos();
        request.setAttribute("listado", ciudadanos);
        request.getRequestDispatcher("turnoformulario.jsp").forward(request, response);
    }
}

