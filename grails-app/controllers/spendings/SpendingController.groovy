package spendings

import static java.util.Calendar.*

class SpendingController {

	static scaffold = true

	def excelService

	def select = {
	}

	def upload = {
		excelService.importData request.getFile('file').inputStream
		redirect action:'steps'
	}

	def steps = {
		// columns
		def totalByMonthAndCategoryColumns = [['string', 'Month']]

		def numberOfCategories = 0
		Utils.getCategories().each { key, value ->
			totalByMonthAndCategoryColumns.add(['number', key])
			numberOfCategories++
		}
		totalByMonthAndCategoryColumns.add(['number', 'Global total'])

		def months = [
					(Calendar.SEPTEMBER):'September',
					(Calendar.OCTOBER):'October',
					(Calendar.DECEMBER):'December',
					(Calendar.JANUARY):'January'
				]

		// data
		def totalByMonthAndCategoryData = []
		months.each { m ->
			def dataForThisMonth = [m.value]
			def globalTotal = 0
			Utils.getCategories().each { key, value ->
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

		def series = new Expando((numberOfCategories):new Expando(type:'line'))
		["totalByMonthAndCategoryColumns": totalByMonthAndCategoryColumns,
					"totalByMonthAndCategoryData": totalByMonthAndCategoryData, "series":series, "net":Utils.getNetSalary(), "gross":Utils.getGrossPay()]
	}
}
