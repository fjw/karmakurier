<template>
    <div class="thank-you-wrapper">
        <div class="title">Vielen Dank!</div>
        <br>
        <div class="subtitle">Wir werden schnellstmöglich einen Helfer finden, der Kontakt zu Ihnen aufnimmt.</div>
        <div class="subtitle">Es wird sich in Kürze jemand bei Ihnen melden - wir bitten um etwas Geduld.</div>
        <br>
        <div class="subtitle">Kontaktlose Lieferung</div>
        <div class="text">Gerade jetzt ist es besonders wichtig, bewusst und verantwortungsvoll im zwischenmenschlichen Kontakt zu sein. Daher gilt es das Übertragungsrisiko zu minimieren und eine kontaktlose Übergabe zwischen unseren Helfern und Hilfesuchenden sicherzustellen.</div>
        <br>
        <div class="text">Für die Übergabe der Besorgungen bedeutet dies, dass der Helfende die Lieferung vor der Wohnungstür abstellt und sich zwei Meter von ihr entfernt. Daraufhin wird die Lieferung von Ihnen entgegengenommen und der Helfende geht wieder.</div>
        <br>
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
        <div class="subtitle">Bezahlung</div>
        <div class="text">Bestenfalls bedeutet dies auch, dass Sie online bezahlen. Falls Sie Bar bezahlen möchten, legen Sie bitte das Geld auf die Fussmatte und entfernen sich ebenfalls, damit der Helfende das Geld aufnehmen kann.</div>
        <br>
        <div class="text">Die Ansteckungswege sind noch nicht sicher geklärt und die Ansteckung über Flächen nicht ausgeschlossen. Wir empfehlen in jedem Fall die Hände zu waschen bevor und nachdem man mit der Ware oder dem desinfizierten Bargeld in Berührung kommt.</div>
        <br>
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
        <div class="text">Nun ist die Mission abgeschlossen - bis zum nächsten Mal!</div>
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