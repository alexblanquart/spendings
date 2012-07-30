package spendings



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Spending)
class SpendingTests {

	void testConstraints(){
		mockForConstraintsTests(Spending)
		
		def spending = new Spending()
		assert !spending.validate()
		assert "nullable" == spending.errors["date"]
		assert "nullable" == spending.errors["type"]
		assert "nullable" == spending.errors["amount"]
		
		spending = new Spending(label:"Check without id", amount:100, type:Type.CHECK, date:new Date())
		assert !spending.validate()
		assert "validator" == spending.errors["checkId"]
		
		spending = new Spending(label:"Check with id", amount:100, type:Type.CHECK, date:new Date(), checkId:12)
		assert spending.validate()
		
		spending = new Spending(amount:100, type:Type.CHECK, date:new Date(), checkId:12)
		assert spending.validate()
	}
}
