<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('karmakurierApp.mission.home.title')" id="mission-heading">Missions</span>
            <router-link :to="{name: 'MissionCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-mission">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('karmakurierApp.mission.home.createLabel')">
                    Create a new Mission
                </span>
            </router-link>
        </h2>
        <b-alert :show="dismissCountDown"
            dismissible
            :variant="alertType"
            @dismissed="dismissCountDown=0"
            @dismiss-count-down="countDownChanged">
            {{alertMessage}}
        </b-alert>
        <br/>
        <div class="alert alert-warning" v-if="!isFetching && missions && missions.length === 0">
            <span v-text="$t('karmakurierApp.mission.home.notFound')">No missions found</span>
        </div>
        <div class="table-responsive" v-if="missions && missions.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th><span v-text="$t('global.field.id')">ID</span></th>
                    <th><span v-text="$t('karmakurierApp.mission.firstName')">First Name</span></th>
                    <th><span v-text="$t('karmakurierApp.mission.lastName')">Last Name</span></th>
                    <th><span v-text="$t('karmakurierApp.mission.city')">City</span></th>
                    <th><span v-text="$t('karmakurierApp.mission.maxPrice')">Max Price</span></th>
                    <th><span v-text="$t('karmakurierApp.mission.paymentMethod')">Payment Method</span></th>
                    <th><span v-text="$t('karmakurierApp.mission.assignedHelper')">Assigned Helper</span></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="mission in missions"
                    :key="mission.id">
                    <td>
                        <router-link :to="{name: 'MissionView', params: {missionId: mission.id}}">{{mission.id}}</router-link>
                    </td>
                    <td>{{mission.firstName}}</td>
                    <td>{{mission.lastName}}</td>
                    <td>{{mission.city}}</td>
                    <td>{{mission.maxPrice}}</td>
                    <td v-text="$t('karmakurierApp.PaymentMethod.' + mission.paymentMethod)">{{mission.paymentMethod}}</td>
                    <td>
                        {{mission.assignedHelper ? mission.assignedHelper.lastName : ''}}
                    </td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'MissionView', params: {missionId: mission.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'MissionEdit', params: {missionId: mission.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(mission)"
                                   variant="danger"
                                   class="btn btn-sm"
                                   v-b-modal.removeEntity>
                                <font-awesome-icon icon="times"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                            </b-button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <b-modal ref="removeEntity" id="removeEntity" >
            <span slot="modal-title"><span id="karmakurierApp.mission.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-mission-heading" v-text="$t('karmakurierApp.mission.delete.question', {'id': removeId})">Are you sure you want to delete this Mission?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-mission" v-text="$t('entity.action.delete')" v-on:click="removeMission()">Delete</button>
            </div>
        </b-modal>
    </div>
</template>

<script lang="ts" src="./mission.component.ts">
</script>
