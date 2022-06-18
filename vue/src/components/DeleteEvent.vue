    <template>
  <div id="main">
    <div class="header"> <img src='https://live.staticflickr.com/65535/52054449681_7c652be7a9_c.jpg'/></div>
    <h1>Delete an Event</h1>
    <div class="grid">
      <div class="box" v-for="event in events" :key="event.event_id">
      
      <article> 
          <img class="eventImg" v-bind:src=event.event_img alt="event image" width="200" >
       <h3 class="text" > Event: {{ event.event_name }}</h3>
          <p class="text"> ID: {{event.event_id}}</p>
         
        <p class="text" id="delete" ><input
          type="checkbox"
          v-bind:event_id="event.event_id"
          v-on:change="deleteEvent($event)"
        />
        Delete Event?</p>
       </article>
        
      </div>
    </div>
  </div>
</template>

<script>

import EventService from "@/services/EventService";
export default {
  data() {
    return { events: [], eventToDelete: {} };
  },
  methods: {
    deleteEvent(ev) {
      if (
        confirm(
          "Are you sure you want to delete this event?  This action cannot be undone."
        )
      ) {
        if (ev.target.checked) {
          this.eventToDelete = {
            event_id: ev.target.event_id,
          };
          EventService
          .delete(this.eventToDelete.event_id)
          .then(response => {
              if (response.status === 200){
                  alert("Event was deleted!");
                  this.$router.push("/home");
              }
              window.location.reload();
          })
          .catch (error => {
            if (error.response) {
              this.errorMsg =
                "Error deleting event. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Server could not be reached.";
            } else {
              this.errorMsg =
                "Request could not be created.";
            }  
          });
        } else {
          this.oneToConvert = {};
        }
      }
    },
  },
  created() {
    EventService
      .list()
      .then((eventData) => {
        this.events = eventData.data;
      })
      .catch((err) => {
        console.error(err + " uh oh missing event!");
      });
  },
};
</script>
<style>
h1{ 
  color:white;
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

#delete{
  font-weight: bold;
}
img{
  margin-top: 1px;
  width: 100%;
}
#main{
  background-color:black;
}
</style>