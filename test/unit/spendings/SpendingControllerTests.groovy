package spendings



import grails.test.mixin.*
import org.junit.*
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SpendingController)
class SpendingControllerTests {

	void testImportExcelFile() {
		// mock service
		def excelService = mockFor(ExcelService)
		excelService.demand.importData(1..1) {
			// nothing
		}
		controller.excelService = excelService.createMock()

		// mock request
		controller.metaClass.request = new MockMultipartHttpServletRequest()
		new File("test/unit/spendings/basic.xls").withInputStream { stream ->
			controller.request.addFile(new MockMultipartFile('fileToImport', stream))
		}
		controller.request.setMethod("POST")
		assert controller.request.getFile("fileToImport")
		
		// import by calling controller
		controller.importExcelFile()

		// assert
		excelService.verify()
		assert response.redirectedUrl == '/spending/list'
	}
}
