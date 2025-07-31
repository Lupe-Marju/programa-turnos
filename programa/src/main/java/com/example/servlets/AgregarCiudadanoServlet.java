package com.example.servlets;

import com.example.controlers.CiudadanoControler;
import com.example.entities.Ciudadano;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/agregarciudadano")
public class AgregarCiudadanoServlet extends HttpServlet {
    CiudadanoControler ciudadanoControler = new CiudadanoControler();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");


        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");

        if (ciudadanoControler.dniExistente(dni)) {
            request.setAttribute("error", "❌ El DNI ya está registrado.");
            request.getRequestDispatcher("/ciudadanoformulario.jsp").forward(request, response);
            return;
        }

        ciudadanoControler.agregarCiudadano(new Ciudadano(nombre, dni));
        request.getSession().setAttribute("mensajeExito", "✅ Ciudadano registrado exitosamente");
        response.sendRedirect("buscarTurnos");
    }
}
