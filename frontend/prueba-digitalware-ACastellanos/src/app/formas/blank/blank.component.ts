import { Component, Injectable} from '@angular/core';
import { subirAnimation} from '../../animations/listanim.animations';


@Component({templateUrl: './blank.component.html',  animations: [subirAnimation]} )

@Injectable()
export class BlankComponent  {


}

