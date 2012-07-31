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
		assert service.getTypeFromString("Chque") == Type.CHECK
		assert service.getTypeFromString("PrŽlvement") == Type.DEBIT
		assert service.getTypeFromString("Virement") == Type.TRANSFER
		assert service.getTypeFromString("Carte") == Type.CREDIT_CARD
	}
	
	void testImportingFile(){
		new File("test/unit/spendings/basic.xls").withInputStream { stream ->
			service.importData stream
		}
		assert Spending.count() != 0
	}
}
