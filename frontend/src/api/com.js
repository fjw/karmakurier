import axios from "axios";
import parseISO from "date-fns/parseISO";
import { formatRelative } from "date-fns";
import { de } from "date-fns/locale";

/**
 * Fix date in data from API.
 *
 * @param {array} assignments
 * @returns {array}
 */
function parseAssignments(assignments) {
    return assignments.map(assignment => parseAssignment(assignment));
}

function parseAssignment(assignment) {
    if (assignment !== null) {
        assignment.date = parseISO(assignment.date);
        assignment.timeSince = formatRelative(assignment.date, new Date(), { locale: de });
    }

    return assignment;
}

export default {
    // postMission() {
    //     // radiovalues als strings
    // },

    getMissionsInRegion(zipCode) {
        return new Promise(resolve => {
            axios.get("/assignments/" + zipCode).then(r => resolve(parseAssignments(r.data)));
        });
    },

    getMyMissions() {
        return new Promise(resolve => {
            axios.get("/my-assignments/").then(r => resolve(parseAssignments(r.data)));
        });
    },

    getMission(id) {
        return new Promise(resolve => {
            axios.get("/assignment/" + id).then(r => resolve(parseAssignment(r.data.assignment)));
        });
    },

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
