import FormCard from 'components/FormCard';
import { useParams } from 'react-router-dom';


function Form() {
    /* pega o parametro da requisição */
    const params = useParams();
    return (
       <FormCard movieId={`&{params.movieId}`}/>
    );
}
export default Form;