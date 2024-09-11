import axios from "axios";
import { Category } from "./types";

const API_URL = "https://54.152.151.234:8080/api";

export default {
  getAllByCompanyId: async (companyId: any): Promise<Array<Category>> => {
    const response = await axios.get(
      `${API_URL}/category/company?companyId=${companyId}`
    );
    return response.data;
  },
};
