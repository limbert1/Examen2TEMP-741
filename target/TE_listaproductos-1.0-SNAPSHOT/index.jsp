<%@page import="com.emergentes.modelo.Producto"%>
<%@page import="java.util.ArrayList"%>
<%
    if (session.getAttribute("listapro")==null){
        ArrayList<Producto> lisaux = new ArrayList<Producto>();
        session.setAttribute("listapro", lisaux);
        
    }
    ArrayList<Producto> lista=(ArrayList<Producto>)session.getAttribute("listapro");
%>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gestion de Productos</h1>
        <h1>Nombre=Limbert Apaza Condori</h1>
        <h1>Carnet=12926831</h1>
        <a href="MainServlet?op=nuevo">Nuevo Producto</a>
        <table border="1">
            <tr>
                <th>id</th>   
                <th>Descripcion</th> 
                <th>Cantidad</th> 
                <th>Precio</th> 
                <th>Categoria</th> 
                <th></th> 
                <th></th> 
            </tr>
            <%
              if(lista!=null){
                 for (Producto item:lista){
            %>    
            
            
            <tr>
                <td><%= item.getId()%></td>
                <td><%= item.getDescripcion() %></td>
                <td><%= item.getCantidad() %></td>
                <td><%= item.getPrecio() %></td>
                <td><%= item.getCategoria() %></td>
                <td><a href="MainServlet?op=editar&id=<%= item.getId()%>">Editar</a></td>
                <td><a href="MainServlet?op=eliminar&id=<%= item.getId()%>" onclick="return(confirm('¿Estás seguro de eliminarlo?'))">Eliminar</a></td>

 
            </tr>
            <%
                }
              }
            %>    
            
            
        </table>
    </body>
</html>
