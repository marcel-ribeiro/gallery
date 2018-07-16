export class PictureInfo {
  id: string;
  createdAt: string;
  name: string;
  imageUrl: string;

  constructor(id: string = "", createdAt: string = "", name: string = "", imageUrl: string = "") {
    this.id = id;
    this.createdAt = createdAt;
    this.name = name;
    this.imageUrl = imageUrl;
  }
}
