import '../../stylesheets/ShipLabel/shipmentLabel.css'
import logo from '../../images/logo.png'
import barcode from '../../images/barcode.jpg'
import { Component } from 'react'
import { PDFExport, savePDF } from '@progress/kendo-react-pdf';

var nadawcaImie = "Jakub"
var nadawcaNazwisko = "Wojtas"
var nadawcaUlica = "Zielona 9e"
var nadawcaMiejscowosc = "Tarnow"
var nadawcaKod = "94-234"

var odbiorcaImie = "Wojciech"
var odbiorcaNazwisko = "Jacoszek"
var odbiorcaUlica = "Jasminowa 14"
var odbiorcaMiejscowosc = "Jelesnia"
var odbiorcaKod = "34-340"

var indentyfikator = "3548029341032450923239"
var typ = "Delly Expres"
var regionKurierski = "J3A";
var mikrorejon = "A";
var stacjaDoreczajaca = "BBA";
var terminWaznosci = "2022-12-03"
var kodreferencyjny = "99828342343842034"

var ubezpieczenie = true;
var pobranie = false;
var odbiorKuriera = true;

class ShipLabel extends Component{
    render(){
       return (
        <div className="App" ref={this.props.carRef}>
          <header className="App-header">
            <div className="s">
            <table class="main-table"  border="1" width="1500" height="500">
              <tr>
                <td height="350" width="400">
                  <table class="table" height="350" width="400" cellSpacing="0">
                       <tr>
                         <td class="cell-vertical" height="80"><img class="logo" src={logo} alt=""/></td>
                       </tr>
                       <tr>
                         <td class="cell-vertical" height="30">Numer Przesylki</td>
                       </tr>
                       <tr>
                         <td class="cell-vertical cell-text-top-left" height="120">
                             Odbiorca:
                             <div style={{textAlign: 'right'}}>{odbiorcaImie} {odbiorcaNazwisko}<br/>{odbiorcaUlica}<br/><b>{odbiorcaMiejscowosc} {odbiorcaKod}</b></div>
                           </td>
                       </tr>
                       <tr>
                         <td class="cell-text-top-left" height="120">
                           Nadawca:
                           <div style={{textAlign: 'right'}}>{nadawcaImie} {nadawcaNazwisko}<br/>{nadawcaUlica}<br/><b>{nadawcaMiejscowosc} {nadawcaKod}</b></div>
                           </td>
                       </tr>
                   </table>
                </td>
                <td height="350" width="550">
                  <table class="table" width="550" height="350">
                     <tr>
                       <td class="cell-vertical" height="150"><img class="barcode" src={barcode} alt=""/></td>
                     </tr>
                     <tr>
                       <td class="cell-vertical" height="40">
                         <div style={{fontSize: '21px'}}><b>{indentyfikator}</b></div>
                       </td>
                     </tr>
                     <tr>
                     <td  class="cell-vertical cell-text-top-left" height="100">KRK16N<br/>Krowoderska 28<br/>30-554 Krak??w</td>
                     </tr>
                     <tr>
                     <td height="60">
                         <div style={{fontSize: '30px'}}>
                         <strong>{typ}</strong>
                         </div>
                       </td>
                     </tr>
                  </table>
                </td>
                <td width="550" rowSpan="2">
                   <table class="table" width="550" height="500">
                     <tr>
                       <td class="cell-vertical" width="550" height="100">
                          <table class="table" width="550" height="100">
                             <tr> 
                               <td class="cell-horicontal cell-text-top-auto">
                                 Rejon Kurierski<br/>
                                 <b style={{fontSize: '37px'}}>{regionKurierski}</b>
                                </td>
                               <td class="cell-horicontal cell-text-top-auto">
                                 Mikrorejon<br/>
                                 <b style={{fontSize: '37px'}}>{mikrorejon}</b>
                                </td>
                               <td class="cell-text-top-auto">
                                 Stacja dor??czaj??ca<br/>
                                 <b style={{fontSize: '37px'}}>{stacjaDoreczajaca}</b>
                                </td>
                             </tr>
                          </table>
                       </td>
                     </tr>
                     <tr>
                       <td width="550" height="200">
                         <table class="table" width="550">
                           <tr>
                             <td class="cell-vertical" height="50">
                               Termin wa??no??ci etykiety: {terminWaznosci}
                             </td>
                           </tr>
                           <tr>
                             <td class="cell-vertical" height="150">
                               <div style={{fontSize: '23px'}}>Kliencie<br/>utw??rz zlecenie<br/>odbioru paczek</div>
                               </td>
                           </tr>
                         </table>
                       </td>
                     </tr>
                     <tr>
                       <td width="550" height="200">
                          <table class="table" width="550" height="200">
                            <tr>
                              <td class="cell-vertical" colSpan="2" width="550" height="50">
                                Kod referencyjny: {kodreferencyjny}
                              </td>
                            </tr>
                            <tr>
                              <td width="50" class="block-cell">{ubezpieczenie ? <>X</> : <></>}</td>
                              <td class="cell-vertical" height="50">Ubezpieczenie</td>
                            </tr>
                            <tr>
                             <td  width="50" class="block-cell">{pobranie ? <>X</> : <></>}</td>
                              <td class="cell-vertical" height="50">Pobranie</td>
                            </tr>
                            <tr>
                              <td width="50" class="block-cell">{odbiorKuriera ? <>X</> : <></>}</td>
                              <td height="50">Odbi??r przez kuriera</td>
                            </tr>
                          </table>
                       </td>
                     </tr>
                   </table>
                </td>
              </tr>
              <tr>
                <td height="150" colSpan="2">
                  <table class="table" height="150" width="960">
                    <tr>
                      <td class="cell-vertical" height="100">Informacje o najbli??szych punktach</td>
                    </tr>
                    <tr>
                      <td height="50">Administratorem danych osobowych jest Delly Sp. z. o. o. z siedzib?? ul. Krowoderska 28 30-554 Krak??w</td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            </div>
          </header>
        </div>
       );
    }
  }
    export default ShipLabel;