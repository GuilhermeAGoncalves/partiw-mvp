import axios from "axios";
import { LoginResponse } from "./types";

const API_URL = "https://54.152.151.234:8080/api";

export default {
  login: async (email: String, password: String): Promise<LoginResponse> => {
    const response = await axios.post(`${API_URL}/api/users/login`, {
      email,
      password,
    });
    return response.data;
  },
};
