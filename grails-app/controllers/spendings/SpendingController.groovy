package spendings

class SpendingController {
	
	static scaffold = true

	def excelService
	
	def importExcelFile = {
		def fileName = params.fileName
		excelService.importFile fileName
		redirect action:'list'
	}
}
