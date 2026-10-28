interface ParkingCharge {
void calculateCharge();
void displayParkingDetails();
}

class VehicleParking {
String vehicleNo;
String vtype;
int parkingHours;
double totalCharge;

public VehicleParking(String vehicleNo, String vtype, int parkingHours) {
this.vehicleNo = vehicleNo;
this.vtype = vtype;
this.parkingHours = parkingHours;
}
}

class TwoWheeler extends VehicleParking implements ParkingCharge {

public TwoWheeler(String vehicleNo, String vtype, int parkingHours) {
super(vehicleNo, vtype, parkingHours);
}

@Override
public void calculateCharge() {
if (parkingHours <= 2) {
totalCharge = parkingHours * 20;
} else {
totalCharge = (2 * 20) + (parkingHours - 2) * 10;
}
}

@Override
public void displayParkingDetails() {
System.out.println("--- 2-Wheeler Parking Details ---");
System.out.println("Vehicle Number : " + vehicleNo);
System.out.println("Vehicle Type : " + vtype);
System.out.println("Parking Hours : " + parkingHours);
System.out.println("Total Charge : ₹" + totalCharge);
System.out.println();
}
}

class FourWheeler extends VehicleParking implements ParkingCharge {

public FourWheeler(String vehicleNo, String vtype, int parkingHours) {
super(vehicleNo, vtype, parkingHours);
}

@Override
public void calculateCharge() {
if (parkingHours <= 2) {
totalCharge = parkingHours * 50;
} else {
totalCharge = (2 * 50) + (parkingHours - 2) * 30;
}
}

@Override
public void displayParkingDetails() {
System.out.println("--- 4-Wheeler Parking Details ---");
System.out.println("Vehicle Number : " + vehicleNo);
System.out.println("Vehicle Type : " + vtype);
System.out.println("Parking Hours : " + parkingHours);
System.out.println("Total Charge : ₹" + totalCharge);
System.out.println();
}
}

public class ParkingSystemDemo {
public static void main(String[] args) {

ParkingCharge pc1 = new TwoWheeler("KA-01-AB-1234", "2-Wheeler", 3);
pc1.calculateCharge();
pc1.displayParkingDetails();

ParkingCharge pc2 = new FourWheeler("KA-05-XY-9876", "4-Wheeler", 4);
pc2.calculateCharge();
pc2.displayParkingDetails();
}
}
