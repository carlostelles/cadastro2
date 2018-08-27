import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {PessoaService} from '../../../shared/pessoa/pessoa.service';
import {Pessoa} from '../../../shared/pessoa/pessoa.model';
import {UtilsService} from '../../../shared/api/utils.service';

function _window(): any {
  return window;
}

@Component({
    selector: 'app-form-cadastro',
    templateUrl: './pessoa.detail.component.html'
})
export class PessoaDetailComponent implements OnInit {

  @ViewChild('f') form: NgForm;

  disabledEdit: boolean;
  pessoa: Pessoa;
  riscos: Array<any> = [];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private pessoaService: PessoaService,
              private utilService: UtilsService) {
  }

  back(): void {
    _window().history.back();
  }

  get(id: number): void {
    this.pessoaService.get(id).then(value => {
      this.pessoa = this.pessoaService.getItem();
    });
  }

  onSubmit(): void {
    const form: object = this.form.form.value;

    this.pessoaService.save(form).then(value => {
      this.router.navigate(['pessoas/pesquisar']);
    });
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');

    if (id) {
      this.get(Number.parseInt(id));
      this.disabledEdit = this.route.snapshot.url[this.route.snapshot.url.length - 1].path === 'detalhe';
    } else {
      this.pessoa = new Pessoa();
    }

    if (!this.riscos.length) {
      this.utilService.getRisco().then(value => {
        this.riscos = this.utilService.getRiscoData();
      });
    }
  }
}
