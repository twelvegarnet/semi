<%@page import="dto.Seoul"%>
<%@page import="dto.Review"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Review> list = (List) request.getAttribute("reviewList");
%>
<%
	Seoul sn = (Seoul) request.getAttribute("upso_sno");
%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>
a {
	color: #cc8700
}


details {
    margin-bottom: 1rem;
}

details > summary {
    background: white;
    padding: 1rem;
    outline: 0;
    border-radius: 5px;
    cursor: pointer;
    transition: background 0.5s;
}

details > summary::-webkit-details-marker {
    background: url(https://marshall-storage.tistory.com/attachment/cfile29.uf@993E16335F785C0037CB43.svg) no-repeat center;
    background-size: contain;
    color: transparent;
    transform: rotate3d(0, 0, 1, 90deg);
    transition: transform 0.25s;
}

details[open] > summary::-webkit-details-marker {
    transform: rotate3d(0, 0, 1, 180deg);
}

details[open] > summary {
    background: #FAA600;
}

details[open] > summary ~ * {
    animation: reveal 0.5s;
}

@keyframes reveal {
    from {
        opacity: 0;
        transform: translate3d(0, -10px, 0);
    }

    to {
        opacity: 1;
        transform: translate3d(0, 0, 0);
    }
    
    details > summary::marker {
    /* styles */
}

details > summary::-webkit-details-marker {
    /* styles */
}

button {

    width:100px;

    background-color: #f8585b; border: none; color:#fff; padding: 15px 0; text-align: center;
   text-decoration: none; display: inline-block; font-size: 15px; margin: 4px; cursor: pointer;

}

tr th {
	text-align: center;
}

</style>

<h1 style="text-align: left;">리뷰</h1>

<table class="table">
<div style="text-align:left;" id="btnBox">
	<button class="btn btn-warning" onclick=
	"window.open('/review/write?upso_sno=<%=sn.getUpso_sno()%>','write','width=600,height=800,location=no,status=no,scrollbars=yes');">
	글쓰기</button>
</div>
<br>
<tr class = "text-center">
	<th>회원</th>
	<th>리뷰</th>
	<th>작성일</th>
	<th>별점</th>
	<th>수정/삭제</th>

</tr>

<%
	for(int i=0; i<list.size(); i++) {
%>
<tr>

	<td> <%=list.get(i).getNick()%> </td>
	<td><details><summary><%=list.get(i).getTitle() %></summary><%=list.get(i).getInq_content() %></details></td>
	<td> <%=list.get(i).getCreate_date()%></td>
    <td><%=list.get(i).getStar_score()%></td>
	<td><button onclick="window.open('review/update?reviewno=<%=list.get(i).getReviewno()%>','write','width=600,height=800,location=no,status=no,scrollbars=yes')" class="btn btn-warning" type="button" id="btnUpdate" >수정</button>
	<button onclick="window.open('review/delete?reviewno=<%=list.get(i).getReviewno()%>','write','width=600,height=800,location=no,status=no,scrollbars=yes')" class="btn btn-warning" type="button" id="btnUpdate" >삭제</button></td>
<%
	}
%>

</tr>
</table>

<%@ include file="/WEB-INF/views/layout/pagingReview.jsp" %>
