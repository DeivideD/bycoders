
import { useState } from "react"
import { ModalRepresentante } from "./modal/modalRepresentante";
import { ModalUpload } from "./modal/modalUpload";


export function Header() {
  let subtitle: HTMLHeadingElement;
  const [modalUploadIsOpen, setUploadIsOpen] = useState(false);
  const [modalRepresentanteIsOpen, setRepresentanteIsOpen] = useState(false);

  function hadleOpenUploadModal() {
    setUploadIsOpen(true);
  }

  function hadleCloseUploadModal() {
    setUploadIsOpen(false);
  }

  function hadleOpenRepresentanteModal() {
    setRepresentanteIsOpen(true);
  }

  function hadleCloseRepresentanteModal() {
    setRepresentanteIsOpen(false);
  }

  return (
    <div className="header">
      <div className="header-content">
         <button type="button" className="" onClick={hadleOpenUploadModal}>Importar CNAB</button>
         <button type="button" className="" onClick={hadleOpenRepresentanteModal}>Representantes</button>
         <button type="button" className="">Logout</button>
      </div>
        <ModalUpload isOpen={modalUploadIsOpen} handleClose={hadleCloseUploadModal}/>
        <ModalRepresentante isOpen={modalRepresentanteIsOpen} handleClose={hadleCloseRepresentanteModal}/>
    </div>
  );
}