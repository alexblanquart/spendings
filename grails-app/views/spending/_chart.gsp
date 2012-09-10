<h2>What we spent ! What we need !</h2>
<gvisualization:apiImport />
<table>
	<tr>
		<th>Salary</th>
		<th>Month</th>
		<th>Year</th>
	</tr>
	<g:each status="i" in="[0, 5, 10, 15, 20, 25, 30]" var="percent">
		<tr>
			<td>+${percent}%</td>
			<td>
				${net*(1+percent/100)}
			</td>
			<td>
				${net*(1+percent/100)*12}
			</td>
		</tr>
	</g:each>
</table>
<table>
	<tr>
		<th>Salary</th>
		<th>Month</th>
		<th>Year</th>
	</tr>
	<g:each status="i" in="[0, 5, 10, 15, 20, 25, 30]" var="percent">
		<tr>
			<td>+${percent}%</td>
			<td>
				${gross*(1+percent/100)}
			</td>
			<td>
				${gross*(1+percent/100)*12}
			</td>
		</tr>
	</g:each>
</table>
<gvisualization:columnCoreChart dynamicLoading="${true}"
	elementId="linechart" title="Line chart" width="${1500}"
	height="${800}" columns="${totalByMonthAndCategoryColumns}"
	data="${totalByMonthAndCategoryData}" series="${series}" />
<div id="linechart"></div>

