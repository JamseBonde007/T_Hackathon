import { Publisher } from './publisher.model';

export interface Job {
  id: number;
  name: string;
  description: string;
  jobType: string;
  companyContactPerson: Publisher;
}
