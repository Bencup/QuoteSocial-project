<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<table class="table table-tapdown">
		<thead>
			<tr bgcolor="lightgreen">
				<td></td>
				<!-- <th scope="col">id</th> -->
				<th scope="col">Categories</th>
			</tr>
		</thead>
		
		<tbody>

			<c:forEach var="categories" items="${categoriesList}">
				<tr class="success">
					<td></td>
						<td >${categories.categoriesName}</td>
				</tr>
			</c:forEach>



		</tbody>
	</table>
</div>