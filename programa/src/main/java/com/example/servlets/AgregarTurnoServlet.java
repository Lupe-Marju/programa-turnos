package com.example.servlets;

import com.example.controlers.TurnoControler;
import com.example.entities.Ciudadano;
import com.example.enums.EstadoTurno;
import com.example.persistence.CiudadanoJPA;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/agregarturno")
public class AgregarTurnoServlet extends HttpServlet {

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            TurnoControler turnoControler = new TurnoControler();

            EstadoTurno estadoTurno = EstadoTurno.valueOf(request.getParameter("estado"));
            LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
            Long ciudadanoId = Long.parseLong(request.getParameter("ciudadanoId"));

            //Llamar el metodo crearturno del controlador de turnos
            turnoControler.agregarTurno(estadoTurno,fecha,ciudadanoId);

            // Redirigir a la lista de turnos para que se vea el nuevo turno
            response.sendRedirect( "turnos.jsp"); //
        }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            CiudadanoJPA cuidadanoJPA = new CiudadanoJPA();
            // Buscar cuidadanos para mostrar al usuario
            List<Ciudadano> cuidadanos = cuidadanoJPA.listarCiudadanos();
            request.setAttribute("listado", cuidadanos);

            request.getRequestDispatcher("turnoformulario.jsp").forward(request, response);

        }


}
