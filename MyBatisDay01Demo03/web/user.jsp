<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <%--<script type="text/javascript" src="js/jquery.js"/>--%>
    <script>
        function request_getUserByid_info() {
            $.ajax(
                {
                    type:"get",
                    url:"${pageContext.request.contextPath}/getUser.do",
                    contentType:"application/json;charset=utf-8",
                    success:function (data) {
                        document.getElementById("us").innerHTML = data.name;
                        //alert(data.name)
                    }
                }
            );
        }
        function request_getUserByid_info2() {
           var xmlhttp;
           if(window.XMLHttpRequest){
               xmlhttp=new XMLHttpRequest();
           }else {
               xmlhttp=new ActiveXObject("Microsoft.XMLHTTP")
           }
           xmlhttp.onreadystatechange=function () {
               if(xmlhttp.readyState==4 && xmlhttp.status ==200){
                   var user = JSON.parse(xmlhttp.responseText);
                   alert(user.id);
                   document.getElementById("us").innerHTML = xmlhttp.responseText;
                   document.getElementById("im").style.display="block";
                   document.getElementById("im").src=user.image;
               }
           }
           xmlhttp.open("get","${pageContext.request.contextPath}/getUser.do",true);
           xmlhttp.send();
        }
    </script>
  </head>
  <body>

  <div id="u"></div>
  <c:if test="${user != null}">
    <table>
      <tr><td>用户名：</td><td>${user.username}</td></tr>
      <tr><td>邮箱：</td><td>${user.email}</td></tr>
      <tr><td>头像：</td><td><img id="im" src="${user.image}" style="height: 150px;width: 200px"></td></tr>
    </table>
  </c:if>
<c:if test="${user == null}">
  请登陆后查看
</c:if>

  </body>
</html>
