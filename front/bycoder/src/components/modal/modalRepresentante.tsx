
import { FormEvent, useState, useEffect } from 'react';
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

interface Representante{
  id: number;
  nome: string;
  cpf: string;
}

interface Lojas {
  id: number;
  nome: string;
  representante: Representante;
  endereco: string;
  cidade: string;
  estado: string;
  cnpj: string;
}

interface Props {
  isOpen: boolean;
  handleClose: () => void;
}

export function ModalRepresentante(props: Props){
  const [arquivo, setArquivo] = useState();
  const [representante, setRepresentante] = useState<Lojas[]>([]);

  useEffect(() => {
    api.get('/lojas')
      .then(response => setRepresentante(response.data))
  }, []);
  
  function handleCreateMovimnetos(e: FormEvent){
     e.preventDefault()
     console.log(arquivo)

     const formData = new FormData();
     formData.append("arquivo", arquivo!);
     api.post("/arquivos/carregar", formData );
  }

  return(
    <div>
    <Modal
      isOpen={props.isOpen}
      onRequestClose={props.handleClose}
      style={customStyles}
      ariaHideApp={false}
      contentLabel="Example Modal"
    >
      <button style={{float:"right"}} onClick={props.handleClose}>X</button>
      <div>
      <table>
          <thead>
            <tr>
              <th>Nome</th>
              <th>Loja</th>
              <th>Estado</th>
              <th>Cidade</th>
            </tr>
          </thead>
          <tbody>
            {representante.map(rep => (
              <tr key={Math.random().toString(36)}>
                <th >{rep.representante.nome}</th>
                <th >{rep.nome}</th>
                <th >{rep.cidade}</th>
                <th >{rep.estado}</th>
              </tr>
            ))}
          </tbody>
        </table>

      </div>
    </Modal>
  </div>
  );
}

function defaultConfig(arg0: string, arquivo: undefined, defaultConfig: any) {
  throw new Error('Function not implemented.');
}
