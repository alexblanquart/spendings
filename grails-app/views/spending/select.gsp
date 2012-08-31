<%@ page import="spendings.Spending"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'spending.label', default: 'Spending')}" />
<title><g:message code="Selection" /></title>
</head>
<body>
	<a href="#create-spending" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" />
	</a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /> </a></li>
			<li><g:link class="list" action="list">
					<g:message code="default.list.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	<div id="import-spending" class="content scaffold-create" role="main">
		<h1>
			<g:message code="Selection" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<g:form controller="spending" method="post"
			enctype="multipart/form-data">
			<label>Select an excel to import</label>
			<input type="file" id="file" name="file" />
			<g:actionSubmit action="upload" value="Upload" />
		</g:form>
	</div>
</body>
</html>