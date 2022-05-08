<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<c:set scope="request" value="1" var="chapter"/>
<section class="content">
	<div class="container">
		<div class="content-title">
			<h1>${book.name}</h1>
			<c:set value="2" var="chapter"/>
			<div class="content-title-author">
				<p>Tác giả: </p>
				<p>
					<c:forEach items="${book.authors}" var="author" varStatus="loop">						
						<a href="/books?author=${author.slug}" class="author-link">${author.fullname}</a>
					    <c:if test="${loop.index != book.authors.size() - 1}">
							<span href="/books?author=${author.slug}" class="mr-3">, </span>
					    </c:if>
					</c:forEach>
				</p>
			</div>
		</div>
		<div class="content-share">
			<div class="content-share-icon">
				<a href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2F&amp;src=sdkpreparse"><img src="/assets/images/icon1.png" alt=""></a> 
				<a href="https://www.pinterest.com/pin/create/link/?url=https://www.toponseek.com/blogs/wp-content/uploads/2019/06/toi-uu-hinh-anh-optimize-image-4-1200x700.jpg"><img src="/assets/images/icon2.png" alt=""></a> 
				<a href="http://twitter.com/share?text=Your welcome&url=https://www.facebook.com/robocon321/"><img src="/assets/images/icon3.png" alt=""></a>
				<a href="https://www.linkedin.com/sharing/share-offsite/?url=https://www.facebook.com/robocon321/"><img src="/assets/images/icon4.png" alt=""></a>
			</div>
			<div class="content-share-button">
				<c:if test="${existsAudio}">
					<a href="/audio/${book.slug}">
						<div class="content-share-button-icon">
							<i class="fa-solid fa-headphones"></i>
						</div>
						<div class="content-share-button-name">
							<p>Nghe Audio</p>
						</div>
					</a>				
				</c:if>
				<c:if test="${existsPdf}">
					<a href="/pdf-read/${book.slug}">
						<div class="content-share-button-icon">
							<i class="fa-solid fa-file-pdf"></i>
						</div>
						<div class="content-share-button-name">
							<p>Đọc pdf</p>
						</div>
					</a>				
				</c:if>
			</div>
		</div>
		<div class="content-sort">
			<select class="chapter">
				<c:forEach items="${book.onlines}" var="online" varStatus="loop">
					<option value="${loop.index + 1}" <c:if test='${online.id == onlineSelected.id}'>selected</c:if>>Chương ${loop.index + 1}: ${online.name}</option>				
				</c:forEach>
			</select>
		</div>
		<div class="content-container" id="content">
			${onlineSelected.content}
		</div>
		<div class="content-sort">
			<select class="chapter">
				<c:forEach items="${book.onlines}" var="online" varStatus="loop">
					<option value="${loop.index + 1}" <c:if test='${online.id == onlineSelected.id}'>selected</c:if>>Chương ${loop.index + 1}: ${online.name}</option>				
				</c:forEach>
			</select>
		</div>
	</div>
</section>

<script>
	const chapters = document.getElementsByClassName("chapter");
	for (let chapter of chapters) {
		chapter.onchange = () => {
			window.location.replace("?chapter="+chapter.value);
		}	
	}
</script>