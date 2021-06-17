
<%@page import="com.google.gson.Gson"%>
<%@page import="dto.SeoulGrade"%>
<%@page import="review.dto.Seoul"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% List<SeoulGrade> list = (List<SeoulGrade>)request.getAttribute("list"); %>
   <% String[] str = {"https://source.unsplash.com/collection/8774409","https://source.unsplash.com/collection/9689180.jpg","https://source.unsplash.com/collection/4817197.jpg"}; %>

<script type="text/javascript">
json = '<%=new Gson().toJson(list) %>';
</script>

<table class="table table-striped">
	<%int k = 0; %>
	<%for(int i=0;i<list.size();i++){ %>
	<tr>
		<td style="font-size: 50px; width: 150px;" >#<%=i+1 %></td>
		
		<td style="height: 100px;width: 300px; height: 150px;">
		<div class="row">
  			<div class="col-xs-6 col-md-10">
   			 <a href = <%=str[k]%> class="thumbnail">
     		 <img src=<%=str[k]%> alt="...">
     		 <%System.out.println(k);%>
   			 </a>
   			 <%k++; %>
   			 <%if(k > 2) 	k=0; %>
  		</div>
  		</td>
		<td style="font-size: 16px; width: 300px; text-align: left;">
							이름:<%=list.get(i).getUpso_nm() %><a onclick="location.href='/detail?upso_sno=<%=list.get(i).getUpso_sno() %>'"><span style="float: right;" id="moreBtn">자세히보기..</span></a>
							
							<br><br><br>
							평점:<%for(int j=0;j<list.get(i).getAvg();j++) {%>
									<span>⭐</span>
							<%} %><br><br><br>주소:<%=list.get(i).getRdn_code_nm() %><br><br><br>전화번호:<%=list.get(i).getTel_no() %>
		</td>
	</tr>
	<%} %>
</table>
    