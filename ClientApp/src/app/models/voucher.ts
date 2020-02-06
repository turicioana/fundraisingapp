import { Company } from './company';
import { Fundraiser } from './fundraiser';

export class Voucher{
    id: string;
    type: string;
    purpose: string;
    number: number;
    company: Company;
    fundraiser: Fundraiser;

    constructor(){
        this.company = new Company();
        this.fundraiser = new Fundraiser();
    }
}