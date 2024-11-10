package edu.neu.csye7374.Builder;

import edu.neu.csye7374.Factory.MedicineFactory;
import edu.neu.csye7374.Medicine;
import edu.neu.csye7374.MedicineCategory;

public class MedicineBuilder implements BuilderAPI<Medicine> {
	public int medicineId;
	public String medicineName;
	public double medicinePrice;
	public MedicineCategory medicineCategory;
	public String medicineManufacturer;

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public double getMedicinePrice() {
		return medicinePrice;
	}

	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}

	public MedicineCategory getMedicineCategory() {
		return medicineCategory;
	}

	public void setMedicineCategory(MedicineCategory medicineCategory) {
		this.medicineCategory = medicineCategory;
	}

	public String getMedicineManufacturer() {
		return medicineManufacturer;
	}

	public void setMedicineManufacturer(String medicineManufacturer) {
		this.medicineManufacturer = medicineManufacturer;
	}

	public MedicineBuilder(int medicineId, String medicineName, double medicinePrice, MedicineCategory medicineCategory,
			String medicineManufacturer) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicinePrice = medicinePrice;
		this.medicineCategory = medicineCategory;
		this.medicineManufacturer = medicineManufacturer;
	}

	@Override
	public Medicine buildObject() {
		return MedicineFactory.getInstance().getObject(this);
	}
}
