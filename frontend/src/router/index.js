import Vue from "vue";
import VueRouter from "vue-router";

// Public Routes
import KkHome from "../views/KkHome.vue";
import KkThankYou from "../views/KkThankYou.vue";
import KKHelperSignup from "../views/KkHelperSignup.vue";
import KkHelperLogin from "../views/KkHelperLogin.vue";
import KkQuestions from "../views/KkQuestions.vue";
import KkContact from "../views/KkContact.vue";
import KkSearchHelp from "../views/KkSearchHelp.vue";
import KkAssignmentSearchView from "../views/KkAssignmentSearchView.vue";
import KkAssignmentOverview from "../views/KkAssignmentOverview.vue";
import KkKarmaRedeem from "../views/KkKarmaRedeem.vue";
import KkHelperDashboard from "../views/KkHelperDashboard.vue";

// User Routes
import KkDashboard from "../views/KkDashboard.vue";
import KkAssignmentDetails from "../views/KkAssignmentDetails.vue";
import KkInvoiceCheck from "../views/KkInvoiceCheck.vue";
import KkMyProfile from "../views/KkMyProfile.vue";
import KkLeaderBoard from "../views/KkLeaderBoard.vue";

// Auditor Routes
import KkAuditorDashboard from "../views/auditor/KkAuditorDashboard.vue";
import KkAuditorInvoiceCheck from "../views/auditor/KkAuditorInvoiceCheck.vue";

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
        path: "/helperdashboard",
        name: "HelperDashboard",
        component: KkHelperDashboard,
        nonavigation: true
    },
	{
		path: "/mein-profil",
		name: "MyProfile",
		component: KkMyProfile
	},
	{
		path: "/auftraege",
		name: "AssignmentOverview",
		component: KkAssignmentOverview,
		props: true
	},
	{
		path: "/auftragsdetails",
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
		path: "/regestrieren",
		name: "HelperRegistration",
		component: KKHelperSignup
	},
	{
		path: "/moechte-helfen",
		name: "AssignmentSerach",
		component: KkAssignmentSearchView
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
	},
	{
		path: "/beleg-check",
		name: "InvoiceCheck",
		component: KkInvoiceCheck
	},
	{
		path: "/redeem",
		name: "KarmaRedeem",
		component: KkKarmaRedeem
	},
	{
		path: "/leader-board",
		name: "LeaderBoard",
		component: KkLeaderBoard
	},

	//Auditor Routes
	{
		path: "/auditor/dashboard",
		name: "AuditorDashboard",
		component: KkAuditorDashboard
	},
	{
		path: "/auditor/beleg-check",
		name: "AuditorInvoiceCheck",
		component: KkAuditorInvoiceCheck
	}
];

const router = new VueRouter({
	mode: "history",
	base: process.env.BASE_URL,
	routes
});

export default router;
