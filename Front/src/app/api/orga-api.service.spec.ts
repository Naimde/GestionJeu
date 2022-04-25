import { TestBed } from '@angular/core/testing';

import { OrgaApiService } from './orga-api.service';

describe('OrgaApiService', () => {
  let service: OrgaApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrgaApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
