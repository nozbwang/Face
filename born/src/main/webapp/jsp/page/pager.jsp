<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>	
<link rel="stylesheet" href="../../css/pager.css" type="text/css"  />
<c:if test="${page.totalPage >1}">
	<div class="pager">
		<div class="page-num">
			<c:if test="${page.currentPage != 1}">
				<a href="${page.url }&page=${page.currentPage - 1}" class="prev" rel="nofollow"><i class="icon"></i>Previous</a>
			</c:if>
			<c:if test="${page.currentPage == 5}">
				<a href="${page.url }&page=1">1</a>
			</c:if>
			<c:if test="${page.currentPage > 5}">
				<a href="${page.url }&page=1">1</a>
				<strong class="omit">...</strong>
			</c:if>
			<c:forEach begin="${page.startPage}"  end="${page.endPage}" varStatus="status">
				<c:if test="${status.current == page.currentPage }">
	            	<strong>${status.current}</strong>
				</c:if>
				<c:if test="${status.current != page.currentPage }">
				 	<a href="${page.url }&page=${status.current}">${status.current}</a>
				</c:if>
	    	</c:forEach>
   			<c:if test="${page.currentPage + 4 == page.totalPage}">
				<a href="${page.url }&page=${page.totalPage}">${page.totalPage}</a>
			</c:if>
			<c:if test="${page.currentPage + 4 < page.totalPage}">
				<strong class="omit">...</strong>
				<a href="${page.url }&page=${page.totalPage}">${page.totalPage}</a>
			</c:if>
	    	<c:if test="${page.totalPage != page.currentPage }">
	    		<a href="${page.url }&page=${page.currentPage + 1}" class="next" rel="nofollow">Next<i class="icon"></i></a>
	    	</c:if>
		</div>
	</div>
</c:if>

