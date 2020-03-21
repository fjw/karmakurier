<template>
    <div class="questions-wrapper normalize-width">
        <div class="title">FAQ</div>

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
import faker from "faker";

export default {
    name: "KkQuestions",
    components: { KkQuestion },
    data() {
        // Generate 5 random questions.
        const questions = [...Array(5).keys()].map(id => ({
            id: id + 1,
            title: faker.lorem.sentence(),
            text: faker.lorem.paragraphs(2)
        }));

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
