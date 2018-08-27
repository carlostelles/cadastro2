import {Injectable} from '@angular/core';
import {ApiService} from '../api/api.service';
import {Pessoa} from './pessoa.model';

@Injectable()
export class PessoaService {
  private data: Array<Pessoa> = [];
  private item: any = new Pessoa();

  constructor(private api: ApiService) {
  }

  getData(): Array<Pessoa> {
    return this.data;
  }

  getItem(): Pessoa {
    return this.item;
  }

  search(): Promise<Array<Pessoa>> {
    let promise: Promise<Array<Pessoa>>;

    promise = new Promise((resolve) => {
      this.api.get('pessoa')
        .toPromise()
        .then(
          res => { // Success
            this.data = Array.prototype.slice.call(res);
            resolve();
          }
        );
    });
    return promise;
  }

  get(id: number): Promise<Pessoa> {
    let promise: Promise<Pessoa>;

    promise = new Promise((resolve) => {
      this.api.get('pessoa/' + id)
        .toPromise()
        .then(
          res => {
            this.item = res;
            resolve();
          }
        );
    });
    return promise;
  }

  save(pessoa: object) {
    let promise: Promise<Pessoa>;

    promise = new Promise((resolve) => {
      if (pessoa['id']) {
        this.api.put('pessoa/' + pessoa['id'], pessoa)
          .toPromise()
          .then(
            res => {
              this.item = res;
              resolve();
            }
          );
      } else {
        this.api.post('pessoa', pessoa)
          .toPromise()
          .then(
            res => {
              this.item = res;
              resolve();
            }
          );
      }
    });
    return promise;
  }

  delete(id: string) {
    let promise: Promise<Pessoa>;

    promise = new Promise((resolve) => {
      this.api.delete('pessoa/' + id)
        .toPromise()
        .then(
          res => {
            resolve();
          }
        );
    });
    return promise;
  }
}
