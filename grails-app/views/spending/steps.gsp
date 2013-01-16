<%@ page import="spendings.Spending"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<title><g:message code="Visualize" /></title>
<gvisualization:apiImport />
</head>
<body>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<section>
					<h1>Step 1: Import</h1>
					<h2>Choose an excel file to import...</h2>
					<g:form controller="spending" method="post"
						enctype="multipart/form-data">
						<fieldset>
							<input type="file" id="file" name="file" />
							<g:actionSubmit class="btn" action="upload" value="Import" />
						</fieldset>
					</g:form>
				</section>
			</div>
		</div>
		<div class="row-fluid">
			<div class="span12">
				<section>
					<h1>Step 2: Overview</h1>
					<h2>What about my salary ?</h2>
					<h3>Net salary</h3>
					<table>
						<tr>
							<th>Salary</th>
							<th>Month</th>
							<th>Year</th>
						</tr>
						<g:each status="i" in="[0, 5, 10, 15, 20, 25, 30]" var="percent">
							<tr>
								<td>+${percent}%
								</td>
								<td>
									${net*(1+percent/100)}
								</td>
								<td>
									${net*(1+percent/100)*12}
								</td>
							</tr>
						</g:each>
					</table>
					<h3>Gross salary</h3>
					<table>
						<tr>
							<th>Salary</th>
							<th>Month</th>
							<th>Year</th>
						</tr>
						<g:each status="i" in="[0, 5, 10, 15, 20, 25, 30]" var="percent">
							<tr>
								<td>+${percent}%
								</td>
								<td>
									${gross*(1+percent/100)}
								</td>
								<td>
									${gross*(1+percent/100)*12}
								</td>
							</tr>
						</g:each>
					</table>
					<h2>What about my spendings ?</h2>
					<gvisualization:columnCoreChart dynamicLoading="${true}"
						elementId="linechart" title="Line chart" width="${1500}"
						height="${800}" columns="${totalByMonthAndCategoryColumns}"
						data="${totalByMonthAndCategoryData}" series="${series}" />
					<div id="linechart"></div>
				</section>
			</div>
		</div>
	</div>
</body>
</html>
