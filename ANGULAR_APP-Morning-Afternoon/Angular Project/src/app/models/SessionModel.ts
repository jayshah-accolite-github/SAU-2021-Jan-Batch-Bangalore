export class SessionModel{
    sessionName!: string;
    details!:boolean;
    trainer!:string;
    date!:Date;
    constructor(sessionName:string,trainer:string,date:Date)
    {
        this.sessionName=sessionName;
        this.trainer=trainer;
        this.details=false;
        this.date=date;
    }
}