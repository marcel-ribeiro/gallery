import {Component, OnInit} from '@angular/core';
import {PictureInfo} from "./model/picture-info.model";
import {PictureService} from "./service/picture.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title: string;
  pictures: PictureInfo[];
  page: number;
  size: number;
  isThereMore: boolean;

  constructor(private pictureService: PictureService) {

  }

  ngOnInit(): void {
    this.title = 'Picture Gallery App!';
    this.isThereMore = true;
    this.page = 0;
    this.size = 5;
    this.pictures = [];
    this.displayMore();
  }

  setPictures(): void {
    this.pictureService.getPictures(this.page, this.size).subscribe((pictures: PictureInfo[]) => {
      this.pictures.push(...pictures);
    });
  }

  displayMore(): void {
    this.page++;
    this.setPictures();
  }
}
