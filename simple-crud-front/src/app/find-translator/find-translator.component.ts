import {Component, NgModule, OnInit, ViewChild} from '@angular/core';
import {HttpClientService, Paginator, Translator} from '../service/http-client.service';

@Component({
  selector: 'app-find-translator',
  templateUrl: './find-translator.component.html',
  styleUrls: ['./find-translator.component.css']
})

export class FindTranslatorComponent implements OnInit {
  // @ts-ignore
  private translator = new Translator();
  // @ts-ignore
  private paginator = new Paginator<Translator>();
  // @ts-ignore
  private translatorToSearch = new Translator();
  private incrementation = Array();

  constructor(private httpClientService: HttpClientService) {
    httpClientService.getTranslator(null).subscribe(data => {
    });
  }

  ngOnInit() {
    this.httpClientService.getTranslator(null).subscribe(
      response => this.handleSuccessfulResponse(response)
    );
  }

  handleSuccessfulResponse(response) {
    this.incrementation = Array();
    for (let i = 0; i < response.sizeList.valueOf() / response.pageSize.valueOf(); i++) {
      this.incrementation.push(i);
    }
    this.paginator = response;
  }
  deleteTranslator(translator: Translator): void {
    this.httpClientService.deleteTranslator(translator)
      .subscribe(data => {
        this.paginator.list = this.paginator.list.filter(u => u !== translator);
      });
  }

  createTranslator(): void {
    this.httpClientService.createTranslator(this.translator)
      .subscribe(data => {
        this.paginator.list.push(data);
        alert('Translator created successfully."');
      });
  }

  updateTranslator(): void {
    this.httpClientService.updateTranslator(this.translator)
      .subscribe(data => {
        alert('Translator update successfully."');
      });
  }

  edit(translator: Translator): void {
    this.translator = translator;
  }

  getTranslatorPreviousPage(): void {
    if (this.paginator.previousPage == null) {
      alert('There\'s no previous page');
    } else {
      this.httpClientService.getTranslatorPreviousPage(this.paginator).subscribe(data => {
        this.handleSuccessfulResponse(data);
      });
    }
  }

  getSpecificPage(i: BigInteger): void {
      this.paginator.currentPage = i;
      this.httpClientService.getPage(this.paginator).subscribe(data => {
        this.handleSuccessfulResponse(data);
      });

  }

  getTranslatorNextPage(): void {
    if (this.paginator.nextPage == null) {
      alert('There\'s no next page');
    } else {
      this.httpClientService.getTranslatorNextPage(this.paginator).subscribe(data => {
        this.handleSuccessfulResponse(data);
      });
    }
  }

  getTranslatorByEmail(): void {
    this.httpClientService.searchTranslatorByEmail(this.translatorToSearch).subscribe( data => {
        this.paginator.list = data;
      }
    );
  }

}
