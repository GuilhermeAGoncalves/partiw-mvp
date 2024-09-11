import { Category } from "../category/types";

export interface Contribuitor {
  name: string;
  cpf: string;
  email: string;
  phoneNumber: string;
  dtVacation: String;
  dtAdmission: String;
  role: String;
  hired: boolean;
  dtBirth: String;
}

export interface ContribuitorResponse {
  name: string;
  cpf: string;
  email: string;
  phoneNumber: string;
  dtVacation: String;
  dtAdmission: String;
  role: String;
  hired: boolean;
  dtBirth: String;
  category: Category;
}
