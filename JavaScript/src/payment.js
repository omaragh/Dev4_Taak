export const process = (transaction, vehicle, emailSender) => {
    const priceTTC = applyTVA(vehicle.price, 21);
    return transaction.payment(priceTTC, emailSender);
}


function applyTVA(priceHT, rate) {
    return ((rate + 100) / 100) * priceHT;
}

export function CheckMode(user, signature) {
    this.user = user;
    this.signature = signature;

    this.payment = function(price, emailSender) {
        if (price <= 0) {
            throw new Error("The price must not be less than or equal to 0");
        }
        if (signature) {
            const email = Object.create({
                receiver: this.user,
                price, //to sort by price
                content: `Congratulations ${this.user.firstName.toUpperCase() } ! We hope you will put it to good use !\nVehicle purchase was successful\nPrice of vehicle : ${price} €\nTransaction mode : Check\n\n`
            })
            emailSender.pushEmail(email);
            return price;
        }
        throw new Error("Incorrect data");
    }
}


export function VisaMode(user, numberOfCard, ccv) {
    this.user = user;
    this.numberOfCard = numberOfCard;
    this.ccv = ccv;

    this.payment = function(price, emailSender) {
        if (price <= 0) {
            throw new Error("The price must not be less than or equal to 0");
        }
        if (numberOfCard === "0000-2415-1104-9630" && ccv === 214) {
            const email = Object.create({
                receiver: this.user,
                price, //to sort by price
                content: `Congratulations ${this.user.firstName.toUpperCase() } ! We hope you will put it to good use !\nVehicle purchase was successful\nPrice of vehicle : ${price} €\nTransaction mode : Visa\n\n`
            })
            emailSender.pushEmail(email);
            return price;
        }
        throw new Error("Incorrect data");
    }
}