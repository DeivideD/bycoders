
import { useState } from "react"
import { ModalRepresentante } from "./modal/modalRepresentante";
import { ModalUpload } from "./modal/modalUpload";


export function Header() {
 

  return (
    <div className="header">
      <div className="header-content">
         <button type="button" className="btn-logout">Logout</button>
      </div>
    </div>
  );
}