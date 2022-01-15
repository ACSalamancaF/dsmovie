import FormCard from 'components/FormCard';
import { useParams } from 'react-router-dom';


function Form() {
    /* pega o parametro da requisição */
    const paramss = useParams();

    return (
       <FormCard movieId={`&{paramss.movieId}`}/>
    );
}
export default Form;