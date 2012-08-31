package spendings



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ExcelService)
@Mock([Spending])
class ExcelServiceTests {
	
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
