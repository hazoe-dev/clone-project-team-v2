<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="header-manage-list">
	<div class="logo">
		<img src="/assets/images/webdocsach.png" alt="Logo"
			class="logo-image" />
	</div>

	<div class="account-menu">
		<div class="dropdown ">
			<div class="menu">
				<button class="dropbtn">
					<img src="/assets/images/dacnhantam.png" alt="Account's image"
						class="account-image-circle" /> 
						<!--  Thoai Anh  -->
						 
						 <c:if test="${pageContext.request.userPrincipal.name != null}">
						 ${pageContext.request.userPrincipal.name}
						 
						 <input type="hidden" id="username" name="username" value="${pageContext.request.userPrincipal.name}">
						 <input type="hidden" id="userId" name="custId" value="">
						  </c:if>
				
						 Thoai Anh <i
						class="fas fa-caret-down"></i>
				</button>
			</div>

			<div class="dropdown-content">
				<a href="#">Trang cá nhân</a>
				 <a href="#">Thông báo</a>
				  <a href="#">Cài đặt</a>
				  <a href="<c:url value="/logout" />" >Đăng xuất</a>
			</div>
		</div>

	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$.ajax({       
	       type : "GET",
	       data : "username="+ $("#username").val(),
	       url : "/api/auth/get-id",       
	       success : function(result){
	    	   console.log(result);
	    	   $("#custId").val(result);
	       },
	       error : function(result){
	    	   console.log(result)
	       }
	    });
});
</script>
