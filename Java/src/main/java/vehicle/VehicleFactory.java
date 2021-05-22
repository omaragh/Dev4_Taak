package vehicle;

public class VehicleFactory {

    public Vehicle createVehicle(VehicleEnum type) {
        if(type == VehicleEnum.BMW){
            return new BMW();
        }
        if(type == VehicleEnum.MERCEDES){
            return new Mercedes();
        }
        if(type == VehicleEnum.AUDI){
            return new Audi();
        }
        throw new IllegalArgumentException("Unlisted vehicle");
    }

}
