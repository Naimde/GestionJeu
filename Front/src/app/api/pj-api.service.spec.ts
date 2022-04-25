import { TestBed } from '@angular/core/testing';

import { PjApiService } from './pj-api.service';

describe('PjApiService', () => {
  let service: PjApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PjApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
