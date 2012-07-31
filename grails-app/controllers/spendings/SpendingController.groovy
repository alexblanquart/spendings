package spendings

class SpendingController {
	
	static scaffold = true

	def excelService
	
	def selectExcelFile = {
		
	}
	
	def importExcelFile = {
		excelService.importData request.getFile('fileToImport').inputStream 
		redirect action:'list'
	}
}
