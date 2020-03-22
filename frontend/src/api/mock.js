import { Server } from "miragejs";
import faker from "faker";
import { subHours } from "date-fns";

/**
 * Get random int from 0 to max.
 *
 * @param {number} max
 * @returns {number}
 */
function getRandomInt(max) {
    return Math.floor(Math.random() * Math.floor(max));
}

/**
 * Get id.
 *
 * @returns {number}
 */
function getId() {
    return Math.floor(Math.random() * Math.floor(10000)) + 1;
}

/**
 * Get a person living at the given zip code.
 *
 * @param {string} zipCode
 * @returns {object}
 */
function getPerson(zipCode) {
    return {
        id: getId(),
        firstName: faker.name.firstName(),
        lastName: faker.name.lastName(),
        zipCode: zipCode,
        city: faker.address.city(),
        streetAddress: faker.address.streetAddress(),
        phoneNumber: faker.phone.phoneNumber()
    };
}

/**
 * Get a shopping habit.
 *
 * @returns {object}
 */
function getShoppingHabit() {
    return {
        id: getId(),
        instructions: faker.lorem.sentence()
    };
}

/**
 * Get a payment method.
 *
 * @returns {object}
 */
function getPaymentMethod() {
    return {
        id: getRandomInt(2) === 0 ? 'cash' : 'paypal'
    };
}

/**
 * Get an order at the given zip code.
 *
 * @param {string} zipCode
 * @returns {object}
 */
function getOrder(zipCode) {
    return {
        id: getId(),
        paymentMethod: getPaymentMethod(),
        issuer: getPerson(zipCode),
        shoppingHabit: getShoppingHabit(),
        maximumAmount: Math.round(Math.random() * Math.floor(100), 2),
        shoppingList: faker.lorem.sentence(),
        // Date is not in the API specs!
        date: subHours(new Date(), getRandomInt(12))
    }
}

/**
 * Make a complete zip code from a partial one.
 *
 * @param {string} zipCode
 * @returns {string}
 */
function completeZipCode(zipCode) {
    let zipCodeString = String(zipCode);

    while (zipCodeString.length < 5) {
        zipCodeString += getRandomInt(10);
    }

    return zipCodeString;
}

new Server({
  routes() {
    this.get("/orders/:zipCode", (schema, request) => {
        // Get zip code from url.
        const zipCode = request.params.zipCode;

        // Determine number of results.
        const results = getRandomInt(5);

        // Generate results.
        return [...Array(results).keys()].map(() => (getOrder(completeZipCode(zipCode))));
    });
  },
});
