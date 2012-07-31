<%@ page import="spendings.Spending" %>



<div class="fieldcontain ${hasErrors(bean: spendingInstance, field: 'label', 'error')} ">
	<label for="label">
		<g:message code="spending.label.label" default="Label" />
		
	</label>
	<g:textField name="label" value="${spendingInstance?.label}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: spendingInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="spending.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: spendingInstance, field: 'amount')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: spendingInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="spending.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${spendingInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: spendingInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="spending.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${spendings.Type?.values()}" keys="${spendings.Type.values()*.name()}" required="" value="${spendingInstance?.type?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: spendingInstance, field: 'checkId', 'error')} ">
	<label for="checkId">
		<g:message code="spending.checkId.label" default="Check Id" />
		
	</label>
	<g:textField name="checkId" value="${spendingInstance?.checkId}"/>
</div>

