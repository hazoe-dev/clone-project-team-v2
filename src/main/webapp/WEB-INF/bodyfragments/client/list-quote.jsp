<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/flowbite@1.4.3/dist/flowbite.min.css" />
<script src="https://cdn.tailwindcss.com"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="container py-4">
		<div class="grid md:grid-cols-12 gap-4 mt-2">
			<div class="md:col-span-9">
				<form method="GET" id="form-sort">
					<div class="flex justify-end mb-3">
							<select name="sort" id="sort"
						class="max-w-[200px] bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
								<option value="">Sort</option>
								<option value="view_desc" ${sort=='view_desc'? "selected":"" }>
									<span class="mr-2">View &#8595;</span>
								</option>
								<option value="view_asc" ${sort=='view_asc'? "selected":"" }>
									<span class="mr-2">View &#8593;</span>
								</option>
								<option value="feedback_desc" ${sort=='feedback_desc'? "selected":"" }>
									<span class="mr-2">High feedback &#8595;</span>
								</option>
								<option value="feedback_asc" ${sort=='feedback_asc'? "selected":"" }>
									<span class="mr-2">High feedback &#8593;</span>
								</option>
							</select>
					</div>
				</form>
				<div class="grid md:grid-cols-2 lg:grid-cols-3 gap-4">
					<c:forEach items="${results.content }" var="quote">
						<div
							class="max-w-sm m-auto h-full py-4 px-2 bg-white rounded-lg border border-gray-200 shadow-md flex flex-col items-center justify-between">
							<a href="#"> <img
								class="mx-auto rounded-full h-[150px] w-[150px] mt-3"
								src="${quote.thumbnail}" alt="" />
							</a>
							<div class="px-3 py-3 text-center">
								<p
									style="display: -webkit-box; max-width: 100%; -webkit-line-clamp: 3; -webkit-box-orient: vertical; overflow: hidden;">${quote.content }</p>
							</div>
							<div class="flex justify-center items-center mb-2  flex-wrap">
								<div class="flex items-center text-grey-500 mr-3">
									<span class="mr-2 font-medium">${quote.view}</span>
									<svg class="w-5 h-5" fill="none" stroke="currentColor"
										viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
										<path stroke-linecap="round" stroke-linejoin="round"
											stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"></path>
										<path stroke-linecap="round" stroke-linejoin="round"
											stroke-width="2"
											d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z"></path></svg>
								</div>
								<div class="flex items-center">
									<c:forEach begin="1" end="${quote.getAverageStar()}"
										varStatus="loop">
										<svg class="w-5 h-5 text-yellow-300" fill="currentColor"
											viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
										<path
												d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
										</svg>
									</c:forEach>
									<fmt:parseNumber var="intValue"
										value="${quote.getAverageStar()}" integerOnly="true"></fmt:parseNumber>
									<c:if
										test="${quote.getAverageStar()!=0 && quote.getAverageStar()!=intValue}">
										<div class="relative">
											<span class="absolute"
												style="clip-path: polygon(0 0, 50% 0, 50% 100%, 0% 100%);">
												<svg class="w-5 h-5 text-yellow-300" fill="currentColor"
													viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
											<path
														d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
											</svg>
											</span class="absolute"> <span> <svg class="w-5 h-5 text-gray-300"
													fill="currentColor" viewBox="0 0 20 20"
													xmlns="http://www.w3.org/2000/svg">
											<path
														d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
											</svg>
											</span>
										</div>
									</c:if>
									<c:forEach begin="1" end="${5-quote.getAverageStar()}"
										varStatus="loop">
										<svg class="w-5 h-5 text-gray-300" fill="currentColor"
											viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
										<path
												d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path>
										</svg>
									</c:forEach>
									<span
										class="bg-blue-100 text-blue-800 text-xs font-semibold mr-2 px-2.5 py-0.5 rounded dark:bg-blue-200 dark:text-blue-800 ml-3">${quote.getAverageStar() }</span>
								</div>
								<div class="flex items-center text-gray-600 ml-2  cursor-pointer hover:text-blue-500"
									onclick="showFeedback({
											id: ${quote.id},
										})"
								>
									<svg class="w-5 h-5 hover:text-blue-500" fill="none" stroke="currentColor"
										viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
										<path stroke-linecap="round" stroke-linejoin="round"
											stroke-width="2"
											d="M12 4.354a4 4 0 110 5.292M15 21H3v-1a6 6 0 0112 0v1zm0 0h6v-1a6 6 0 00-9-5.197M13 7a4 4 0 11-8 0 4 4 0 018 0z"></path></svg>
									<span class="ml-2 font-medium">${quote.reviewQuotes.size()}</span>
								</div>
								<div class="flex items-center text-gray-600 ml-2 cursor-pointer hover:text-blue-500" 
									onclick="openQuote({
											id: ${quote.id},
										})">
									<svg class="w-6 h-6 text-gray-500 hover:text-blue-500" fill="currentColor"
										viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
										<path fill-rule="evenodd"
											d="M18 10c0 3.866-3.582 7-8 7a8.841 8.841 0 01-4.083-.98L2 17l1.338-3.123C2.493 12.767 2 11.434 2 10c0-3.866 3.582-7 8-7s8 3.134 8 7zM7 9H5v2h2V9zm8 0h-2v2h2V9zM9 9h2v2H9V9z"
											clip-rule="evenodd"></path></svg>
									<span class="ml-2 font-medium">${quote.commentQuotes.size()}</span>
								</div>
							</div>
							<div
								class="py-2 px-4 bg-gray-100 font-medium rounded-lg max-w-[250px]">
								<p class="font-normal text-center text-gray-700">
									Author:<span class="text-blue-500">
										${quote.author.fullname}</span>
								</p>
								<p class="font-normal text-center text-gray-700">
									Keyword:
									<c:forEach items="${quote.quoteCategories}" var="category">
										<span class="text-blue-500">${category.name}</span>
										<span>, </span>
									</c:forEach>
								</p>
							</div>
							<div class="flex justify-center items-center mt-2">
								<c:set value="${quote.getMyReview(sessionScope.user.id)}"
									var="reviewQuote"></c:set>
								<button
									class="m-2 inline-flex items-center py-2 px-3 text-sm font-medium text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300"
									onclick="openRating({
											quoteId: ${quote.id},
											userId: ${sessionScope.user!=null ? sessionScope.user.id: 'null' }
										})">
									<svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path></svg>
									<span class="ml-2">Rate</span>		
								</button>
								<button
									class="mx-2 inline-flex items-center py-2 px-3 text-sm font-medium text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300"
									onclick="openQuote({
											id: ${quote.id},
										})">
										<svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path d="M5 3a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2V5a2 2 0 00-2-2H5zM5 11a2 2 0 00-2 2v2a2 2 0 002 2h2a2 2 0 002-2v-2a2 2 0 00-2-2H5zM11 5a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2V5zM11 13a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2v-2z"></path></svg>
										<span class="ml-2">View</span>
								</button>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="mt-10 w-full flex justify-center">
					<c:if test="${results.totalPages>0 }">
						<nav aria-label="Page navigation example">
							<ul class="inline-flex -space-x-px">
								<li><a href=""
									data="${results.number > 0 ? results.number:1}"
									class="pagination-link py-2 px-3 ml-0 leading-tight text-white bg-blue-700 rounded-l-lg border border-gray-300 hover:bg-blue-500">Previous</a>
								</li>
								<c:forEach items="${pages}" var="page">
									<c:choose>
										<c:when test="${page!=results.number+1}">
											<li><a href="" data="${page}"
												class="pagination-link py-2 px-3 leading-tight text-white bg-blue-700 border border-gray-300 hover:bg-blue-500">${page }</a>
											</li>
										</c:when>
										<c:otherwise>
											<li><a href="" data="${page }" aria-current="page"
												class="pagination-link py-2 px-3 text-white bg-blue-500 border border-gray-300 hover:bg-blue-500">${page }</a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<li><a href=""
									data="${results.number+2>results.totalPages?results.totalPages:results.number+2}"
									class="pagination-link py-2 px-3 leading-tight text-white bg-blue-700 rounded-r-lg border border-gray-300 hover:bg-blue-500">Next</a>
								</li>
							</ul>
						</nav>
					</c:if>
				</div>
			</div>
			<div class="md:col-span-3">
				<aside class="w-full" aria-label="Sidebar">
					<div class="mb-4 w-full">
						<form class="w-full" method="get" id="form-search">
							<div class="relative mt-1">
								<div
									class="absolute inset-y-0 left-0 flex items-center pl-3 pointer-events-none">
									<svg class="w-5 h-5 text-gray-500" fill="currentColor"
										viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
										<path fill-rule="evenodd"
											d="M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z"
											clip-rule="evenodd"></path></svg>
								</div>
								<input type="text" id="search" name="q"
									class="border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5 "
									placeholder="Search for items">
							</div>
						</form>
					</div>
					<div class="border overflow-y-auto py-4 px-3 rounded w-full">
						<div class="mb-4">
							<h3 class="text-center text-2xl font-medium text-blue-600">DANH
								MUC</h3>
						</div>
						<ul class="space-y-2">
							<li><a href="/quotes"
								class=" ${category==null ?'bg-blue-100':'hover:bg-blue-100' } nav-item flex items-center text-blue-600 p-3 text-base font-normal border-b-2 border-blue-500 text-gray-900 rounded-lg">
									<svg class="w-5 h-5" fill="none" stroke="currentColor"
										viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
											<path stroke-linecap="round" stroke-linejoin="round"
											stroke-width="2" d="M9 5l7 7-7 7"></path></svg> <span
									class="ml-5 text-gray-900 font-medium">Tat ca</span>
							</a></li>
							<c:forEach items="${categories}" var="item">
								<li><a data="${item.id }" href="?category=${item.slug }"
									class="${category==item.slug ?'bg-blue-100':'hover:bg-blue-100' } nav-item flex items-center text-blue-600 p-3 text-base font-normal border-b-2 border-blue-500 text-gray-900 rounded-lg">
										<svg class="w-5 h-5" fill="none" stroke="currentColor"
											viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
											<path stroke-linecap="round" stroke-linejoin="round"
												stroke-width="2" d="M9 5l7 7-7 7"></path></svg> <span
										class="ml-5 text-gray-900 font-medium">${item.name}</span>
								</a></li>
							</c:forEach>
						</ul>
					</div>
				</aside>
			</div>
		</div>
	</div>
	<button
		class="hidden text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center"
		type="button" data-modal-toggle="popup-modal-rate"
		id="button-modal-star">Rating modal</button>

	<div id="popup-modal-rate" tabindex="-1"
		class="fixed top-0 left-0 right-0 z-50 hidden overflow-x-hidden overflow-y-auto md:inset-0 h-modal md:h-full">
		<div class="relative w-full h-full max-w-md p-4 md:h-auto">
			<div class="relative bg-white rounded-lg shadow">
				<button type="button"
					class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center"
					data-modal-toggle="popup-modal-rate">
					<svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
						xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd"
							d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
							clip-rule="evenodd"></path></svg>
				</button>
				<div class="p-6 text-center">
					<form method="post" action="/quotes/review">
						<input type="hidden" id="star-quote" name="quote" />
						<h3 class="mb-4 text-xl font-medium text-gray-900">Rating
							quote</h3>
						<div class="flex items-center w-full justify-center mt-3">
							<c:forEach begin="1" end="5" varStatus="loop" var="index">
								<label onmouseover="selectStar(${index })" for="start-${index }">
									<svg id="svg-star-${index }"
										class="w-10 h-10 text-gray-400 star-item cursor-pointer"
										fill="currentColor" viewBox="0 0 20 20"
										xmlns="http://www.w3.org/2000/svg">
								<path
											d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path></svg>
								</label>
								<input id="star-${index }" type="radio" name="star"
									value="${index }" class="hidden" />
							</c:forEach>
						</div>
						<div class="mt-3 mb-2">
							<textarea id="content" name="content" rows="4"
								class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500"
								placeholder="Your review..."></textarea>
						</div>
						<div class="flex mt-10">
							<button data-modal-toggle="popup-modal-rate" type="submit"
								class="text-white bg-green-600 hover:bg-green-800 focus:ring-4 focus:outline-none focus:ring-green-300 font-medium rounded-lg text-sm inline-flex items-center px-5 py-2.5 text-center mr-2">
								Feedback</button>
							<button data-modal-toggle="popup-modal-rate" type="button"
								class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10">No,
								cancel</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<button
		class="hidden text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center"
		type="button" data-modal-toggle="quote-modal" id="button-modal-quote">
		View modal</button>

	<!-- Main modal -->
	<div id="quote-modal" tabindex="-1" aria-hidden="true"
		class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
		<div class="relative p-4 w-full max-w-4xl h-full md:h-auto">
			<!-- Modal content -->
			<div
				class="relative bg-white rounded-lg shadow overflow-y-auto max-h-[80vh]">
				<button type="button"
					class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center"
					data-modal-toggle="quote-modal">
					<svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
						xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd"
							d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
							clip-rule="evenodd"></path></svg>
				</button>
				<div class="py-6 px-6 lg:px-8">
					<h3 class="mb-4 text-xl font-medium text-gray-900">View quote</h3>
					<div class=mt-3>
						<div class="px-3 py-3 bg-blue-200 rounded-md">
							<p class="mb-3 font-medium text-center">
								&#34;<span id="quote-content"></span>&#34;
							</p>
							<div>
								<p class="font-normal text-gray-700">
									Author: <span class="text-red-500" id="quote-author"></span>
								</p>
								<p class="font-normal text-gray-700">
									Keyword: <span class="text-red-500" id="quote-keyword"></span>
								</p>
							</div>
						</div>
					</div>
					<div class="mt-5">
						<form method="post" action="/quotes/comment">
							<input type="hidden" name="quote" id="comment-quote" /> <label
								for="comment"
								class="block mb-2 text-sm font-medium text-gray-900">Your
								comment</label>
							<textarea required id="comment-content" rows="4" name="content"
								class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500"
								placeholder="Your comment..."></textarea>
							<div class="flex justify-end mt-2">
								<button type="submit"
									class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-3 py-2.5 mb-2 mt-2">Send</button>
							</div>
						</form>
					</div>
					<div class="flex flex-col mt-2" id="list-comment"></div>
				</div>
			</div>
		</div>
	</div>
	
	
	<button
		class="hidden text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center"
		type="button" data-modal-toggle="feedback-view-modal" id="button-modal-feedback">
		feeback modal</button>

	<!-- Main modal -->
	<div id="feedback-view-modal" tabindex="-1" aria-hidden="true"
		class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
		<div class="relative p-4 w-full max-w-4xl h-full md:h-auto">
			<!-- Modal content -->
			<div
				class="relative bg-white rounded-lg shadow overflow-y-auto max-h-[80vh]">
				<button type="button"
					class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center"
					data-modal-toggle="feedback-view-modal">
					<svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20"
						xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd"
							d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
							clip-rule="evenodd"></path></svg>
				</button>
				<div class="py-6 px-6 lg:px-8">
					<h3 class="mb-4 text-xl font-medium text-gray-900 flex">View feedback - <span style="display: -webkit-box; max-width: 70%; -webkit-line-clamp: 1; -webkit-box-orient: vertical; overflow: hidden;" class="ml-2" id="view-feedback-title"></span></h3>
					<div class="flex flex-col mt-2" id="list-feedback">
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<button id="button-authentication-modal" class="hidden text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center" 
		type="button" data-modal-toggle="authentication-modal">
	 Auth modal
	</button>

	<!-- Main modal -->
	<div id="authentication-modal" tabindex="-1" aria-hidden="true" class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 w-full md:inset-0 h-modal md:h-full">
	    <div class="relative p-4 w-full max-w-md h-full md:h-auto">
	        <!-- Modal content -->
	        <div class="relative bg-white rounded-lg shadow">
	            <button type="button" class="absolute top-3 right-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center" data-modal-toggle="authentication-modal">
	                <svg class="w-5 h-5" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z" clip-rule="evenodd"></path></svg>  
	            </button>
	            <div class="py-6 px-6 lg:px-8">
	                <h3 class="mb-4 text-xl font-medium text-gray-900">Sign in to our platform</h3>
	                <form class="space-y-6" action="/auth/login" method="post">
	                    <div>
	                        <label for="username" class="block mb-2 text-sm font-medium text-gray-900">Your username</label>
	                        <input type="text" name="username" id="username" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" placeholder="abc" required>
	                    </div>
	                    <div>
	                        <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300">Your password</label>
	                        <input type="password" name="password" id="password" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" required>
	                    </div>
	                    <div class="flex justify-between">
	                        <div class="flex items-start">
	                            <div class="flex items-center h-5">
	                                <input id="remember" type="checkbox" value="" class="w-4 h-4 bg-gray-50 rounded border border-gray-300 focus:ring-3 focus:ring-blue-300" required>
	                            </div>
	                            <label for="remember" class="ml-2 text-sm font-medium text-gray-900">Remember me</label>
	                        </div>
	                        <a href="#" class="text-sm text-blue-700 hover:underline">Lost Password?</a>
	                    </div>
	                    <button type="submit" class="w-full text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Login to your account</button>
	                    <div class="text-sm font-medium text-gray-500 dark:text-gray-300">
	                        Not registered? <a href="/auth/login" class="text-blue-700 hover:underline">Create account</a>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </div>
	</div> 
	
	<script src="https://unpkg.com/flowbite@1.4.3/dist/flowbite.js"></script>
	<script>
            const url_string = window.location.href;
            const url = new URL(url_string);
            const search = url.searchParams.get("q");
            const paginationLinks = document.querySelectorAll(".pagination-link");
            const navItems = document.querySelectorAll(".nav-item");
            if (paginationLinks) {
                paginationLinks.forEach(item => {
                	var search = location.search.substring(1);
                    const params = search ? JSON.parse('{"' + decodeURI(search).replace(/"/g, '\\"')
                            .replace(/&/g, '","').replace(/=/g, '":"') + '"}') : {};
                    const page = item.getAttribute("data");
                    params.page = page;
                    const href = decodeURIComponent(new URLSearchParams(params).toString());
                    item.setAttribute("href", "?" + href);
                })
            }
        </script>
	<script type="text/javascript">
        	var quote_id;
        	function openRating(quote){
        		if(quote.userId==null){
        			$("#button-authentication-modal").click();
        		}else{
        			for(let i=0;i<5; i++){
            			$("#svg-star-"+(i+1)).removeClass("text-yellow-300");
            			$("#svg-star-"+(i+1)).addClass("text-gray-400");
            		}
            		$("#star-quote").val(quote?.quoteId);
            		$("#content").val("");
            		$.ajax({
    	       			 method: "GET",
    	       			 url: "/api/v1/quotes/"+quote?.quoteId+"/reviews/"+quote?.userId,
    	       		}).done(function (data){
    	       			if(data){
    	            		for(let i=0;i<data?.star; i++){
    	            			$("#svg-star-"+(i+1)).removeClass("text-gray-400");
    	            			$("#svg-star-"+(i+1)).addClass("text-yellow-300");
    	            		}
    	            		$("#content").val(data?.content);
    	       			}
    	       		})
    	       		$("#button-modal-star").click();        			
        		}
        	}
        	
        	function selectStar(numberStar){
        		for(let i=0;i<numberStar; i++){
        			$("#svg-star-"+(i+1)).removeClass("text-gray-400");
        			$("#svg-star-"+(i+1)).addClass("text-yellow-300");
        		}
        		for(let i=numberStar;i<5; i++){
        			$("#svg-star-"+(i+1)).removeClass("text-yellow-300");
        			$("#svg-star-"+(i+1)).addClass("text-gray-400");
        		}
        		$("#star-"+numberStar).prop("checked", true);
        	}
        	
        	
        	function openQuote(quote){
        		let quote_data;
        		$.ajax({
        			 method: "GET",
        			 url: "/api/v1/quotes/"+quote?.id,
        		}).done(function (data){
        			quote_data=data;
        			console.log(quote_data);
        			$("#comment-quote").val(quote_data?.id);
        			$("#quote-content").text(quote_data?.content);
        			$("#quote-author").text(quote_data?.author?.fullname);
            		$("#quote-keyword").text(quote_data?.quoteCategories.map(item => item.name).join(", "));
            		$("#comment-content").val("");
            		var commentHtml = ``;
            		quote_data.commentQuotes?.reverse()?.forEach(function(item) {
            			commentHtml+=` <div class="mb-3">
    						<div class="flex items-start">
    						<div>
    							<div class="relative">
    								<img
    									class="min-w-[60px] min-h-[60px] max-w-[60px] max-h-[60px] rounded-full"
    									src="https://flowbite.com/docs/images/people/profile-picture-5.jpg"
    									alt=""><span
    									class="bottom-0 left-11 absolute  w-3.5 h-3.5 bg-green-400 border-2 border-white rounded-full"></span>
    							</div>
    						</div>
    						<div class="ml-5 p-2 px-4 rounded-[30px] bg-gray-100">
    							<p class="font-bold">`+(item.user.username+" - "+item.user.fullname)+`</p>
    							<p>`+item.content+`<p>
    							<p class="text-sm">
    								<span class="text-blue-500 font-bold cursor-pointer mr-2" onclick=\"showSubComment(`+item.id+`)\">Send</span>
    								- <span class="text-sm">`+new Date(item.modTime).toISOString().slice(0,10).replace(/-/g,"/")+`</span>
    							</p>
    						</div>
    					</div> `;
    					item?.commentQuotes?.forEach(function(child) {
							commentHtml+=`<div class="flex items-start ml-10 mt-3">
								<div>
									<div class="relative">
										<img
											class="min-w-[40px] min-h-[40px] max-w-[40px] max-h-[40px] rounded-full"
											src="https://flowbite.com/docs/images/people/profile-picture-5.jpg"
											alt=""><span
											class="bottom-0 left-7 absolute  w-3.5 h-3.5 bg-green-400 border-2 border-white rounded-full"></span>
									</div>
								</div>
								<div class="ml-5 p-2 px-4 rounded-[30px] bg-gray-100">
									<p class="font-bold">`+(child.user.username+" - "+child.user.fullname)+`</p>
									<p>`+child.content+`<p>
									<p class="text-sm">
										<span class="text-blue-500 font-bold cursor-pointer mr-2" onclick=\"showSubComment(`+item.id+`)\">Send</span>
										- <span class="text-sm">`+new Date(child.modTime).toISOString().slice(0,10).replace(/-/g,"/")+`</span>
									</p>
								</div>
							</div> `;
						});
							
            				commentHtml+= `<div class="w-full mt-3 hidden" id=\"comment-item-`+item.id+`\">
    										<form method="post" action="/quotes/comment">
    											<input type="hidden" name="parent" value=\"`+item.id+`\"/>
    											<textarea id="subcomment-content" rows="4"
    												name="content"
    												required
    												class="block p-2.5 ml-auto w-[90%] text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500"
    												placeholder="Your comment..."></textarea>
    										<div class="flex justify-end mt-2">
    											<button type="submit"
    												class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-3 py-2.5 mb-2 mt-2">Send</button>
    										</div>
    									</form>
    								</div>
    							</div> `;
            			
            		})
            		$("#list-comment").html(commentHtml);
            		$("#button-modal-quote").click();
        		})
        	}
        	
			function showFeedback(quote){
				$.ajax({
       			 	method: "GET",
       			 	url: "/api/v1/quotes/"+quote?.id,
       			}).done(function (quote_data){
       				$("#view-feedback-title").text(quote_data?.content);
       				var commentHtml = ``;
       				if(quote_data.reviewQuotes.length<=0){
       					commentHtml+=`
       						<div class="flex justify-center items-center h-[200px]">
       							<p class="text-xl">No one gives feedback</p>
       						</div>
       					`
       				}
            		quote_data.reviewQuotes?.reverse()?.forEach(function(item) {
            			commentHtml+=` <div class="mb-3">
			    						<div class="flex items-start">
				    						<div>
				    							<div class="relative">
				    								<img
				    									class="min-w-[60px] min-h-[60px] max-w-[60px] max-h-[60px] rounded-full"
				    									src="https://flowbite.com/docs/images/people/profile-picture-5.jpg"
				    									alt=""><span
				    									class="bottom-0 left-11 absolute  w-3.5 h-3.5 bg-green-400 border-2 border-white rounded-full"></span>
				    							</div>
				    						</div>
				    						<div class="ml-5 p-2 px-4 rounded-[30px] bg-gray-100">
				    							<div class="flex items-center">
				    								<p class="font-bold">`+(item.user.username+" - "+item.user.fullname)+`</p>
				    								<div class="flex items-center ml-3">`
				    								
				   	for(let i=0; i<item?.star; i++){
				   		commentHtml += ` <span>
											<svg id="svg-star-feedback-${index }"
											class="w-5 h-5 text-yellow-400 star-item cursor-pointer"
											fill="currentColor" viewBox="0 0 20 20"
											xmlns="http://www.w3.org/2000/svg">
											<path
												d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path></svg>
										</span> `
				    }		
            		for(let i=item?.star; i<5; i++){
    				   		commentHtml += ` <span>
    											<svg id="svg-star-feedback-${index }"
    											class="w-5 h-5 text-gray-400 star-item cursor-pointer"
    											fill="currentColor" viewBox="0 0 20 20"
    											xmlns="http://www.w3.org/2000/svg">
    											<path
    												d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z"></path></svg>
    										</span> `
    				 }	
													
					 commentHtml+=`					</div>
				    							</div>
				    							<p>`+item.content+`<p>
				    							<p class="text-sm">
				    								<span class="text-blue-500 font-bold cursor-pointer mr-2" onclick=\"showSubComment(`+item.id+`)\">Send</span>
				    								- <span class="text-sm">`+new Date(item.modTime).toISOString().slice(0,10).replace(/-/g,"/")+`</span>
				    							</p>
				    						</div>
				    					</div> 
			    					</div>`;
            		})
            		$("#list-feedback").html(commentHtml);
            		$("#button-modal-feedback").click();
       			})
        	}
        	
        	function showSubComment(id){
        		if($("#comment-item-"+id).hasClass("hidden")){
        			$("#comment-item-"+id).removeClass("hidden")	
        		}else{
        			$("#comment-item-"+id).addClass("hidden")	
        		}
        	}
        	
        	
        	
        	document.getElementById("form-search").addEventListener("submit", function(event){
        		  	event.preventDefault();
        		  	const url_string = window.location.href;
		            const url = new URL(url_string);
		            const content = document.getElementById("search").value;
		            var search = location.search.substring(1);
                    const params = search ? JSON.parse('{"' + decodeURI(search).replace(/"/g, '\\"')
                            .replace(/&/g, '","').replace(/=/g, '":"') + '"}') : {};
                    params.q = content;
                    const {page,...newParams} = params;
                    const href = decodeURIComponent(new URLSearchParams(newParams).toString());
                    window.location.href="/quotes?"+href
        	});
        	
        	
        	document.getElementById("sort").addEventListener("change", function(event){
    		  	event.preventDefault();
    		  	const url_string = window.location.href;
	            const url = new URL(url_string);
	            const sort = document.getElementById("sort").value;
	            var search = location.search.substring(1);
                const params = search ? JSON.parse('{"' + decodeURI(search).replace(/"/g, '\\"')
                        .replace(/&/g, '","').replace(/=/g, '":"') + '"}') : {};
                params.sort = sort;
                const {page,...newParams} = params;
                const href = decodeURIComponent(new URLSearchParams(newParams).toString());
                window.location.href="/quotes?"+href
    	});
        	
        </script>
</body>
</html>