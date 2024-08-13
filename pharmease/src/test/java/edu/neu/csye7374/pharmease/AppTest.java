package edu.neu.csye7374.pharmease;

import org.junit.jupiter.api.Test;

import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.MedicineAPI;
import edu.neu.csye7374.MedicineCategory;
import edu.neu.csye7374.Pharmacist;
import edu.neu.csye7374.Bridge.BrandedMedicineDispenser;
import edu.neu.csye7374.Bridge.GenericMedicineDispenser;
import edu.neu.csye7374.Bridge.MedicalService;
import edu.neu.csye7374.Builder.BuilderAPI;
import edu.neu.csye7374.Builder.MedicineBuilder;
import edu.neu.csye7374.Builder.PharmacistBuilder;
import edu.neu.csye7374.Command.BuyMedicineCommand;
import edu.neu.csye7374.Command.CommandAPI;
import edu.neu.csye7374.Command.SubscribeMedicineCommand;
import edu.neu.csye7374.Decorator.GiftcardDecorator;
import edu.neu.csye7374.Decorator.HealthKitDecorator;
import edu.neu.csye7374.Decorator.MedicineDecorator;
import edu.neu.csye7374.Facade.PharmacyFacade;
import edu.neu.csye7374.Factory.MedicineFactory;
import edu.neu.csye7374.Observer.Order;
import edu.neu.csye7374.Observer.PriceObserver;
import edu.neu.csye7374.Observer.QuantityObserver;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
//	@Test
//	public void testPerson() {
//		Person person = new Person(1, 30, "Doe", "John");
//		assertEquals(1, person.getId());
//		assertEquals("John", person.getFirstName());
//		assertEquals("Doe", person.getLastName());
//		assertEquals(30, person.getAge());
//	}

	@Test
	public void testMedicine() {
		Medicine medicine = new MedicineBuilder(1, "Paracetamol", 10.0, MedicineCategory.OverTheCounter, "ABC Pharma")
				.buildObject();
		assertEquals(1, medicine.getMedicineId());
		assertEquals("Paracetamol", medicine.getMedicineName());
		assertEquals(10.0, medicine.getMedicinePrice(), 0.001);
		assertEquals(MedicineCategory.OverTheCounter, medicine.getMedicineCategory());
		assertEquals("ABC Pharma", medicine.getMedicineManufacturer());
	}

	@Test
	public void testPharmacist() {
		Pharmacist pharmacist = new PharmacistBuilder(1, "John", "Doe", 30, 5000.0).buildObject();
		assertEquals(1, pharmacist.getId());
		assertEquals("John", pharmacist.getFirstName());
		assertEquals("Doe", pharmacist.getLastName());
		assertEquals(30, pharmacist.getAge());
		assertEquals(5000.0, pharmacist.getSalary(), 0.001);
	}

	@Test
	public void testMedicineBuilder() {
		MedicineBuilder builder = new MedicineBuilder(1, "Paracetamol", 10.0, MedicineCategory.OverTheCounter,
				"ABC Pharma");
		Medicine medicine = builder.buildObject();
		assertEquals(1, medicine.getMedicineId());
		assertEquals("Paracetamol", medicine.getMedicineName());
		assertEquals(10.0, medicine.getMedicinePrice(), 0.001);
		assertEquals(MedicineCategory.OverTheCounter, medicine.getMedicineCategory());
		assertEquals("ABC Pharma", medicine.getMedicineManufacturer());
	}

	@Test
	public void testMedicalService() {
		MedicalService brandedDispenser = new BrandedMedicineDispenser(new Medicine(), new Pharmacist());
		MedicalService genericDispenser = new GenericMedicineDispenser(new Medicine(), new Pharmacist());
		brandedDispenser.dispenseMedicine();
		genericDispenser.dispenseMedicine();
	}

	@Test
	public void testBuilderAPI() {
		BuilderAPI<Medicine> builder = new MedicineBuilder(1, "Paracetamol", 10.0, MedicineCategory.OverTheCounter,
				"ABC Pharma");
		Medicine medicine = builder.buildObject();
		assertEquals(1, medicine.getMedicineId());
		assertEquals("Paracetamol", medicine.getMedicineName());
		assertEquals(10.0, medicine.getMedicinePrice(), 0.001);
		assertEquals(MedicineCategory.OverTheCounter, medicine.getMedicineCategory());
		assertEquals("ABC Pharma", medicine.getMedicineManufacturer());
	}

	@Test
	public void testCommandAPI() {
		Medicine medicine = new MedicineBuilder(1, "Paracetamol", 10.0, MedicineCategory.OverTheCounter, "ABC Pharma")
				.buildObject();
		CommandAPI buyCommand = new BuyMedicineCommand().setMedicine(medicine);
		CommandAPI subscribeCommand = new SubscribeMedicineCommand().setMedicine(medicine);
		assertEquals("Paracetamol has been purchased", buyCommand.execute());
		assertEquals(
				"Paracetamol has been added to your subscription list and you will get 5% discount on it from now onwards.",
				subscribeCommand.execute());
	}

	@Test
	public void testDecorator() {
		MedicineAPI medicine = new MedicineBuilder(1, "Paracetamol", 10.0, MedicineCategory.OverTheCounter,
				"ABC Pharma").buildObject();
		MedicineDecorator giftCardDecorator = new GiftcardDecorator(medicine);
		MedicineDecorator healthKitDecorator = new HealthKitDecorator(giftCardDecorator);
		assertEquals("Paracetamol + Free Gift Card of $10 + Free HealthKit Subscription for a month",
				healthKitDecorator.medicineDescription());
	}

	@Test
	public void testFacade() {
		PharmacyFacade pharmacyFacade = new PharmacyFacade("My Pharmacy");
		MedicineBuilder medicineBuilder = new MedicineBuilder(1, "Paracetamol", 10.0, MedicineCategory.OverTheCounter,
				"ABC Pharma");
		pharmacyFacade.addMedicine(medicineBuilder);
		PharmacistBuilder pharmacistBuilder = new PharmacistBuilder(1, "John", "Doe", 30, 5000.0);
		pharmacyFacade.addPharmacist(pharmacistBuilder);
		assertEquals(1, pharmacyFacade.pharmacy.getItemList().size());
		assertEquals(1, pharmacyFacade.pharmacy.getPersonList().size());
	}

	@Test
	public void testFactory() {
		MedicineFactory medicineFactory = MedicineFactory.getInstance();
		MedicineBuilder medicineBuilder1 = new MedicineBuilder(1, "Paracetamol", 10.0, MedicineCategory.OverTheCounter,
				"ABC Pharma");
		Medicine medicine1 = medicineFactory.getObject(medicineBuilder1);
		MedicineBuilder medicineBuilder2 = new MedicineBuilder(2, "Ibuprofen", 15.0, MedicineCategory.OverTheCounter,
				"XYZ Pharma");
		Medicine medicine2 = medicineFactory.getObject(medicineBuilder2);
		assertEquals(1, medicine1.getMedicineId());
		assertEquals("Paracetamol", medicine1.getMedicineName());
		assertEquals(10.0, medicine1.getMedicinePrice(), 0.001);
		assertEquals(2, medicine2.getMedicineId());
		assertEquals("Ibuprofen", medicine2.getMedicineName());
		assertEquals(15.0, medicine2.getMedicinePrice(), 0.001);
	}

	@Test
	public void testSingleton() {
		MedicineFactory medicineFactory1 = MedicineFactory.getInstance();
		MedicineFactory medicineFactory2 = MedicineFactory.getInstance();
		assertEquals(medicineFactory1, medicineFactory2);
	}
}
