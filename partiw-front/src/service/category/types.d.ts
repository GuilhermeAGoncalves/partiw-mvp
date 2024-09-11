import { Company } from "../company/types";

export interface Category {
  categoryId: string;
  name: string;
  description: string;
  valueMax: number;
  coParticipation: number;
  company: Company;
}
