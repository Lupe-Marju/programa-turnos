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
        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");
        ciudadanoControler.agregarCiudadano(new Ciudadano(nombre, dni));
        response.sendRedirect("buscarTurnos");
    }
}
