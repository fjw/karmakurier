import Vue from "vue";
import VueRouter from "vue-router";
import KkDashboard from "../views/KkDashboard.vue";
import KkHome from "../views/KkHome.vue";
import KkMenu from "../views/KkMenu.vue";
import KkAssignmentOverview from "../views/KkAssignmentOverview.vue";
import KkAssignmentDetails from "../views/KkAssignmentDetails.vue";
import KkThankYou from "../views/KkThankYou.vue";
import KkHelperLogin from "../views/KkHelperLogin.vue";
import KkHelperSignup from "../views/KkHelperSignup.vue";
import KkSearch from "../views/KkSearch.vue";
import KkOffer from "../views/KkOffer.vue";
import KkQuestions from "../views/KkQuestions.vue";
import KkContact from "../views/KkContact.vue";
import KkHelpNeededSignup from "../views/KkHelpNeededSignup.vue";

Vue.use(VueRouter);

const routes = [
	{
		path: "/",
		name: "Home",
		component: KkHome
	},
	{
		path: "/menu",
		name: "Menu",
		component: KkMenu
	},
	{
		path: "/help-needed-signup",
		name: "Help needed signup",
		component: KkHelpNeededSignup
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
        path: "/auftragsdetails",
        name: "AssignmentDetails",
        component: KkAssignmentDetails
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
	},
	{
		path: "/suche",
		name: "HelperSearch",
		component: KkSearch
	},
	{
		path: "/biete",
		name: "HelperOffer",
		component: KkOffer
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
	}
];

const router = new VueRouter({
	mode: "history",
	base: process.env.BASE_URL,
	routes
});

export default router;
