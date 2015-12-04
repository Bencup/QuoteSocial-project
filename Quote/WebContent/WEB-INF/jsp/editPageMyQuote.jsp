<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


	<!-- content -->
	<div class="container table-tapdown2">	
	<form class="form-horizontal" action="${pageContext.request.contextPath}/editMyQuote.html" method="post">
		<input type="hidden" value="${board.id}" name="id" />
		<fieldset class="col-lg-4 col-lg-offset-4">
			<legend>Edit Book</legend>
			 
			

			<div class="form-group">
				<label  for="name">detail</label>
				<div class="controls">
					<input type="text" class="form-control" id="detailPost" value="${board.detailPost}" name="detailPost"  required/>
					<label class="help-block help-inline"></label>
				</div>
			</div>
			
			

		
			
			
			<div class="form-actions">
				<button class="btn btn-success" type="submit">Submit</button>
			</div>
		</fieldset>
	</form></div>
