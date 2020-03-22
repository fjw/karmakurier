<template>
    <div class="questions-wrapper normalize-width">
        <div class="title">FAQ</div>
        <br>
        <div class="subtitle">Willkommen im Hilfebereich von karmakurier. Sie möchten mehr zu karmakurier erfahren, haben eine Frage oder ein konkretes Problem? Hier liefern wir Ihnen Antworten auf die wichtigsten Fragen und hoffen, dass Ihre auch dabei ist. Ihre Frage war nicht dabei? Dann schreiben Sie uns uns eine E-Mail, wir freuen uns über Ihre Kontaktaufnahme: info@karmakurier.org</div>
        <kk-question
            class
            v-for="question in questions"
            :key="question.id"
            :id="question.id"
            :title="question.title"
            :text="question.text"
        ></kk-question>
    </div>
</template>

<script>
import KkQuestion from "@/components/molecules/KkQuestion";

export default {
    name: "KkQuestions",
    components: { KkQuestion },
    data() {
        // Generate 5 random questions.
        const questions = [
        {
            id: 1,
            title: "Wie Funktioniert karmakurier?",
            text: "karmakurier bringt Hilfesuchende und freiwillige Helfer aus Ihrer Umgebung schnell, unmittelbar und einfach zusammen. Hilfesuchende können Ihre Mission persönlich per Telefon unter +48 732100073 oder über eine nahestehende Person im Onlineformular einreichen. Freiwillige Helfer kümmern sich anschließend um Ihre Mission und erledigen diese. Nach erfolgreichem Abschluss der Mission erhält der Helfer hierfür seine verdiente Anerkennung in Form von Karmapunkten. Diese sind in Form von Gutscheinen oder von anrechenbaren ehrenamtlichen Stunden monetarisierbar. Zusätzlich ist es möglich die Karmapunkte in unseren Social Refund zu reinvestieren und somit die Kostenrückerstattung anderer Missionen abzusichern. Helfen Sie uns mit Ihren Punkten unsere Plattform besser zu machen."
        },
        {
            id: 3,
            title: "Was sind Karmapunkte?",
            text: "Karmapunkte sind ein einzigartiger Weg, um sich die Anerkennung des Helfers für jede gute Tat in Form einer erledigten Mission zu verdienen. Für diesen erhält der Helfer eine entsprechende Anzahl an Karmapunkten. Wofür kann ich meine Karmapunkte einlösen?"
        },
        {
            id: 4,
            title: "Wofür kann ich meine Karmapunkte einlösen?",
            text: "Ihre Karmapunkte können Sie bei unseren Karmapartnern in Form von Gutscheinen einlösen oder reinvestieren Sie Ihre Karmapunkte in die Verbesserung unserer Plattform in den Social Fund. Eine genaue Übersicht dieser können Sie Ihrer Profilübersicht entnehmen. Wie kann ich sehen, wie viele Karmapunkte ich habe? Sie können die Anzahl Ihrer gesammelten Karmapunkte in Ihrem Profil einsehen."
        },
        {
            id: 5,
            title: "Wann habe ich ein Profil auf karmakurier?",
            text: "Sobald sie bei karmakurier als Helfer registriert und eingeloggt sind, können Sie Ihr Profil mit allen hinterlegten Eingaben (Adresse, Kontakt, etc.) und der Übersicht Ihres Karmapunktestandes einsehen."
        },
        {
            id: 6,
            title: "Wie kann ich Helfer werden und andere unterstützen?",
            text: "Der  Social Fund dient zur Absicherung der Kostenrückerstattung. Der Social Fund wird mit Hilfe von 'Corporate Social Responsiblity Sponsoring' und einem Community-Risiko-Beitrag je Einkauf abgesichert."
        },
        { 
            id: 2,
            title: "Ich möchte gerne helfen.",
            text: "Auf karmakurier können Sie in nur wenigen Klicks einfach und schnell Helfer werden. Bitte registrieren Sie sich hierfür direkt auf unserer Seite. Im hinterlegten Formular geben Sie alle relevanten Daten ein und sind nach abschließender Bestätigung direkt als Helfer registriert. Ich brauche Hilfe. Wie kann ich Hilfe von karmakurier bekommen und eine Mission aufgeben? Wenn Sie Hilfe benötigen können Sie diese auf zwei unterschiedlichen Wegen bei karmakurier erhalten. Zum Einen können Sie Ihre Mission persönlich per Telefon einreichen. Zum Anderen können Sie Ihr Hilfegesuch online selbst oder von einer Ihnen nahestehenden Person aufgeben lassen. Hier erreichen Sie unser Onlineformular www.karmakurier.org. Nach Übermittlung der persönlichen Daten sowie der Einzelheiten zu Ihrer Mission, werden SIe von Ihrem persönlichen Helfer kontaktiert, um das weitere Vorgehen zu besprechen."
        }]

        return {
            questions: questions
        };
    }
};
</script>

<style lang="scss" scoped>
@import "@/components/Branding.scss";

.questions-wrapper {
    // padding: 40px 16px 64px 16px;
}
</style>
