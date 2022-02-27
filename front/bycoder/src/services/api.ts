import axios, { AxiosRequestConfig } from "axios";


function defaultConfig(): AxiosRequestConfig {
  return {
    headers: {
      "Content-Type": "",
    },
  };
}
export const api = axios.create({
  baseURL: 'http://localhost:8080',
  timeout: 5000,
})