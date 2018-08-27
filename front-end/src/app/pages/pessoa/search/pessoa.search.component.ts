import {Component} from '@angular/core';
import {PessoaService} from '../../../shared/pessoa/pessoa.service';
import {Pessoa} from '../../../shared/pessoa/pessoa.model';
import {Router} from '@angular/router';
import {AuthService} from '../../../shared/auth/auth.service';

@Component({
    selector: 'app-search-cadastro',
    templateUrl: './pessoa.search.component.html'
})
export class PessoaSearchComponent {

  pessoas: Array<Pessoa> = [];

  constructor(private router: Router,
              private authService: AuthService,
              private service: PessoaService) {
    this.search();
  }

  search() {
    this.service.search().then(value => {
      this.pessoas = this.service.getData();
    });
  }

  trash(id: string) {
    if (confirm('Confirma exclusão?')) {
      this.service.delete(id).then(value => {
        this.search();
      });
    }
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['login']);
  }
}
