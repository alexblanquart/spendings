package spendings

import static java.util.Calendar.*

class Utils {
	
	/**
	 * @return map of category/pattern
	 */
	static def getCategoryConfiguration(){
		def categoryFile = new File('grails-app/conf/Category.groovy')
		def config = new ConfigSlurper().parse(categoryFile.toURL())
		config.category.flatten()
	}

	/**
	 * @param dateAsString	should be of the form "07/06/2012"
	 * @return
	 */
	static def getDateFromString(String dateAsString){
		Date.parse("dd/MM/yyyy", dateAsString)
	}

	/**
	 * Note: Months are from 0 to 11
	 * @param date
	 * @return
	 */
	static def getMonth(Date date){
		date[MONTH] + 1
	}

	static def getYear(Date date){
		date[YEAR]
	}

	static def getDay(Date date){
		date[DATE]
	}

	/**
	 * Computes the first day of the month
	 * @param month
	 * @param year
	 * @return
	 */
	static def getFirstDayOfMonth(Date date){
		int min = date.toCalendar().getActualMinimum(GregorianCalendar.DAY_OF_MONTH)
		def firstDay = date.clone()
		firstDay[DATE] = min
		firstDay
	}

	/**
	 * Computes the last day of the month
	 * @param month
	 * @param year
	 * @return
	 */
	static def getLastDayOfMonth(Date date){
		int max = date.toCalendar().getActualMaximum(GregorianCalendar.DAY_OF_MONTH)
		def lastDay = date.clone()
		lastDay[DATE] = max
		lastDay
	}
}
