<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="pedidos" value="${requestScope['pedidos']}"/>
<form action="/illaisaca/Listar" method="post" name="formulario">
  <p>
   Buscar por : 
    <label for="opcion" >Opcion: </label> 
  <select id="opcion" name="opcion">
				<option value="numTargeta" selected>Numero Targeta</option>
				<option value="comida">Nombre Comida</option>
  </select>  
  </p>
  
  <p>
   
    <input type="text" name="criterio" >
    
  </p> 
  <input type="submit" value="Ejecutar">
  
</form>
<div id="divTablas" class="container" >
	<br>
		<table id="tablax" class="table table-striped table-bordered">
			<thead>
				<th>CLiente</th>
				<th>Fecha</th>				
				<th>Total</th>
				
				
			</thead>
			<tbody>

				<c:forEach  items="${pedidos}" var="pedido">
				
					<tr>
						<td>${pedido.cliente}</td>
						<td>${pedido.fecha}</td>
						<td>${pedido.total}</td>
						
					</tr>
				
			
					
					
					
					<%-- <c:forEach var="comidas" items="${pedidos.comida}">
						<tr>
							<td>""</td>
							<td>""</td>
							<td>${comidas.nombre}</td>
							<td>${comidas.precio}</td>
						
						</tr>
					</c:forEach>
					<tr>
							<td>""</td>
							<td>""</td>
							<td>TOTAL</td>
							<td>${pedidos.total}</td>
						
						</tr> --%>
					
				</c:forEach>

				
			</tbody>
		</table>
	</div>

</body>
</html>