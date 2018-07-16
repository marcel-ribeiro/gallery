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

  constructor(private pictureService: PictureService) {

  }

  ngOnInit(): void {
    this.title = 'Picture Gallery App!';
    this.setPictures();
  }

  setPictures(): void {
    this.pictureService.getPictures().subscribe((pictures: PictureInfo[]) => {
      this.pictures = pictures;
    });
  }
}
