import { Server, Model } from "miragejs";
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
 * Get a random assignment at the given zip code.
 *
 * @param {string} zipCode
 * @returns {object}
 */
function getRandomAssignment(zipCode) {
    return {
        id: getId(),
        person: getPerson(zipCode),
        shoppingList: faker.lorem.sentence(),
        date: subHours(new Date(), getRandomInt(12))
    }
}

// Base zip code for all generated assignments.
const baseZipCode = "817";

new Server({
    // Define models.
    models: {
        assignment: Model,
    },

    // Seed the server.
    seeds(server) {
        // Create random assignments.
        for (let i = 0; i <= 9; i++) {
            for (let j = 0; j <= 9; j++) {
                const zipCode = baseZipCode + i + j;
                server.schema.assignments.create(getRandomAssignment(zipCode));
            }
        }
    },

    routes() {
        // Get assignments by zip code.
        this.get("/assignments/:zipCode", (schema, request) => {
            // Get zip code from url.
            const zipCode = request.params.zipCode;

            return schema.assignments.where(assignment => assignment.person.zipCode.startsWith(zipCode)).models;
        });

        // Get my assignments.
        this.get("/my-assignments", (schema) => {
            return [schema.assignments.first()];
        }),

        // Get a single assignment.
        this.get("/assignment/:id", (schema, request) => {
            const id = request.params.id;

            return schema.assignments.find(id);
        })
    },
});
