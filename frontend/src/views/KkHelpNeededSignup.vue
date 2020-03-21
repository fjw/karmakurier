<template>
    <b-modal has-modal-card active>
        <div class="modal-card">
            <div class="modal-card-body">
                <div class="modal-card-body-head columns is-centered">
                    <div class="column flex-center">
                        <img src="@/assets/logo.svg" alt="Karmakurier Logo" />
                    </div>
                </div>

                <section class="columns is-desktop is-multiline">
                    <b-field class="column is-half"
                             label="Vorname">
                        <b-input type="text" v-model="models.firstName"/>
                    </b-field>
                    <b-field class="column is-half"
                             label="Nachname">
                        <b-input type="text" v-model="models.lastName"/>
                    </b-field>
                    <b-field class="column is-half"
                             label="Straße">
                        <b-input type="text" v-model="models.street"/>
                    </b-field>
                    <b-field class="column is-half"
                             label="PLZ">
                        <b-input type="number" v-model="models.plz"/>
                    </b-field>
                    <b-field class="column is-half"
                             label="Stadt">
                        <b-input type="text" v-model="models.city"/>
                    </b-field>
                    <b-field class="column is-half"
                             label="Telephone">
                        <b-input type="number" v-model="models.phoneNumber"/>
                    </b-field>
                    <b-field class="column is-full"
                             label="Was brauchen Sie?">
                        <b-input type="textarea" v-model="models.textarea"/>
                    </b-field>
                    <b-field class="radio-group column"
                             label="Ich kaufe eher">
                        <b-radio v-model="models.prefered" native-value="premium">Premium</b-radio>
                        <b-radio class="radio-group-radio" v-model="models.prefered" native-value="billig">Billig</b-radio>
                    </b-field>
                    <b-field class="column is-full"
                             label="Wie viel wollen Sie maximal zahlen in Euro?">
                        <b-input type="number" v-model="models.price"/>
                    </b-field>
                    <b-field class="column is-full"
                             label="Zahlung">
                        <b-select v-model="models.paymentMethod">
                            <option value="bargeld">Bargeld</option>
                            <option value="paypal">Paypal</option>
                        </b-select>
                    </b-field>

                    <b-checkbox class="column is-full" v-model="models.agbCheckbox">AGB checkbox</b-checkbox>
                    <div class="column flex-center">
                        <b-button type="is-primary" :disabled="!models.agbCheckbox">Einkauf fordern</b-button>
                    </div>
                </section>
            </div>
        </div>
    </b-modal>
</template>

<script>
export default {
    data() {
        return {
            models: {
                firstName: '',
                lastName: '',
                street: '',
                plz: null,
                city: '',
                phoneNumber: null,
                prefered: 'billig',
                textarea: '',
                price: null,
                paymentMethod: 'paypal',
                agbCheckbox: false,
            },
        };
    },
};
</script>

<style lang="scss" scoped>
.modal-card-body-head {
    img {
        max-width: 100px;
    }
}

.radio-group {
    display: flex;
    flex-direction: column;

    & &-radio {
        margin-top: .5em;
        margin-left: 0;
        padding: 0;
    }
}

.flex-center {
    display: flex;
    justify-content: center;
}
</style>
