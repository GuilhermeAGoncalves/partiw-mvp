import { Company } from "../company/types";

export interface LoginResponse {
  userId: number;
  name: string;
  email: string;
  company: Company;
}
