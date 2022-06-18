<template>
<div id='main'>
      <div class="header">
      <img src='https://live.staticflickr.com/65535/52052393386_95cb9b90da_h.jpg' alt="vegas">
    </div>

  <h2 >Upcoming Events</h2>
<div  class="grid">
  
  <div  class="box" v-for="event in events" :key="event.event_id">
    
   <article>
    <img class="eventImg" v-bind:src=event.event_img alt="event image" width="200" >
    <div class="text">
      <h3 >{{event.event_name}}</h3>
      <p >Genre: {{event.genre}}</p>
      <p>When: {{event.start_time}}</p>
      <p>{{event.event_date }}</p>
      <p>Where: {{event.venue_name + ' ' +event.min_age}}</p>
      
      
      <button>More Info</button>
    </div>
  </article>
    </div>
 </div>
</div>
</template>

<script>
import eventService from "@/services/EventService";

export default {
  data() {
    return { allEvents: [], events: []};
  },

  created() {
    eventService.list().then((res) => {
        this.events = res.data;
      })
      .catch((err) => {
        console.error(err + " uh oh missing events!");
      });
  },
  
};
</script>


<style scoped>
#main{
  background-color: black;
}
.grid { 
  display: grid;
  /*flex-wrap: wrap;*/
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  grid-gap: 20px;
  align-items: stretch;
  }
 .box {
  border: 1px solid #ccc;
  box-shadow: 2px 2px 6px 0px  rgba(194, 189, 189, 0.3);
  background-color: white;
}

.text {
  padding: 0 20px 20px;
}
.text > button {
  background: gray;
  border: 0;
  color: white;
  padding: 10px;
  width: 100%;
  }
img{ 
  width: 99.99%
}


h2{ 
  color: white;
  margin-left: 40px;
}
 </style>