
package com.emergentes.controlador;

import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {


    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               String op =request.getParameter("op");
               Producto objpro = new Producto();
               int id, pos;
               
               HttpSession ses = request.getSession();
               ArrayList<Producto> lista =(ArrayList<Producto>) ses.getAttribute("listapro");
               
               switch(op){
                   case  "nuevo":
                       request.setAttribute("miobjpro", objpro);
                       request.getRequestDispatcher("editar.jsp").forward(request, response);
                       break;
                   case "editar":
                       id = Integer.parseInt(request.getParameter("id"));
                       pos = buscarporIndice (request, id);
                       objpro=lista.get(pos);
                       request.setAttribute("miobjpro", objpro);
                       request.getRequestDispatcher("editar.jsp").forward(request, response);
                       break;
                   case "eliminar":
                       id = Integer.parseInt(request.getParameter("id"));
                        pos = buscarporIndice (request, id);
                        if (pos>=0){
                         lista.remove(pos);
                       }
                        request.setAttribute("listapro",lista);
                        response.sendRedirect("index.jsp");
                        
                       break;
             
               }
    }

    
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    HttpSession ses = request.getSession();
    ArrayList<Producto> lista =(ArrayList<Producto>) ses.getAttribute("listapro");
    Producto objpro =new Producto();
    
    try {
        int id = Integer.parseInt(request.getParameter("id"));
        objpro.setId(id);
    } catch (NumberFormatException e) {
        objpro.setId(0); // Establece un valor predeterminado si 'id' no es un número válido
    }
    
    objpro.setDescripcion(request.getParameter("Descripcion"));
    
    try {
        int cantidad = Integer.parseInt(request.getParameter("Cantidad"));
        objpro.setCantidad(cantidad);
    } catch (NumberFormatException e) {
        objpro.setCantidad(0); // Establece un valor predeterminado si 'Cantidad' no es un número válido
    }
    
    try {
        float precio = Float.parseFloat(request.getParameter("Precio"));
        objpro.setPrecio(precio);
    } catch (NumberFormatException e) {
        objpro.setPrecio(0); // Establece un valor predeterminado si 'Precio' no es un número válido
    }
    
    objpro.setCategoria(request.getParameter("Categoria"));
    
    if (objpro.getId() == 0){
        int idNuevo = ObtenerId(request);
        objpro.setId(idNuevo);
        lista.add(objpro);
    } else {
        int pos = buscarporIndice(request, objpro.getId());
        lista.set(pos, objpro);
    }
    
    request.setAttribute("listapro", lista);
    response.sendRedirect("index.jsp");
}

    
    
    
 public int buscarporIndice (HttpServletRequest request, int id){
               HttpSession ses = request.getSession();
               ArrayList<Producto> lista =(ArrayList<Producto>) ses.getAttribute("listapro");
               
               int pos= -1;
               if(lista!=null){
                   for (Producto ele : lista){
                   
                   ++pos;
                    if(ele.getId()==id){
                    
                    break;
                    }
                   }
               
               }
               
               return pos;
 }
  public int ObtenerId(HttpServletRequest request){
           HttpSession ses = request.getSession();
           ArrayList<Producto> lista =(ArrayList<Producto>) ses.getAttribute("listapro");
           int idn =0;
           for (Producto ele : lista){
               idn=ele.getId();
           }
           return idn+1;
  }
}
