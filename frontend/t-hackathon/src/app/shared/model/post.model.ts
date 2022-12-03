import { Publisher } from './publisher.model';

export interface Post {
  id: number;
  name: string;
  content: string;
  imageUrl: string;
  likes: number;
  createdDate: Date;
  visibility: Boolean;
  publisher: Publisher;
}
