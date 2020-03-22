<template>
    <div class="footer-wrapper">
        <div class="seperator"></div>
        <div class="logo">
            <img src="@/assets/logo.svg" alt />
            <div class="email">
                <a>presse@karmakurier.org</a>
            </div>
        </div>
        <div class="nav">
            <a @click="$router.push('/')" class="copyright">© Copyright karmakurier 2020</a>
            <a @click="$router.push('/impressum')">Impressum</a>
        </div>
    </div>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.footer-wrapper {
    padding: 40px 0;
    .seperator {
        margin-bottom: 16px;
        height: 1px;
        width: 100%;
        background: linear-gradient(
            90deg,
            rgba($black, 0) 0%,
            rgba($black, 0.24) 50%,
            rgba($black, 0) 100%
        );
    }
}

.logo {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    img {
        width: 5rem;
        margin-bottom: 8px;
    }
}
.nav {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 24px;

    a {
        padding: 0 8px;
        color: gray;
        font-size: 14px;
    }
}
</style>