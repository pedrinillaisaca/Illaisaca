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
<c:set var="usuario" value="${requestScope['pedido']}"/>
<form action="/illaisaca/GenerarPedido" method="post" name="formulario">
  <p>
    Nombre Cliente: 
    <input type="text" name="cliente" value="${pedido.cliente}">
    
  </p>
  
  <p>
   Numero Targeta: 
    <input type="text" name="numTargeta" >
    
  </p>
  <p>
    Igresar Comida: <br>
    <input type="text" name="nombre" placeholder="nombre"> <br><br>
    <input type="text" name="precio" placeholder="precio"> <br>  
  </p>
  <p>
  <label for="opcion" >Opcion: </label> 
  <select id="opcion" name="opcion">
				<option value="cnt" selected>Agregar mas</option>
				<option value="fin">Finalizar Pedido</option>
				
  </select>
  </p>
  
  
  <input type="submit" value="Ejecutar">
  
</form>


<div id="divTablas" class="container" >
	<br>
		<table id="tablax" class="table table-striped table-bordered" style="table {
   width: 100%;
   border: 1px solid #000;
}
th, td {
   width: 25%;
   text-align: left;
   vertical-align: top;
   border: 1px solid #000;
   border-collapse: collapse;
   padding: 0.3em;
}"
			style="width: 100%">
			<thead>
				<th>Nombre</th>
				<th>Precio</th>
				
				
			</thead>
			<tbody>
				<c:forEach var="comidas" items="${pedido.comida}">
					<tr>
						<td>${comidas.nombre}</td>
						<td>${comidas.precio}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
          <!-- fin tablas -->
          
          
          <p>total: ${pedido.total }</p>

</body>
</html>