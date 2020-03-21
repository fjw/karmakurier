import Vue from "vue";
import VueRouter from "vue-router";
import KkDashboard from "../views/KkDashboard.vue";
import KkHome from "../views/KkHome.vue";
import KkAssignmentDetails from "../views/KkAssignmentDetails.vue";
import KkThankYou from "../views/KkThankYou.vue";
import KkHelperLogin from "../views/KkHelperLogin.vue";
import KkHelperSignup from "../views/KkHelperSignup.vue";
import KkQuestions from "../views/KkQuestions.vue";
import KkContact from "../views/KkContact.vue";
import KkSearchHelp from "../views/KkSearchHelp.vue";

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
		path: "/auftragsdetails/:id",
		name: "AssignmentDetails",
		component: KkAssignmentDetails,
		props: true
	},
	{
		path: "/danke",
		name: "ThankYou",
		component: KkThankYou
	},
	{
		path: "/einloggen",
		name: "HelperLogin",
		component: KkHelperLogin
	},
	{
		path: "/moechte-helfen",
		name: "HelperSignup",
		component: KkHelperSignup
	},
	{
		path: "/faq",
		name: "HelperQuestions",
		component: KkQuestions
	},
	{
		path: "/kontakt",
		name: "HelperContact",
		component: KkContact
	},
	{
		path: "/suche-hilfe",
		name: "SearchHelp",
		component: KkSearchHelp
	}
];

const router = new VueRouter({
	mode: "history",
	base: process.env.BASE_URL,
	routes
});

export default router;
