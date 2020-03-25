<template>
    <div class="legal-wrapper normalize-width">
        <div class="title">Impressum</div>

        <h2>Angaben gem&auml;&szlig; &sect; 5 TMG</h2>
        <p>
            karmakurier
            <br />Bergstra&szlig;e 1
            <br />69120 Heidelberg
        </p>

        <p>
            Genossenschaftsregister: DUMMMY
            <br />Registergericht: DUMMY
        </p>

        <p>
            <strong>Vertreten durch:</strong>
            <br />Dr. Andreas Geburtig-Chiocchetti, Benjamin Wiedenbrüg, Andreas Olck, Jonas Morgner, Larisa Espejo, Nelson Javier Mejia
        </p>

        <h2>Kontakt</h2>
        <p>
            Telefon: +49 (0) 1717750791
            <br />Telefax: +49 (0) 123 44 55 99
            <br />E-Mail: info@karmakurier.de
        </p>

        <h2>Umsatzsteuer-ID</h2>
        <p>
            Umsatzsteuer-Identifikationsnummer gem&auml;&szlig; &sect; 27 a Umsatzsteuergesetz:
            <br />DUMMY
        </p>

        <h2>Gewerbeanmeldung</h2>
        <p>Die Gewerbeanmeldung nach &sect; 34c GewO wurde am 01.04.2020 durch Ordnungsamt DUMMY erteilt.</p>

        <h2>Verantwortlich f&uuml;r den Inhalt nach &sect; 55 Abs. 2 RStV</h2>
        <p>
            Dr. Anddreas Geburtig-Chiocchetti
            <br />Bergstra&szlig;e 1
            <br />69120 Heidelberg
        </p>

        <h2>EU-Streitschlichtung</h2>
        <p>
            Die Europ&auml;ische Kommission stellt eine Plattform zur Online-Streitbeilegung (OS) bereit:
            <a
                href="https://ec.europa.eu/consumers/odr"
                target="_blank"
                rel="noopener noreferrer"
            >https://ec.europa.eu/consumers/odr</a>.
            <br />Unsere E-Mail-Adresse finden Sie oben im Impressum.
        </p>

        <h2>Verbraucher&shy;streit&shy;beilegung/Universal&shy;schlichtungs&shy;stelle</h2>
        <p>Wir sind nicht bereit oder verpflichtet, an Streitbeilegungsverfahren vor einer Verbraucherschlichtungsstelle teilzunehmen.</p>

        <h3>Haftung f&uuml;r Inhalte</h3>
        <p>Als Diensteanbieter sind wir gem&auml;&szlig; &sect; 7 Abs.1 TMG f&uuml;r eigene Inhalte auf diesen Seiten nach den allgemeinen Gesetzen verantwortlich. Nach &sect;&sect; 8 bis 10 TMG sind wir als Diensteanbieter jedoch nicht verpflichtet, &uuml;bermittelte oder gespeicherte fremde Informationen zu &uuml;berwachen oder nach Umst&auml;nden zu forschen, die auf eine rechtswidrige T&auml;tigkeit hinweisen.</p>
        <p>Verpflichtungen zur Entfernung oder Sperrung der Nutzung von Informationen nach den allgemeinen Gesetzen bleiben hiervon unber&uuml;hrt. Eine diesbez&uuml;gliche Haftung ist jedoch erst ab dem Zeitpunkt der Kenntnis einer konkreten Rechtsverletzung m&ouml;glich. Bei Bekanntwerden von entsprechenden Rechtsverletzungen werden wir diese Inhalte umgehend entfernen.</p>
        <h3>Haftung f&uuml;r Links</h3>
        <p>Unser Angebot enth&auml;lt Links zu externen Websites Dritter, auf deren Inhalte wir keinen Einfluss haben. Deshalb k&ouml;nnen wir f&uuml;r diese fremden Inhalte auch keine Gew&auml;hr &uuml;bernehmen. F&uuml;r die Inhalte der verlinkten Seiten ist stets der jeweilige Anbieter oder Betreiber der Seiten verantwortlich. Die verlinkten Seiten wurden zum Zeitpunkt der Verlinkung auf m&ouml;gliche Rechtsverst&ouml;&szlig;e &uuml;berpr&uuml;ft. Rechtswidrige Inhalte waren zum Zeitpunkt der Verlinkung nicht erkennbar.</p>
        <p>Eine permanente inhaltliche Kontrolle der verlinkten Seiten ist jedoch ohne konkrete Anhaltspunkte einer Rechtsverletzung nicht zumutbar. Bei Bekanntwerden von Rechtsverletzungen werden wir derartige Links umgehend entfernen.</p>
        <h3>Urheberrecht</h3>
        <p>Die durch die Seitenbetreiber erstellten Inhalte und Werke auf diesen Seiten unterliegen dem deutschen Urheberrecht. Die Vervielf&auml;ltigung, Bearbeitung, Verbreitung und jede Art der Verwertung au&szlig;erhalb der Grenzen des Urheberrechtes bed&uuml;rfen der schriftlichen Zustimmung des jeweiligen Autors bzw. Erstellers. Downloads und Kopien dieser Seite sind nur f&uuml;r den privaten, nicht kommerziellen Gebrauch gestattet.</p>
        <p>Soweit die Inhalte auf dieser Seite nicht vom Betreiber erstellt wurden, werden die Urheberrechte Dritter beachtet. Insbesondere werden Inhalte Dritter als solche gekennzeichnet. Sollten Sie trotzdem auf eine Urheberrechtsverletzung aufmerksam werden, bitten wir um einen entsprechenden Hinweis. Bei Bekanntwerden von Rechtsverletzungen werden wir derartige Inhalte umgehend entfernen.</p>
    </div>
</template>

<script>
export default {
    methods: {}
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.legal-wrapper {
    display: flex;
    justify-content: center;
    align-items: left;
    flex-direction: column;
}

.title {
    // background-color: $primary;
    span {
        font-weight: 700;
        color: $blue;
    }
    padding: 16px 0;
}

h2 {
    color: $blue;
    font-weight: 700;
    font-size: 1.2rem;
    margin-top: 16px;
}

h3 {
    font-weight: 600;
    font-size: 1rem;
    margin-top: 16px;
}
</style>
