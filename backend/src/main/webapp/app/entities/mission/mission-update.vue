<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="karmakurierApp.mission.home.createOrEditLabel" v-text="$t('karmakurierApp.mission.home.createOrEditLabel')">Create or edit a Mission</h2>
                <div>
                    <div class="form-group" v-if="mission.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="mission.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.firstName')" for="mission-firstName">First Name</label>
                        <input type="text" class="form-control" name="firstName" id="mission-firstName"
                            :class="{'valid': !$v.mission.firstName.$invalid, 'invalid': $v.mission.firstName.$invalid }" v-model="$v.mission.firstName.$model"  required/>
                        <div v-if="$v.mission.firstName.$anyDirty && $v.mission.firstName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.mission.firstName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.lastName')" for="mission-lastName">Last Name</label>
                        <input type="text" class="form-control" name="lastName" id="mission-lastName"
                            :class="{'valid': !$v.mission.lastName.$invalid, 'invalid': $v.mission.lastName.$invalid }" v-model="$v.mission.lastName.$model"  required/>
                        <div v-if="$v.mission.lastName.$anyDirty && $v.mission.lastName.$invalid">
                            <small class="form-text text-danger" v-if="!$v.mission.lastName.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.street')" for="mission-street">Street</label>
                        <input type="text" class="form-control" name="street" id="mission-street"
                            :class="{'valid': !$v.mission.street.$invalid, 'invalid': $v.mission.street.$invalid }" v-model="$v.mission.street.$model"  required/>
                        <div v-if="$v.mission.street.$anyDirty && $v.mission.street.$invalid">
                            <small class="form-text text-danger" v-if="!$v.mission.street.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.zip')" for="mission-zip">Zip</label>
                        <input type="text" class="form-control" name="zip" id="mission-zip"
                            :class="{'valid': !$v.mission.zip.$invalid, 'invalid': $v.mission.zip.$invalid }" v-model="$v.mission.zip.$model"  required/>
                        <div v-if="$v.mission.zip.$anyDirty && $v.mission.zip.$invalid">
                            <small class="form-text text-danger" v-if="!$v.mission.zip.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                            <small class="form-text text-danger" v-if="!$v.mission.zip.minLength" v-text="$t('entity.validation.minlength', {min: 5})">
                                This field is required to be at least 5 characters.
                            </small>
                            <small class="form-text text-danger" v-if="!$v.mission.zip.maxLength" v-text="$t('entity.validation.maxlength', {max: 5})">
                                This field cannot be longer than 5 characters.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.city')" for="mission-city">City</label>
                        <input type="text" class="form-control" name="city" id="mission-city"
                            :class="{'valid': !$v.mission.city.$invalid, 'invalid': $v.mission.city.$invalid }" v-model="$v.mission.city.$model"  required/>
                        <div v-if="$v.mission.city.$anyDirty && $v.mission.city.$invalid">
                            <small class="form-text text-danger" v-if="!$v.mission.city.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.email')" for="mission-email">Email</label>
                        <input type="text" class="form-control" name="email" id="mission-email"
                            :class="{'valid': !$v.mission.email.$invalid, 'invalid': $v.mission.email.$invalid }" v-model="$v.mission.email.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.phoneNumber')" for="mission-phoneNumber">Phone Number</label>
                        <input type="text" class="form-control" name="phoneNumber" id="mission-phoneNumber"
                            :class="{'valid': !$v.mission.phoneNumber.$invalid, 'invalid': $v.mission.phoneNumber.$invalid }" v-model="$v.mission.phoneNumber.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.order')" for="mission-order">Order</label>
                        <textarea class="form-control" name="order" id="mission-order"
                            :class="{'valid': !$v.mission.order.$invalid, 'invalid': $v.mission.order.$invalid }" v-model="$v.mission.order.$model"  required></textarea>
                        <div v-if="$v.mission.order.$anyDirty && $v.mission.order.$invalid">
                            <small class="form-text text-danger" v-if="!$v.mission.order.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.priceCategory')" for="mission-priceCategory">Price Category</label>
                        <select class="form-control" name="priceCategory" :class="{'valid': !$v.mission.priceCategory.$invalid, 'invalid': $v.mission.priceCategory.$invalid }" v-model="$v.mission.priceCategory.$model" id="mission-priceCategory"  required>
                            <option value="PREMIUM" v-bind:label="$t('karmakurierApp.PriceCategory.PREMIUM')">PREMIUM</option>
                            <option value="CHEAP" v-bind:label="$t('karmakurierApp.PriceCategory.CHEAP')">CHEAP</option>
                        </select>
                        <div v-if="$v.mission.priceCategory.$anyDirty && $v.mission.priceCategory.$invalid">
                            <small class="form-text text-danger" v-if="!$v.mission.priceCategory.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.maxPrice')" for="mission-maxPrice">Max Price</label>
                        <input type="number" class="form-control" name="maxPrice" id="mission-maxPrice"
                            :class="{'valid': !$v.mission.maxPrice.$invalid, 'invalid': $v.mission.maxPrice.$invalid }" v-model.number="$v.mission.maxPrice.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.paymentMethod')" for="mission-paymentMethod">Payment Method</label>
                        <select class="form-control" name="paymentMethod" :class="{'valid': !$v.mission.paymentMethod.$invalid, 'invalid': $v.mission.paymentMethod.$invalid }" v-model="$v.mission.paymentMethod.$model" id="mission-paymentMethod"  required>
                            <option value="PAYPAL" v-bind:label="$t('karmakurierApp.PaymentMethod.PAYPAL')">PAYPAL</option>
                            <option value="CASH" v-bind:label="$t('karmakurierApp.PaymentMethod.CASH')">CASH</option>
                        </select>
                        <div v-if="$v.mission.paymentMethod.$anyDirty && $v.mission.paymentMethod.$invalid">
                            <small class="form-text text-danger" v-if="!$v.mission.paymentMethod.required" v-text="$t('entity.validation.required')">
                                This field is required.
                            </small>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('karmakurierApp.mission.assignedHelper')" for="mission-assignedHelper">Assigned Helper</label>
                        <select class="form-control" id="mission-assignedHelper" name="assignedHelper" v-model="mission.assignedHelper">
                            <option v-bind:value="null"></option>
                            <option v-bind:value="mission.assignedHelper && userOption.id === mission.assignedHelper.id ? mission.assignedHelper : userOption" v-for="userOption in users" :key="userOption.id">{{userOption.lastName}}</option>
                        </select>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.mission.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./mission-update.component.ts">
</script>
