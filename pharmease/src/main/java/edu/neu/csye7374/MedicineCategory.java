package edu.neu.csye7374;

public enum MedicineCategory {
	Prescription, OverTheCounter, Generic, BrandName, Biological, Herbal, ControlledSubstances;

	public static MedicineCategory getMedicineCategory(String s) {
		MedicineCategory result;
		switch (s.toLowerCase()) {
		case "prescription":
			result = MedicineCategory.Prescription;
			break;
		case "overTheCounter":
			result = MedicineCategory.OverTheCounter;
			break;
		case "generic":
			result = MedicineCategory.Generic;
			break;
		case "brandName":
			result = MedicineCategory.BrandName;
			break;
		case "biological":
			result = MedicineCategory.Biological;
			break;
		case "herbal":
			result = MedicineCategory.Herbal;
			break;
		default:
			result = MedicineCategory.ControlledSubstances;
			break;
		}
		return result;
	}
}
