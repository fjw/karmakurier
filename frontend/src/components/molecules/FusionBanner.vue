<template>
    <div class="fusionbanner">

        <div>
            <img src="@/assets/karmakurier_coco.png">
        </div>
        <div>
            <p>Der soziale Mehrwert und der Wunsch, den von der Corona-Krise Betroffenen so schnell wie möglich<br>mit einer digitalen Lösung zu helfen, vereint die Teams hinter <b>karmakurier</b> und <b>COCO corona connect.</b></p>
            <p>Mit dieser Fusion vereinen wir die Technologien und Konzepte beider Projekte.</p>
            <p>Hier gehts zum <a href="https://devpost.com/software/corona-karma">devpost von karmakurier!</a></p>
            <p>Schauen Sie auch beim <a href="https://devpost.com/software/corona-connect">devpost von COCO corona connect</a> vorbei!</p>
        </div>

    </div>
</template>

<script>
    export default {
        name: "FusionBanner"
    };
</script>

<style lang="scss" scoped>

    .fusionbanner {

        font-size: 13px;
        display: flex;

        > div {
            margin: 20px;
        }

        img {
            width: 130px;
        }

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