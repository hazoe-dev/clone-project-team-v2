<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/vendor/bootstrap-5.1.3-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/vendor/fontawesome-free-6.1.1-web/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="/vendor/owlcarousel/owl.carousel.min.css">
    <link rel="stylesheet" type="text/css" href="/vendor/owlcarousel/owl.theme.default.min.css" />    
	<link rel="stylesheet" type="text/css" href="/vendor/swiperjs/swiper-bundle.min.css">
    <link rel="stylesheet" type="text/css" href="/css/client/header-footer.css" />
    <link rel="stylesheet" type="text/css" href="/<tiles:insertAttribute name="style" />">
	<link rel="icon" href="/assets/images/favicon.png">    
	<title><tiles:getAsString name="title" /></title>
</head>

<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />
    <script src="/vendor/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
    <script src="/vendor/fontawesome-free-6.1.1-web/js/all.min.js"></script>
    <script src="/vendor/jquery/jquery3.6.0.min.js"></script>
    <script src="/vendor/owlcarousel/owl.carousel.min.js"></script>
	<script src="/vendor/swiperjs/swiper-bundle.min.js"></script>
    
	<script src="<tiles:insertAttribute name="script" />"></script>
    
</body>

</html>