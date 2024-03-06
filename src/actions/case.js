import api from '../utils/api';

export const getCaseList = (current, pageSize, query) => {
    try {
        return api.post('/submit/list', current, pageSize, query);
    } catch(err) {
        console.log(err);
    }
}