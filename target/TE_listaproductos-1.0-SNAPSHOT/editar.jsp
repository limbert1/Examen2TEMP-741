<%@page import="com.emergentes.modelo.Producto"%>
<%
   Producto reg = (Producto) request.getAttribute("miobjpro");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>registro de productos</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>id</td> 
                     <td><input type="text" name="id" value="<%=reg.getId()%>" size="2" readonly></td> 
                </tr>  
                     <td>Descripcion</td> 
                     <td><input type="text" name="Descripcion" value="<%=reg.getDescripcion()%>"></td> 
                 <tr>
                     <td>Cantidad</td> 
                     <td><input type="text" name="Cantidad" value="<%=reg.getCantidad()%>"></td> 
                </tr> 
                     <td>Precio</td> 
                     <td><input type="text" name="Precio" value="<%=reg.getPrecio() %>"></td> 
                 <tr>
                     <td>Categoria</td> 
                     <td><input type="text" name="Categoria" value="<%=reg.getCategoria()%>"></td> 
                </tr> 
                     <td></td> 
                     <td><input type="submit" name="enviar"></td> 
                 <tr>
                    
                </tr> 
           
            </table>
    
        </form>
</html>
