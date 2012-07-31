
<%@ page import="spendings.Spending" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'spending.label', default: 'Spending')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-spending" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-spending" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list spending">
			
				<g:if test="${spendingInstance?.label}">
				<li class="fieldcontain">
					<span id="label-label" class="property-label"><g:message code="spending.label.label" default="Label" /></span>
					
						<span class="property-value" aria-labelledby="label-label"><g:fieldValue bean="${spendingInstance}" field="label"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${spendingInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="spending.amount.label" default="Amount" /></span>
					
						<span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${spendingInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${spendingInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="spending.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${spendingInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${spendingInstance?.type}">
				<li class="fieldcontain">
					<span id="type-label" class="property-label"><g:message code="spending.type.label" default="Type" /></span>
					
						<span class="property-value" aria-labelledby="type-label"><g:fieldValue bean="${spendingInstance}" field="type"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${spendingInstance?.checkId}">
				<li class="fieldcontain">
					<span id="checkId-label" class="property-label"><g:message code="spending.checkId.label" default="Check Id" /></span>
					
						<span class="property-value" aria-labelledby="checkId-label"><g:fieldValue bean="${spendingInstance}" field="checkId"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${spendingInstance?.id}" />
					<g:link class="edit" action="edit" id="${spendingInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
