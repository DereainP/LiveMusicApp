<template>
  <div id="main">
    This is the event you selected. <br />

    Name: {{ event.event_name }} <br />
    

    

    <img v-bind:src="event.event_img" alt="random doggo" width="200" />
    <br>
    <button id="update-btn" v-on:click="updateEvent">Update Data?</button>
  </div>
</template>


<script>
import EventService from "../services/EventService";

export default {
  props: {
    event_id: Number,
  },
  data() {
    return {
      event: {},
    };
  },
  created() {
    console.log(this.$route.params.id);
    EventService.get(this.$route.params.id).then((eventData) => {
      this.event = eventData.data;
    });
  },
  methods: {
    updateEvent() {
      const newEvent = {
        event_id: this.$route.params.event_id,
        event_name: this.event.event_name,
        event_genre: this.event.genre,
        start_time: this.event.start_time,
        event_date: this.event.event_date,
        min_age: this.event.min_age,
        event_img: this.event.event_img,
        venue_name:this.event.venue_name,
        website: this.event.website
      };
      EventService
        .update(newEvent)
        .then((response) => {
          if (response.status === 200) {
            alert("event updated!");
            this.$router.push("/display");
          }
        })
        .catch((err) => {
          console.error(err + " problem updating event!");
        });
    },
  },
};
</script>
<style>

</style>