<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div class="main-content item">
	<div class="title">
		<h2 class="title-content">

			<a class="title-content" href="/admin/books">Danh sách quản lý</a>

		</h2>
	</div>

	<!-- Start Search -->
	<div class="search">


		<label class="search-title"><b>Tìm kiếm:</b></label>
		<form method="POST" action="/admin/search">
			<div class="search-by-bookname">
				<label class="search-bookname-label" for="search-bookname-input">Tên
					sách</label> <input type="text" class="search-bookname-input"
					id="search-bookname-input" name="bookname" value="${bookname}" />
			</div>

			<div class="search-by-authorname">

				<label class="search-authorname-label" for="search-authorname-input">Tên
					tác giả</label> <input type="text" class="search-authorname-input"
					id="search-authorname-input" name="authorname" />
			</div>


			<button class="search-btn" type="submit">
				<i class="fas fa-search"></i>Tìm

			</button>
		</form>

	</div>
	<!-- End Search -->


	<!-- Manage book button -->
	<div class="manage-book">
		<div class="manage-book-btn">
			<a href="#" class="add-book-btn"><i class="fas fa-plus-circle"></i>Thêm
				sách</a> <a href="#" class="delete-book-btn"><i
				class="far fa-times-circle"></i>Xóa</a>
		</div>

		<div class="books-total">

			<p class="books-amount">Tổng số sách là ${total} quyển</p>

		</div>
	</div>
	<!-- Manage book button-->

	<!--Start list books -->
	<div class="list-book-container">
		<h3>${message }</h3>
		<table class="list-book-table">

			<!-- table header -->
			<tr class="header-row">
				<th class="header-row-content"><input type="checkbox"
					name="checkbox-delete-btn" /></th>
				<th class="header-row-content">ID</th>
				<th class="header-row-content">Hình ảnh</th>
				<th class="header-row-content">Tên sách</th>
				<th class="header-row-content">Tác giả</th>
				<th class="header-row-content">Thể loại</th>
				<th class="header-row-content">Trạng thái</th>
				<th class="header-row-content">Ngày đăng</th>
				<th class="header-row-content">Định dạng đọc</th>
				<th class="header-row-content">Tùy chỉnh</th>
			</tr>
			<!--End table header -->
			<c:forEach items="${books}" var="book">
				<!--Start table data -->
				<tr class="data-row">
					<td class="book-data"><input type="checkbox"
						name="checkbok-delete" /></td>
					<td class="book-data">${book.id }</td>
					<td class="book-data tr-book-image"><img
						src="${book.thumbnail }" alt="Image" class="book-image"
						width="36px" height="30px" /></td>
					<td class="book-data tr-width-12">${book.name}</td>
					<td class="book-data  tr-width-12"><c:forEach
							items="${book.authors}" var="author">
	                    
	                     ${author.fullname},
	                    </c:forEach></td>
					<td class="book-data tr-width-12"><c:forEach
							items="${book.categories}" var="category">
	                       ${category.name},
	                      </c:forEach></td>

	
					<c:choose>
						<c:when test="${book.status==1}">
							<td class="book-data">Hoàn thành</td>

						</c:when>
						<c:otherwise>

							<td class="book-data">Đang update</td>
						</c:otherwise>
					</c:choose>

					<td class="book-data">${book.mod_time }</td>
					<td class="book-data tr-width-12">
				
			              <c:forEach items="${readFormats}" var="readFormat">
				               <c:if test="${readFormat.key==book.id }">
				                 <c:forEach items="${readFormat.value}" var="format">
			                          ${format} <br/>
			                      </c:forEach>
			                   </c:if>
						  </c:forEach>
			              
	              	 </td>
	              
					<td class="book-data ">
						<div class="custom-btn">
                         
							<a href="#" class="edit-custom-btn">Sửa</a> 
							<a href="#"
								class="delete-custom-btn">Xóa</a>

						</div>
					</td>
				</tr>
			</c:forEach>

			<!-- End table data -->
		</table>
		<!-- Start paging -->
	
		<div class="paging">
			<ul class="list-paging-numbers">

				<c:if test="${currentpage > 0 }">
					<li><a href="/admin/books/${currentpage-1}"
						class="previous-page">&lt</a>
					<li>
				</c:if>

				<c:forEach items="${totalPages}" var="page">
					<li><a href="/admin/books/${page}" class="page-number ">${page+1}</a></li>
				</c:forEach>


				<c:forEach items="${searchPages}" var="page">
					<li><a href="/admin/search/${page}" class="page-number ">${page+1}</a></li>
				</c:forEach>


				<c:if test="${currentpage < totalPages.size()-1 }">
					<li><a href="/admin/books/${currentpage+1}" class="next-page">&gt</a></li>
				</c:if>
			</ul>
		</div>
	

		<!-- End paging -->
	</div>
	<!--End list books -->
</div>