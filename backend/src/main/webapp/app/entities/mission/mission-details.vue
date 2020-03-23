<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="mission">
                <h2 class="jh-entity-heading"><span v-text="$t('karmakurierApp.mission.detail.title')">Mission</span> {{mission.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.firstName')">First Name</span>
                    </dt>
                    <dd>
                        <span>{{mission.firstName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.lastName')">Last Name</span>
                    </dt>
                    <dd>
                        <span>{{mission.lastName}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.street')">Street</span>
                    </dt>
                    <dd>
                        <span>{{mission.street}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.zip')">Zip</span>
                    </dt>
                    <dd>
                        <span>{{mission.zip}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.city')">City</span>
                    </dt>
                    <dd>
                        <span>{{mission.city}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.email')">Email</span>
                    </dt>
                    <dd>
                        <span>{{mission.email}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.phoneNumber')">Phone Number</span>
                    </dt>
                    <dd>
                        <span>{{mission.phoneNumber}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.order')">Order</span>
                    </dt>
                    <dd>
                        <span>{{mission.order}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.priceCategory')">Price Category</span>
                    </dt>
                    <dd>
                        <span v-text="$t('karmakurierApp.PriceCategory.' + mission.priceCategory)">{{mission.priceCategory}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.maxPrice')">Max Price</span>
                    </dt>
                    <dd>
                        <span>{{mission.maxPrice}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.paymentMethod')">Payment Method</span>
                    </dt>
                    <dd>
                        <span v-text="$t('karmakurierApp.PaymentMethod.' + mission.paymentMethod)">{{mission.paymentMethod}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('karmakurierApp.mission.assignedHelper')">Assigned Helper</span>
                    </dt>
                    <dd>
                        {{mission.assignedHelper ? mission.assignedHelper.lastName : ''}}
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="mission.id" :to="{name: 'MissionEdit', params: {missionId: mission.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./mission-details.component.ts">
</script>
