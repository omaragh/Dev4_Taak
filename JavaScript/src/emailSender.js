export function EmailSender() {
    this.emails = [];
    this.observers = [];
}

EmailSender.prototype.register = function(observer) {
    this.observers.push(observer);
}
EmailSender.prototype.unregister = function(observer) {
    this.observers = this.observers.filter(ob => ob != observer);
}
EmailSender.prototype.notifyUpdates = function() {
    this.observers.forEach(observer => {
        observer.update(this);
    });
}
EmailSender.prototype.pushEmail = function(email) {
    console.log("%c***********************", 'font-weight:bolder;')
    this.emails.push(email);
    this.notifyUpdates();
    this.emails = [];
}