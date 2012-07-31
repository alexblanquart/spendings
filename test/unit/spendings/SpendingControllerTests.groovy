package spendings



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SpendingController)
class SpendingControllerTests {

	void testImportExcelFile() {
		controller.params.fileName = "test.xls"
		def excelService = mockFor(ExcelService)
		excelService.demand.importFile(1..1) { String fileName ->
			// nothing
		}
		controller.excelService = excelService.createMock()
		controller.importExcelFile()

		excelService.verify()
		assert response.redirectedUrl == '/spending/list'
	}
}
