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

@WebServlet("/modificarturno")
public class ModificarTurnoServlet extends HttpServlet {

TurnoControler turnoControler = new TurnoControler();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Turno turnoEncontrado = turnoControler.buscarPorId(id);
        request.setAttribute("id",id);
        request.setAttribute("nombre", turnoEncontrado.getCiudadano().getNombre());;
        request.setAttribute("fecha", turnoEncontrado.getFecha());
        //request.setAttribute("descripcion",turnoEncontrado.getDescripcion());
        request.setAttribute("identificador",turnoEncontrado.getIdentificadorProgresivo());
        request.getRequestDispatcher("modificarformulario.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Turno turnoEncontrado = turnoControler.buscarPorId(id);
        turnoEncontrado.setEstadoTurno(EstadoTurno.valueOf(request.getParameter("estado")));
        turnoControler.modificarTurno(turnoEncontrado);
        response.sendRedirect("buscarTurnos");
    }
}
