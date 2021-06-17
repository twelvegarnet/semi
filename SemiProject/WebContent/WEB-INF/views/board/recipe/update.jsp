<%@page import="dto.UploadFile"%>
<%@page import="java.util.List"%>
<%@page import="dto.Recipe"%>

<%@include file="/WEB-INF/views/board/recipe/recipeHeader.jsp" %>

<% Recipe recipe = (Recipe) request.getAttribute("recipe"); %>
<% List<UploadFile> fList = (List) request.getAttribute("fileList"); %>

<!-- 스마트에디터 2 -->
<script type="text/javascript"
 src="/Resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
 
<!-- <form>태그의 submit을 수행하면 editor에 작성한 내용을 <textarea>에 반영 -->
<script type="text/javascript">
function submitContents( elClickedObj ) {
	
	//에디터의 내용을 #content에 반영한다
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
	
	try {
		// <form>태그의 submit 수행
		elClickedObj.form.submit();
	} catch(e) {}
	
}
</script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼 동작
	$("#btnUpdate").click(function() {
		
		//스마트 에디터의 내용을 <textarea>에 적용하는 함수를 호출한다
		submitContents( $("#btnUpdate") )
		
		//<form> submit
		$("form").submit();
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
});
</script>
 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
#content {
	/* width: 100%; */
	width: 98%;
}
input .title{
	width: 98%;
}
</style>


<hr style="boarder: 0; height:1px; background: black;"><br>

<div style="width: 1200px; height: 800px; margin:0 auto;">
<div id="area" style="height: 350px;">

<h3 style="text-align: left; margin-top: 45px;">레시피 글수정</h3>
<hr>


<form action="/recipe/update" method="post" >
<table class="table table=bordered">

	<tr>
		<td style="background-color: #fbf8e3">제목</td><td><input type="text" name="title" style="width:100%;" value="<%=recipe.getTitle() %>"/></td>
	</tr>
	<tr>
		<td style="background-color: #fbf8e3">첨부파일</td>
		<td style="text-align: left;">
			<% for(int j=0; j<fList.size(); j++) {%>
				<% if( recipe.getPostno() == fList.get(j).getPostno() ){%>
					<%=fList.get(j).getStoredName() %>
				<% } %>
			<% } %>
		<input type="hidden" name="postno" value="<%=recipe.getPostno() %>"/>
		<input type="hidden" name="create_date" value="<%=recipe.getCreate_date() %>"/>
		<input type="hidden" name="userno" value="<%=recipe.getUserno() %>"/>
		<input type="hidden" name="views" value="<%=recipe.getViews() %>"/>
		</td>
	</tr>
	<tr>		
		<td colspan="2" style="height:300px;"><textarea id="content" name="content"><%=recipe.getInq_content() %></textarea></td>
	</tr>
</table>
<div>
	<button type="button" id="btnUpdate">완료</button>
	<button type="button" id="btnCancel">취소</button>
</div>
</form>
</div>

</div>

<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content", //에디터가 적용될 <textarea>의 id를 입력
	sSkinURI: "/Resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>

<%@include file="/WEB-INF/views/footer/footer.jsp" %>