import { Component, OnInit } from '@angular/core';
import {DocumentService} from "../../../shared/services/document.service";

@Component({
  selector: 'app-documents',
  templateUrl: './documents.component.html',
  styleUrls: ['./documents.component.css']
})
export class DocumentsComponent implements OnInit {
  allDocuments: any;
  constructor(private documentService: DocumentService) { }

  ngOnInit() {
    this.documentService.getAllDocument().subscribe(data => {
      this.allDocuments = data;
    });
  }

}
