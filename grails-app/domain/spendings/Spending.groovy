package spendings

class Spending {
	
	Date date
	Float amount // in euros by default
	Type type
	String checkId
	String label
	// category

    static constraints = {
		label blank:true, nullable:true, validator:{ val, obj ->
			// only checks may have no label
			if (obj.type != Type.CHECK && val == null){
				return false
			} else {
				return true
			}
		}
		amount nullable:false
		date nullable:false
		type nullable:false, inList:[Type.CHECK, Type.CREDIT_CARD, Type.DEBIT, Type.TRANSFER]
		checkId blank:true, nullable:true, validator:{ val, obj ->
			// checks must have an id
			if (obj.type == Type.CHECK){
				return val!=null
			} else {
				return true
			}
		}
    }
}
