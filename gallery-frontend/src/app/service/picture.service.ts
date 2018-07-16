import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {PictureInfo} from "../model/picture-info.model";
import {Observable} from "rxjs/index";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class PictureService {
  constructor(private http: HttpClient) {

  }

  getPictures(page: number, size: number): Observable<PictureInfo[]> {
    let url: string = `${environment.restUrl}/rest/pictures?page=${page}&size=${size}`;
    return this.http.get<PictureInfo[]>(url);
  }

}
