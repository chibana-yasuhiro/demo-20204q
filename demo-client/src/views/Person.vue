<template>
  <div id="app">
    <h1>社員一覧</h1>
    <div align="center">
    <table>
    <tr v-for="item in people" v-bind:key="item"><td>{{item.id}}:{{item.name}}</td></tr>
    </table>
    </div>
  </div>
</template>


<script>
import axios from 'axios'
export default {
  data () {
    return {
      people: [],
    }
  },
  methods: {
    getNews () {
      const path = 'http://localhost:8080/api/person'
      axios.get(path)
        .then(response => {
          this.people = response.data
        })
        .catch(error => {
          console.log(error)
        })
    }
  },
  created () {
    this.getNews()
  }
}
</script>


/script>