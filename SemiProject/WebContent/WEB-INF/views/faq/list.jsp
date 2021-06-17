<%@page import="java.util.List"%>
<%@page import="dto.Faq"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
.faq_container {
	margin-top: 100px;

	min-height: 500px;
}

.title {
	background-color: rgba(204, 204, 204, 0.3);
	text-align: left;
}

.content {
	height: 120px;
	text-align: left;
	margin: 20px;
}




</style>

<%@ include file="/WEB-INF/views/header/header.jsp" %>

<% List<Faq> faq = (List) request.getAttribute("faqList"); %>

<script type="text/javascript">
$(document).ready(function() {
	$(".title").click(function() {
		$(this).next().toggleClass("hidden")
		console.log($("#faqBtn").value);
	})
})
</script>


<ul class="nav nav-tabs" style="margin: 10px; margin-top: 100px;">
  <li role="presentation"><a href="/recipe/list">레시피공유</a></li>
  <li role="presentation" ><a href="/notice/list">공지사항</a></li>
  <li role="presentation" class="active"><a href="/faq/view">FAQ</a></li>
</ul>



<div class="faq_container">

<h1>자주 묻는 질문</h1>
<hr>

<% for(int i = 0; i<faq.size(); i++) { %> 
<div class="title"><button type="button" class="btn btn-link" id="faqBtn">👉</button><%=faq.get(i).getTitle() %></div>
<div class="hidden content"><%=faq.get(i).getInq_content() %></div>
<% } %>

</div>

<div class="clearfix"></div>

<%@ include file="/WEB-INF/views/footer/footer.jsp" %>
