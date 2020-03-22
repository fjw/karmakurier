<template>
    <div class="thank-you-wrapper">
        <div class="title">Vielen Dank!</div>
        <div class="subtitle">Wir werden schnellstmöglich einen Helfer finden, der Kontakt zu Ihnen aufnimmt. Wir bitten um etwas Geduld, bis bald!</div>
        <div class="subtitle">Tutorial für die kontaktlose Übergabe</div>
        <div class="video">
            <iframe
                width="560"
                height="315"
                src="https://www.youtube-nocookie.com/embed/2k9MpD1gM14"
                frameborder="0"
                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                allowfullscreen
            ></iframe>
        </div>
        <br>
        <div class="subtitle">Payment process & Karma-System</div>
        <div class="video">
            <iframe
                width="560"
                height="315"
                src="https://www.youtube-nocookie.com/embed/2k9MpD1gM14"
                frameborder="0"
                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                allowfullscreen
            ></iframe>
        </div>
    </div>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.thank-you-wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    padding: 64px 16px 64px 16px;
}

.video {
    height: 315px;
    iframe {
        height: 100%;
        border-radius: 4px;
        overflow: hidden;
        box-shadow: 0px 4px 8px rgba($black, 0.32);
    }
}
</style>