package spendings



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ExcelService)
@Mock([Spending])
class ExcelServiceTests {

    void testDateParsing() {
        def dateAsString = "07/06/2012"
		def date = service.getDateFromString(dateAsString)
		assert date.format("MM-dd-yyyy") == "06-07-2012" 
    }
	
	void testTypeParsing(){
		assert service.getTypeFromString("Chèque") == Type.CHECK
		assert service.getTypeFromString("Prélèvement") == Type.DEBIT
		assert service.getTypeFromString("Virement") == Type.TRANSFER
		assert service.getTypeFromString("Carte") == Type.CREDIT_CARD
	}
	
	void testImportingFile(){
		def fileName = "test/unit/spendings/basic.xls"
		service.importFile fileName
		assert Spending.count() != 0
	}
}
