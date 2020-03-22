import axios from "axios";

export default {
    // postMission() {
    //     // radiovalues als strings
    // },

    getMissionsInRegion(zipCode) {
        return new Promise(resolve => {
            axios.get("/assignments/" + zipCode).then(r => resolve(r.data.assignments));
        });
    },

    // getMission(id) {
    //     //only logged in

    //     //geolocation in frontend
    // },

    // acceptMisson() {
    // },

    //--------------- nur als Vorlage
    // getFiles() {
    //     return new Promise(resolve => {
    //         axios.get("/editorapi/getfiles").then(r => resolve(r.data));
    //     });
    // },

    // getLocks() {
    //     return new Promise(resolve => {
    //         axios.get("/editorapi/getlocks").then(r => resolve(r.data));
    //     });
    // },

    // saveFileChanges(path, content) {
    //     axios.post("/editorapi/savefilechanges",{ path, content, connectionid: echo.socketId() });
    // },
};
