import { Pipe, PipeTransform } from '@angular/core';
import { CurrencyPipe } from '@angular/common';

@Pipe({
  name: 'currencyformat'
})
export class CurrencyFormatPipe implements PipeTransform {

  transform(value: number, currencyCode: string = 'BRL', symbolDisplay: boolean = true, digits?: string): string {
    if (!value) {
      return '';
    }

    const currencyPipe: CurrencyPipe = new CurrencyPipe('pt-BR');
    return currencyPipe.transform(value, currencyCode, symbolDisplay, digits);
  }

}
