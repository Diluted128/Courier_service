import ShipLabel from './shipmentLabel'
import { PDFExport, savePDF } from '@progress/kendo-react-pdf';
import { useRef } from 'react';

function PDF(){

  const PDFExportComponent = useRef(null);

  const generatePDF = (event) => {
    PDFExportComponent.current.save();
  };

  return (
    <>
    <div>
    <PDFExport ref={PDFExportComponent} paperSize="A4" scale={0.35}>
        <ShipLabel/>
    </PDFExport>
      <button onClick={generatePDF}>Generate PDF</button>
    </div>
    </>
  );
}

export default PDF;
