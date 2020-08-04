<template>
    <div class="home">
        hello
    </div>
</template>

<script>
// @ is an alias to /src
import axios from "axios";

export default {
    name: "Home",
    components: {

    },
    mounted() {
        axios.get("/api/hello").then(res => console.log(res));
    }
};
</script>
