import { bubbleSortByPrice } from "./utility.js";

export function User(firstName, lastName, email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
}


User.prototype.update = function(subject) {
    let emails = bubbleSortByPrice(subject.emails);
    emails.forEach((email, idx) => {
        if (email.receiver == this) {
            console.log(`%cConnected as ${this.firstName} ${this.lastName}`, 'color:blue');
            console.log(`Email received n°${(idx+1)} :`);
            console.log(`${email.content}`)
        }
    });
}