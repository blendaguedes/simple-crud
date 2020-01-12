import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class Translator {
  constructor(
    public id: string,
    public firstName: string,
    public lastName: string,
    public email: string,
    public sourceLanguage: string,
    public targetLanguage: string
  ) {
  }
}

export class Paginator<T> {
  constructor(
    public sizeList: bigint,
    public pageSize: bigint,
    public previousPage: bigint,
    public currentPage: bigint,
    public nextPage: bigint,
    public list: Array<T>,
  ) {
  }
}

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {
  constructor(private httpClient: HttpClient) {

  }

  getTranslator(paginator: Paginator<Translator>) {
      return this.httpClient.get<Paginator<Translator[]>>('http://localhost:8080/translator');
  }

  getTranslatorNextPage(paginator: Paginator<Translator>) {
      return this.httpClient.get<Paginator<Translator[]>>('http://localhost:8080/translator?pageSize=' +
        paginator.pageSize + '&pageNo=' + paginator.nextPage);
  }

  getTranslatorPreviousPage(paginator: Paginator<Translator>) {
    return this.httpClient.get<Paginator<Translator[]>>('http://localhost:8080/translator?pageSize=' +
      paginator.pageSize + '&pageNo=' + paginator.previousPage);
  }

  getPage(paginator: Paginator<Translator>) {
    return this.httpClient.get<Paginator<Translator[]>>('http://localhost:8080/translator?pageSize=' +
      paginator.pageSize + '&pageNo=' + paginator.currentPage);
  }

  public deleteTranslator(translator) {
    return this.httpClient.delete<Translator>('http://localhost:8080/translator' + '/' + translator.id);
  }

  public createTranslator(translator) {
    return this.httpClient.post<Translator>('http://localhost:8080/translator', translator);
  }

  public updateTranslator(translator) {
    return this.httpClient.patch<Translator>('http://localhost:8080/translator' + '/' + translator.id, translator);
  }

  public searchTranslatorByEmail(translator) {
    return this.httpClient.get<Translator[]>('http://localhost:8080/translator/searchBy?search=(email:"' + translator.email + '")');
  }
}


