package spendings

class ExcelService {

	/**
	 * Save each line of this input stream as a Spending object in database
	 * @param stream	stream representing an excel file
	 * @return
	 */
	def importData(InputStream stream) {
		println "Importing data ..."
		
		new ExcelBuilder(stream).eachLine([labels:true]) {
			// call intermediate methods for date and type parsing from string representations
			def spending = new Spending(
					date:Utils.getDateFromString(date), amount:amount, type:getTypeFromString(type),
					label:label, checkId:checkId, category:getCategoryFromString(label))
			if (!spending.save()) {
				spending.errors.each { println it }
			}
		}
	}

	/**
	 * Retunrs the relevant type from the given string
	 * @param typeAsString	for now, only french is supported
	 * @return	null if no type found
	 */
	def getTypeFromString(String typeAsString){
		if (typeAsString ==~ /Ch.que/)
			return Type.CHECK
		else if (typeAsString ==~ /Pr.l.vement/ || typeAsString ==~ /Retrait/)
			return Type.DEBIT
		else if (typeAsString ==~ /Virement/)
			return Type.TRANSFER
		else if (typeAsString ==~ /Carte/)
			return Type.CREDIT_CARD
		else
			return null
	}

	/**
	 * Returns a category from given label
	 * @param label
	 * @return property found 
	 */
	def getCategoryFromString(String label){
		if (label == null)
			return null
		
		def category = "other"
		Utils.getCategoryConfiguration().each { key, value ->
			value.split(",").each { pattern ->
				if (label.contains(pattern)){
					category = key 
				}
			}
		}
		category
	}
}
