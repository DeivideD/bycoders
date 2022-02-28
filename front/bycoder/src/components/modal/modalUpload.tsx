
import { FormEvent, useState } from 'react';
import Modal from 'react-modal';
import { api } from '../../services/api';


const customStyles = {
  content: {
    top: '50%',
    left: '50%',
    right: 'auto',
    bottom: 'auto',
    marginRight: '-50%',
    transform: 'translate(-50%, -50%)',
  },
};

interface Props {
  isOpen: boolean;
  handleClose: () => void;
}


export function ModalUpload(props: Props){
  const [arquivo, setArquivo] = useState();

  function handleCreateMovimnetos(e: FormEvent){
     e.preventDefault()
     console.log(arquivo)

     const formData = new FormData();
     formData.append("arquivo", arquivo!);

     api.post("/arquivos/carregar", formData );
     props.handleClose()
  }

  return(
    <div>
    <Modal
      isOpen={props.isOpen}
      ariaHideApp={false}
      onRequestClose={props.handleClose}
      style={customStyles}
      contentLabel="Example Modal"
    >
      <button className="close-modal"style={{float:"right"}} onClick={props.handleClose}>X</button>
      <div className="modal-title">Selecione um arquivo CNAB</div>
      
      <form onSubmit={handleCreateMovimnetos}>
      <input className="btn-modal-file" type="file" name="arquivo" onChange={ (e: any) => {setArquivo(  e.target.files[0] )}}/>
      <div className="div-btn">
        <button className="btn-modal enviar" type="submit">Enviar</button>
        <button className="btn-modal cancel" onClick={props.handleClose} >Cancelar</button>
        </div>
      </form>

    </Modal>
  </div>
  );
}

function defaultConfig(arg0: string, arquivo: undefined, defaultConfig: any) {
  throw new Error('Function not implemented.');
}
