<template>
  <div id="app">
    <div id="nav">
      <li>
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      </li>

     

      <li>
        <router-link
          v-bind:to="{ name: 'login' }"
          v-if="$store.state.token == ''"
          >Login</router-link
        >
      </li>
      <li>
        <router-link
          v-bind:to="{ name: 'register' }"
          v-if="$store.state.token == ''"
          >Register</router-link
        >
      </li>
     


      <li>
        <router-link
          v-bind:to="{ name: 'add' }"
          v-if="$store.state.token != ''"
          >Add Event</router-link
        >
      </li>
     <li>
        <router-link v-bind:to="{ name: 'delete' }"
        v-if="$store.state.token != ''">Delete Event</router-link>
        </li>
       <li>
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          >Logout</router-link
        >
      </li>
      <router-view />
    </div>
  </div>
</template>

<style>
#nav {
  padding: 0;
  background: black;
  height: 6vh;
}

li {
  display: inline-block;
}

a {
  display: block;
  padding: 10px;
  font-family: Times, sans-serif;
  font-size: 14px;
  text-transform: uppercase;
  color: white;
}
</style>


<style scoped>
#nav {
  padding: 0;
  background: black;
  height: 6vh;
}

li {
  display: inline-block;
}

a {
  display: block;
  padding: 10px;
  font-family: Times, sans-serif;
  font-size: 19px;
  text-transform: uppercase;
  color: white;
}
#id{
  background-color: black;
}
</style>

