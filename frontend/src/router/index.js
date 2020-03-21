import Vue from "vue";
import VueRouter from "vue-router";
import KkDashboard from "../views/KkDashboard.vue";
import KkHome from "../views/KkHome.vue";
import KkAssignmentOverview from "../views/KkAssignmentOverview.vue";
import KkThankYou from "../views/KkThankYou.vue";
import KkHelperLogin from "../views/KkHelperLogin.vue";
import KkHelperSignup from "../views/KkHelperSignup.vue";

Vue.use(VueRouter);

const routes = [
	{
		path: "/",
		name: "Home",
		component: KkHome
	},
	{
		path: "/dashboard",
		name: "Dashboard",
		component: KkDashboard
	},
	{
		path: "/auftraege",
		name: "AssignmentOverview",
		component: KkAssignmentOverview
	},
	{
		path: "/thank-you",
		name: "ThankYou",
		component: KkThankYou
	},
	{
		path: "/login",
		name: "HelperLogin",
		component: KkHelperLogin
	},
	{
		path: "/signup",
		name: "HelperSignup",
		component: KkHelperSignup
	}
];

const router = new VueRouter({
	mode: "history",
	base: process.env.BASE_URL,
	routes
});

export default router;
