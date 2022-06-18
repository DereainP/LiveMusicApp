import axios from 'axios';

//  const http = axios.create({
//    baseURL: "http://localhost:8080/"
//  });

export default {
  list() {
    return axios.get('http://localhost:8080/api/allEvents');
  },

  get(event_id) {
    return axios.get(`http://localhost:8080/api/event/${event_id}`);
  },


  create(event) {
    return axios.post('http://localhost:8080/api/saveEvent', event);
  },

  update(event) {
    return axios.put(`http://localhost:8080/api/editEvent/${event}`, event);
  },

  delete(event_id) {
    return axios.delete(`http://localhost:8080/api/removeEvent/${event_id}`);
  }
}
