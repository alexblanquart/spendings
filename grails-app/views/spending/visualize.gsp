<%@ page import="spendings.Spending"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<title><g:message code="Visualization" /></title>
<gvisualization:apiImport />
</head>
<body>
	<%
   def employeeColumns = [['string', 'Name'], ['string', 'Salary'], ['boolean', 'Full Time Employee']]
   def employeeData = [['Mike', '$10,000', true], ['Jim', '$8,000', false], ['Alice', '$12,500', true], 
   ['Bob', '$7,000', true]]   
%>
	<script type="text/javascript">
   function selectHandler(e) {
      alert('A table row was selected');
   }
</script>

	<gvisualization:table elementId="table" width="${400}" height="${130}"
		columns="${employeeColumns}" data="${employeeData}"
		select="selectHandler" />
	<div id="table"></div>
</body>
</html>
