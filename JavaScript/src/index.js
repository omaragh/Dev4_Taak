import { EmailSender } from "./emailSender.js";
import { CheckMode, process, VisaMode } from "./payment.js";
import { User } from "./user.js";
import { Vehicle } from "./vehicle.js";

(function main() {
    let emailSender = new EmailSender();

    //2 users
    //For example, user1 is a company, so she will buy 5 vehicles for her employees 
    let user1 = new User("Jean", "Dupont", "jean.dupont@hotmail.be");

    //user2 is an individual
    let user2 = new User("Albert", "Einstein", "albert.einstein@gmail.be");

    //subscribe 2 users to receive an email when purchasing vehicles
    emailSender.register(user1);
    emailSender.register(user2);

    //payment methods by Visa or Check
    let checkMode = new CheckMode(user1, true);
    let visaMode = new VisaMode(user2, "0000-2415-1104-9630", 214);

    //6 vehicles to buy.
    let companyVehicles = [
        new Vehicle("BMW", "Serie 1", 5, 19500, 2019),
        new Vehicle("Mercedes", "Class C", 3, 50000, 2017),
        new Vehicle("Ford", "Focus", 5, 28950, 2020),
        new Vehicle("Audi", "A1", 5, 18500, 2019),
        new Vehicle("Renault", "Traffic", 5, 25260, 2014),
    ]
    let mercedes = new Vehicle("Mercedes", "Class A", 5, 25100, 2021);

    //Apply the payment process for the 6 vehicles.
    process(visaMode, mercedes, emailSender);

    //emailSender.unregister(user1)
    companyVehicles.forEach(vehicle => {
        process(checkMode, vehicle, emailSender);
    });
})();