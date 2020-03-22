
import axios from "axios";

export default {

    getFiles() {
        return new Promise(resolve => {
            axios.get("/editorapi/getfiles").then(r => resolve(r.data));
        });
    },

    getLocks() {
        return new Promise(resolve => {
            axios.get("/editorapi/getlocks").then(r => resolve(r.data));
        });
    },

};



