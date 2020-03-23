import { IUser } from '@/shared/model/user.model';

export const enum PriceCategory {
  PREMIUM = 'PREMIUM',
  CHEAP = 'CHEAP'
}

export const enum PaymentMethod {
  PAYPAL = 'PAYPAL',
  CASH = 'CASH'
}

export interface IMission {
  id?: number;
  firstName?: string;
  lastName?: string;
  street?: string;
  zip?: string;
  city?: string;
  email?: string;
  phoneNumber?: string;
  order?: any;
  priceCategory?: PriceCategory;
  maxPrice?: number;
  paymentMethod?: PaymentMethod;
  assignedHelper?: IUser;
}

export class Mission implements IMission {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public street?: string,
    public zip?: string,
    public city?: string,
    public email?: string,
    public phoneNumber?: string,
    public order?: any,
    public priceCategory?: PriceCategory,
    public maxPrice?: number,
    public paymentMethod?: PaymentMethod,
    public assignedHelper?: IUser
  ) {}
}
