# PharmaEase

## Description
PharmaEase is a comprehensive system designed to manage and streamline pharmacy operations efficiently. It utilizes various design patterns to optimize tasks like medicine dispensation, order handling, and customer service. This system simplifies complex operations, ensuring a seamless experience for both pharmacy staff and customers.

## Design Patterns Used

### Prototype
- **Purpose**: Efficiently manage delivery types by cloning existing instances.
- **Implementation**: `HomeStoreDelivery` and `StorePickUp` classes utilize the prototype pattern to create duplicates of delivery options without needing to re-instantiate them.

### State
- **Purpose**: Handle different states of an order (e.g., confirmed, dispatched, delivered).
- **Implementation**: The state pattern is used to manage various states of an order lifecycle, allowing for a clear transition and management of state-dependent behaviors.

### Factory
- **Purpose**: Create objects without specifying the exact class of object that will be created.
- **Implementation**: `MedicineFactory` and `PharmacistFactory` abstract the instantiation process of medicines and pharmacists.

### Observer
- **Purpose**: Notify changes in the order to different parts of the system.
- **Implementation**: `Order` class uses observers to update various aspects of an order like price adjustments based on the total cost.

### Bridge
- **Purpose**: Decouple an abstraction from its implementation so that the two can vary independently.
- **Implementation**: `BrandedMedicineDispenser` and `GenericMedicineDispenser` separate medicine dispensation logic from the pharmacist's actions.

### Adapter
- **Purpose**: Convert the interface of a class into another interface clients expect.
- **Implementation**: `ManufacturerObjectAdapter` adapts the `Manufacturer` class to be compatible with the `MedicineAPI`.

### Strategy
- **Purpose**: Enable an algorithm’s behavior to be selected at runtime.
- **Implementation**: The `Pharmacy` class can switch between different discount strategies (`EmployeeDiscount`, `StudentDiscount`, `MembershipDiscount`) dynamically.

### Facade
- **Purpose**: Provide a simplified interface to a complex subsystem.
- **Implementation**: `PharmacyFacade` provides simple methods to manage medicines and pharmacists, hiding the complexities of the underlying system.

### Command
- **Purpose**: Encapsulate a request as an object, thereby allowing for parameterization of clients with different requests.
- **Implementation**: `BuyMedicineCommand` and `SubscribeMedicineCommand` encapsulate the actions of buying and subscribing to medicines.

### Decorator
- **Purpose**: Add additional features to objects dynamically.
- **Implementation**: `GiftcardDecorator` and `HealthKitDecorator` enhance the functionality of medicine objects by adding features like gift cards and health subscriptions.

## Team Members
- **Prasad Deshpande**
- **Manikantha Reddy**
- **Naga Venkatesh**
- **Yash Pawar**