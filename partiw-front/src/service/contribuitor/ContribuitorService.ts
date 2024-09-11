import axios from "axios";
import { Contribuitor, ContribuitorResponse } from "./types";

const API_URL = "https://54.152.151.234:8080/api";

export default {
  postCreate: async (
    companyId: any,
    categoryId: any,
    data: Contribuitor
  ): Promise<Contribuitor> => {
    const response = await axios.post(`${API_URL}/contribuitor`, {
      companyId,
      categoryId,
      ...data,
    });
    return response.data;
  },

  getAllContribuitors: async (): Promise<ContribuitorResponse[]> => {
    const response = await axios.get(
      `${API_URL}/contribuitor/company?companyId=${localStorage.getItem(
        "companyId"
      )}`
    );
    return response.data;
  },
};
