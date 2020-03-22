import Vue from "vue";
import Buefy from "buefy";
import App from "./App.vue";
import "./registerServiceWorker";
import router from "./router";
import store from "./store";

// I think this can be deleted once the dev DB is setup
import "./api/mock";

// Form Validation
import {
	ValidationObserver,
	ValidationProvider,
	extend,
	localize
} from "vee-validate";
import { required, email, min } from "vee-validate/dist/rules";
import de from "vee-validate/dist/locale/de.json";

extend("required", required);
extend("email", email);
extend("min", min);
localize("de", de);
Vue.component("ValidationObserver", ValidationObserver);
Vue.component("ValidationProvider", ValidationProvider);

// Other
Vue.config.productionTip = false;
Vue.use(Buefy);

new Vue({
	router,
	store,
	render: h => h(App)
}).$mount("#app");
