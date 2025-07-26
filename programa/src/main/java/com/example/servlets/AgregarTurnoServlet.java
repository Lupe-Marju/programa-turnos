package com.example.servlets;

import com.example.entities.Turno;
import com.example.enums.EstadoTurno;
import com.example.persistence.TurnoJPA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/agregarturno")
public class AgregarTurnoServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            EstadoTurno estadoTurno = EstadoTurno.valueOf(request.getParameter("estado"));
            String descripcion = request.getParameter("descripcion");
            LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
            Long ciudadanoid = Long.parseLong(request.getParameter("ciudadanoid"));

            //Buscar un ciudadano

        }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            TurnoJPA turnoJPA = new TurnoJPA();
            List<Turno> turnos = turnoJPA.listarTurnos();

            request.setAttribute("lista turnos", turnos);
            request.getRequestDispatcher("jsp/turnos.jsp").forward(request, response);
        }


}
