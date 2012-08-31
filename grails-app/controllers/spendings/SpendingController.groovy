package spendings

import static java.util.Calendar.*

class SpendingController {

	static scaffold = true

	def excelService

	def select = {
	}

	def upload = {
		excelService.importData request.getFile('file').inputStream
		redirect action:'list'
	}

	def overview = {
		// columns
		def totalByMonthAndCategoryColumns = [['string', 'Month']]
		
		def numberOfCategories = 0
		Utils.getCategoryConfiguration().each { key, value ->
			totalByMonthAndCategoryColumns.add(['number', key])
			numberOfCategories++
		}
		totalByMonthAndCategoryColumns.add(['number', 'Global total'])

		def months = [
					(Calendar.JUNE):'June',
					(Calendar.JULY):'July',
					(Calendar.AUGUST):'August',
					(Calendar.SEPTEMBER):'September',
				]

		// data
		def totalByMonthAndCategoryData = []
		months.each { m ->
			def dataForThisMonth = [m.value]
			def globalTotal = 0
			Utils.getCategoryConfiguration().each { key, value ->
				def query = Spending.where {
					month(date) == m.key + 1 && category == key
				}
				def total = query.findAll().inject(0) { total, spending ->
					total += spending.amount
				}
				dataForThisMonth.add(total)
				globalTotal += total
			}
			dataForThisMonth.add(globalTotal)
			totalByMonthAndCategoryData.add(dataForThisMonth)
		}

		/*def totalByCategoryColumns = [
		 ['string', 'Category'],
		 ['number', 'Total']
		 ]
		 def spendingsDataForPieChart = Category.inject([]) { data, category ->
		 def total = Spending.findAllByCategory(category).inject(0) { total, spending ->
		 total += spending.amount
		 }
		 println "Total for " + category + " of " + total
		 if (total > 0){
		 data.add([category, total])
		 } else {
		 data.add([category, Math.abs(total)])
		 }
		 data
		 }*/

		def series = new Expando((numberOfCategories):new Expando(type:'line'))
		render template: "chart", model: ["totalByMonthAndCategoryColumns": totalByMonthAndCategoryColumns,
					"totalByMonthAndCategoryData": totalByMonthAndCategoryData, "series":series]
	}
}
