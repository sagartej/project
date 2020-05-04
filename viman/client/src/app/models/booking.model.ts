import { Flight } from './flight.model';
import { User } from './user.model';

export class Booking{
    bookingId:number;
    fname:String;
    lname:String;
    dob:String
    flight:Flight;
    user:User;
}