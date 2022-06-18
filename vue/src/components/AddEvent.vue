<template>
  <div id="main">
    <div >
      
      <div >
        <div>
          <div class="right-pic">
          <form v-on:submit.prevent="saveEvent">
              
            <label for="name">Event:</label>
        <input  v-model="event.event_name" />
            <label for="genre">Genre:</label>
           <input  v-model="event.genre" />
           <label for="time">Time:</label>
          <input v-model="event.start_time" />
          <label for="date">Date:</label>
           <input v-model="event.event_date" />
          <label for="age">Min. Age:</label>
         <input v-model="event.min_age" />
          <label for="img">Image URL:</label>
         <input  v-model="event.event_img" />
          <label for="venue">Venue:</label>
        <input  v-model="event.venue_name" />
         <br/>
        
        
        <button id="product-add-btn">Add Event!</button>
          </form>
          </div>
        </div>
       
      </div>
    </div>
  </div>
</template>

<script>
import pupPicService from '@/services/PupPicService';
import EventService from '@/services/EventService';
export default {
  data() {
    return {
      event: {
        event_name: '',
        genre: '',
        start_time: '',
        event_date: '',
        min_age: '',
        event_img:'',
        venue_name:'',
        website:''
      },
    };
  },
  methods: {
    saveEvent() {
      console.log('saving event');
      pupPicService
        .list()
        .then((newImage) => {
          this.pupImage = newImage.data;
          console.log(this.pupImage);
          const newEvent = {
             event_name: this.event.event_name,
            genre: this.event.genre,
            start_time: this.event.start_time,
            event_date: this.event.event_date,
            min_age: this.event.min_age,
            event_img: this.event.event_img,
            venue_name: this.event.venue_name,
            website: this.event.website
          };
          EventService
            .create(newEvent)
            .then((response) => {
              if (response.status === 201) {
                alert('Event added!');
                this.$router.push('/home');
              }
                alert('Event added!');
                this.$router.push('/home');
            })
            .catch((err) => {
              console.error(err + 'Problem adding event!');
            });
        })
        .catch((err) => {
          console.error(err + ' No picture!');
        });
    },
  },
};
</script >

<style scoped>
#main{
  background-color: black;
  display: grid;
 
}


form{
  display: grid;
  margin: 2em 0;
  padding: 1em 2em;
  border: solid 1px #ccc;
  border-radius: 6px;
  width: 30%;
  color: white;
  align-items: center;
  justify-content: center;
}
legend{
  font-size: 1.25em;
  padding: 0 .25em;
  color: #999;
}
.right-pic{
  background-image: url(https://images.pexels.com/photos/1820770/pexels-photo-1820770.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2);
  height: 100vh;
  width: 100%;
  margin-top: -30px;
}
</style>