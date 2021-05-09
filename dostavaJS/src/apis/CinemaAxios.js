import axios from 'axios';
import {logout} from "../services/auth"

var CinemaAxios = axios.create({
  baseURL: 'http://localhost:8080/api',
  /* other custom settings */
});

CinemaAxios.interceptors.request.use(
  function success(config){
    const jwt = window.localStorage['jwt'];
    if(jwt){
      config.headers['Authorization'] = 'Bearer ' + jwt;
    }
    return config;
  }
);

CinemaAxios.interceptors.response.use(
  function success(response){
      return response;
  },
  function failure(error){
    let jwt = window.localStorage['jwt'];
    if(jwt){
      if(error.response && error.response.status == 403){
        logout();
      }
    }
    
    throw error;
  }
);

export default CinemaAxios;