import {Injectable} from '@angular/core';
import {ApiService} from './api.service';

@Injectable()
export class UtilsService {
  riscoData: Array<any>;

  constructor(private api: ApiService) {
  }

  getRiscoData(): Array<any> {
    return this.riscoData;
  }

  getRisco(): Promise<Array<any>> {
    let promise: Promise<Array<any>>;

    promise = new Promise((resolve) => {
      this.api.get('utils/risco')
        .toPromise()
        .then(
          res => { // Success
            this.riscoData = [];
            this.riscoData = Array.prototype.slice.call(res);
            resolve();
          }
        );
    });
    return promise;
  }
}
