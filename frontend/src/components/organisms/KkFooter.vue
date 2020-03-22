<template>
    <div class="footer-wrapper">
        <div class="seperator"></div>
        <div class="logo">
            <img src="@/assets/logo.svg" alt />
            <div class="email">
                <a>presse@karmakurier.org</a>
            </div>
        </div>
        <div class="partner-wrapper">
            <div class="partner">
                <img src="@/assets/partner/bundesregierung.png" alt />
            </div>
            <div class="partner">
                <img src="@/assets/partner/Logo_WIRvsVIRUS.jpg" alt />
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
    // margin-top: 24px;

    a {
        padding: 0 8px;
        color: gray;
        font-size: 14px;
    }
}

.partner-wrapper {
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    padding-top: 8px;
    // padding: 24px 0 12px 0;
    @media only screen and (min-width: 790px) {
        // padding: 56px 0 12px 0;
    }
    .title {
        position: absolute;
        top: 12px;
        left: 0;
        width: 100%;
        font-size: 14px;
        font-weight: 600;
        color: $dark;
        text-align: center;
        @media only screen and (min-width: 790px) {
            top: 40px;
        }
    }
    .partner {
        margin: 12px;
        cursor: pointer;
        img {
            max-height: 64px;
            max-width: 80px;
            filter: grayscale(100%);
        }
        &:hover {
            img {
                filter: grayscale(0%);
            }
        }
    }
}
</style>