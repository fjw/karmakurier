import Vue from "vue";
import VueRouter from "vue-router";
import KkDashboard from "../views/KkDashboard.vue";
import KkHome from "../views/KkHome.vue";
import KkMenu from "../views/KkMenu.vue";

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
		path: "/dashboard",
		name: "Dashboard",
		component: KkDashboard
	},
];

const router = new VueRouter({
	mode: "history",
	base: process.env.BASE_URL,
	routes
});

export default router;
