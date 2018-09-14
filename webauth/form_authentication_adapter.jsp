<%@ page language="java"  session="true" %>
<!DOCTYPE HTML>
<html>
<script src="jquery.js"></script>
<head></head>
<body>
        <%
            String j_username= request.getParameter("j_username");
            String sysid= request.getParameter("sysid");
        %>

        <form id="loginform" method="post" action="j_security_check">
            <input type="hidden" name= "j_username" value="<%=j_username%>"></br>
            <input type="hidden" name= "j_password" value=""></br>
            <input type="hidden" value="submit">
        </form>

        <script>
			var sysid=<%=sysid%>;
			if (sysid<=1) 
			{
				$.ajax({url:"SASLogon/login.jsp?service=https://www.sasmid1.cibt:8343/SASCIStudio/j_spring_cas_security_check",async:false}) ;
			}
			else if (sysid<=2) 
			{
				$.ajax({url:"SASLogon/login.jsp?service=https://www.sasmid1.cibt:7443/j_spring_cas_security_check",async:false});
			}
			else if (sysid<=3)
			{
				$.ajax({url:"SASLogon/login.jsp?service=https://www.sasmid1.cibt:8343/SASFSAdmin/j_spring_cas_security_check",async:false}) ;
            }
            else if (sysid<=4)
            {
                $.ajax({url:"SASLogon/login.jsp?service=https://www.sasmid1.cibt:8343/SASDecisionManager/j_spring_cas_security_check",async:false}) ;
            };
				
			document.getElementById("loginform").submit();
        </script>

</body>
</html>
