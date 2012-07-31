package spendings

class ExcelService {

	/**
	 * Save each line of this input stream as a Spending object in database
	 * @param stream	stream representing an excel file
	 * @return
	 */
	def importData(InputStream stream) {
		println "Importing ..."
		new ExcelBuilder(stream).eachLine([labels:true]) {
			// call intermediate methods for date and type parsing from string representations
			def spending = new Spending(date:getDateFromString(date), amount:amount, type:getTypeFromString(type), label:label, checkId:checkId)
			if (!spending.save()) {
				spending.errors.each { println it }
			}
		}
	}

	/**
	 * Returns a Date from given string
	 * @param dateAsString	should be of the form "07/06/2012"
	 * @return
	 */
	def getDateFromString(String dateAsString){
		Date.parse("dd/MM/yyyy", dateAsString)
	}

	/**
	 * Retunrs the relevant type from the given string
	 * @param typeAsString	for now, only french is supported
	 * @return	null if no type found
	 */
	def getTypeFromString(String typeAsString){
		if (typeAsString ==~ /Ch.que/)
			return Type.CHECK
		else if (typeAsString ==~ /Pr.l.vement/)
			return Type.DEBIT
		else if (typeAsString ==~ /Virement/)
			return Type.TRANSFER
		else if (typeAsString ==~ /Carte/)
			return Type.CREDIT_CARD
		else
			return null 
	}
}
