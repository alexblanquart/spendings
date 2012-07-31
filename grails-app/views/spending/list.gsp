
<%@ page import="spendings.Spending" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'spending.label', default: 'Spending')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-spending" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-spending" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="label" title="${message(code: 'spending.label.label', default: 'Label')}" />
					
						<g:sortableColumn property="amount" title="${message(code: 'spending.amount.label', default: 'Amount')}" />
					
						<g:sortableColumn property="date" title="${message(code: 'spending.date.label', default: 'Date')}" />
					
						<g:sortableColumn property="type" title="${message(code: 'spending.type.label', default: 'Type')}" />
					
						<g:sortableColumn property="checkId" title="${message(code: 'spending.checkId.label', default: 'Check Id')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${spendingInstanceList}" status="i" var="spendingInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${spendingInstance.id}">${fieldValue(bean: spendingInstance, field: "label")}</g:link></td>
					
						<td>${fieldValue(bean: spendingInstance, field: "amount")}</td>
					
						<td><g:formatDate date="${spendingInstance.date}" /></td>
					
						<td>${fieldValue(bean: spendingInstance, field: "type")}</td>
					
						<td>${fieldValue(bean: spendingInstance, field: "checkId")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${spendingInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
