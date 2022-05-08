<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<header>
	<div class="container-header container">
		<div class="nav-btn d-block d-lg-none">
			<span><i class="fa-solid fa-bars"></i></span>
			<ul>
				<li><a href="/home">Trang chủ</a></li>
				<li><a href="#">Trang chủ</a></li>
				<li><a href="#">Sách nói</a></li>
				<li><a href="#">Ebook</a></li>
				<li><a href="#">Truyện</a></li>
				<li><a href="#">VIP</a></li>
				<li><a href="#">Danh ngôn</a></li>
			</ul>
		</div>
		<div class="logo">
			<a href="#">BookIT.vn</a>
		</div>
		<div class="menu">
			<nav class="d-none d-lg-block">
				<ul>
					<li><a href="/home">Trang chủ</a></li>
					<li><a href="#">Trang chủ</a></li>
					<li><a href="#">Sách nói</a></li>
					<li><a href="#">Ebook</a></li>
					<li><a href="#">Truyện</a></li>
					<li><a href="#">VIP</a></li>
					<li><a href="#">Danh ngôn</a></li>
				</ul>
			</nav>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<span class="my-account">
				<a href="#" class="account">
					<div class="avatar">
						<i class="fa-solid fa-circle-user"></i>
					</div>
					<div class="info">
						<div class="title-info">Tài khoản</div>
						<div class="name-info">${pageContext.request.userPrincipal.name}</div>
					</div>
				</a>
				<a  href="/logout" class="logout-btn"  >Đăng xuất</a>
					
					<input type="hidden" id="username" name="username" value="${pageContext.request.userPrincipal.name}">
					<input type="hidden" id="userId" name="custId" value="">
				</span>
								 
			 </c:if>
		</div>
	</div>
</header>
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
		</div>
	</div>
</header>
