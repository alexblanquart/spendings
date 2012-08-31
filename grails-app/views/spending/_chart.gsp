<h2>Some charts about spendings</h2>
<gvisualization:apiImport />
<!--<gvisualization:pieCoreChart dynamicLoading="${true}"
	elementId="allSpendings" title="All spendings" width="${800}"
	height="${800}" columns="${spendingsColumnsForPieChart}"
	data="${spendingsDataForPieChart}" />
<div id="allSpendings"></div>
<gvisualization:pieCoreChart dynamicLoading="${true}"
	elementId="allSpendingsOfLastMonth" title="All spendings of last month"
	width="${800}" height="${800}" columns="${spendingsColumnsForPieChart}"
	data="${spendingsDataForPieChart}" />
<div id="allSpendingsOfLastMonth"></div>
<gvisualization:pieCoreChart dynamicLoading="${true}"
	elementId="allSpendingsOfTwoMonthsBefore"
	title="All spendings of two months before" width="${800}"
	height="${800}" columns="${spendingsColumnsForPieChart}"
	data="${spendingsDataForPieChart}" />
<div id="allSpendingsOfTwoMonthsBefore"></div>
<gvisualization:pieCoreChart dynamicLoading="${true}"
	elementId="allSpendingsOfThreeMonthsBefore"
	title="All spendings of three months before" width="${800}"
	height="${800}" columns="${spendingsColumnsForPieChart}"
	data="${spendingsDataForPieChart}" />
<div id="allSpendingsOfThreeMonthsBefore"></div>-->
<gvisualization:columnCoreChart dynamicLoading="${true}"
	elementId="linechart" title="Line chart" width="${1500}" height="${800}"
	columns="${totalByMonthAndCategoryColumns}" data="${totalByMonthAndCategoryData}" 
	series="${series}" />
<div id="linechart"></div>
