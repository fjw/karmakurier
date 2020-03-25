<template>
    <div class="fusionbanner">

        <p><b class="karma">karmakurier</b> und <b class="coco">COCO corona connect.</b><br><b>füreinander. miteinander. gemeinsam stark</b></p>

        <p>Der soziale Mehrwert und der Wunsch, den von der Corona-Krise Betroffenen so schnell wie möglich mit einer digitalen Lösung zu helfen, vereint die Teams hinter karmakurier und COCO corona connect.</p>
        <p>Mit dieser Fusion vereinen wir die Technologien und Konzepte beider Projekte.</p>
        <p>Hier gehts zum <a href="https://devpost.com/software/corona-karma">devpost von karmakurier!</a></p>
        <p>Schauen Sie auch beim <a href="https://devpost.com/software/corona-connect">devpost von COCO corona connect</a> vorbei!</p>

    </div>
</template>

<script>
    export default {
        name: "FusionBanner"
    };
</script>

<style lang="scss" scoped>

    .fusionbanner {

        max-width: 512px;
        font-size: 13px;

        padding: 10px;
        border: 2px solid #ccc;
        border-radius: 2px;
        background: #fafafa;

        p {
            margin: 5px;

           b {
               font-weight: bold;

               &.karma {
                   color: #2d3cb9;
               }
               &.coco {
                   color: #e73454;
               }
           }
        }
    }
</style>