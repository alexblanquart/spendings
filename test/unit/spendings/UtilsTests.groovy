package spendings

import static java.util.Calendar.*

class UtilsTests {
	
	void testDateParsing() {
		def dateAsString = "07/06/2012"
		def date = Utils.getDateFromString(dateAsString)
		assert "06-07-2012" == date.format("MM-dd-yyyy") 
	}
	
	void testGettingInfosFromDate(){
		def date = Utils.getDateFromString('30/12/1985')
		assert 30 == Utils.getDay(date)
		assert 12 == Utils.getMonth(date)
		assert 1985 == Utils.getYear(date)
		
		def lastDay = Utils.getLastDayOfMonth(date)
		assert 31 ==  Utils.getDay(lastDay)
		assert 12 == Utils.getMonth(lastDay)
		assert 1985 == Utils.getYear(lastDay)
		
		def firstDay = Utils.getFirstDayOfMonth(date)
		assert 1 ==  Utils.getDay(firstDay)
		assert 12 == Utils.getMonth(firstDay)
		assert 1985 == Utils.getYear(firstDay)
		
		assert 31 == (firstDay..lastDay).size()
	}

}
